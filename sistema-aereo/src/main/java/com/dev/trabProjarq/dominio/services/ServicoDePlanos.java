package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.entities.Rota;
import com.dev.trabProjarq.dominio.services.Proxy.MicroservicoDePlanosProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicoDePlanos {
    private IRotasRep rotasRep;
    private IOcupacaoAeroviaRep ocupacaoRep;
    private MicroservicoDePlanosProxy microservicoDePlanosProxy;

    @Autowired
    public ServicoDePlanos(IRotasRep rotasRep, IOcupacaoAeroviaRep ocupacaoRep, MicroservicoDePlanosProxy microservicoDePlanosProxy) {
        this.rotasRep = rotasRep;
        this.ocupacaoRep = ocupacaoRep;
        this.microservicoDePlanosProxy = microservicoDePlanosProxy;
    }

    public List<Aerovia> verificarPlanoDeVoo(PlanoVooDTO propostaPlano) {
        Rota rotaEscolhida = this.rotasRep.findById(propostaPlano.rotaId);

        List<Aerovia> trechosComProblemas = new ArrayList<>();

        for (Aerovia aerovia: rotaEscolhida.aerovias) {
            List<Float> slotsHorarios = new ArrayList<>();

            float tempoVoo = aerovia.distancia / propostaPlano.velCruzeiro;

            tempoVoo = tempoVoo + propostaPlano.horarioPartida;
            
            slotsHorarios.add((float) Math.floor(propostaPlano.horarioPartida));

            while(tempoVoo > propostaPlano.horarioPartida){
                slotsHorarios.add((float) Math.floor(propostaPlano.horarioPartida));
                tempoVoo--;
            }

            List<OcupacaoAerovia> ocupadas = this.ocupacaoRep.findOcupadasSlots(
                aerovia.id, 
                propostaPlano.data, 
                slotsHorarios
            );
            for(OcupacaoAerovia ocupacao: ocupadas) {
                if (ocupacao.slot_altitude == propostaPlano.altitude) {
                    trechosComProblemas.add(aerovia);
                }
            }
        }

        return trechosComProblemas;
    }

    public PlanoVooDTO cancelarPlanoDeVoo(int id) {
        // TODO: chamar MS para cancelar aqui
        //PlanoDeVoo plano = this.planosRep.findPlanoById(id);
        PlanoVooDTO planoDeVoo = microservicoDePlanosProxy.cancelaPlano(id);
        if(planoDeVoo != null){
            Rota rota = this.rotasRep.findById(planoDeVoo.rotaId);
            List<Aerovia> aerovias = rota.aerovias;

            for(Aerovia aerovia: aerovias) {
                List<Float> slotsHorarios = new ArrayList<>();

                float tempoVoo = aerovia.distancia / planoDeVoo.velCruzeiro;

                for (int i = 0; i < tempoVoo; i++) {
                    slotsHorarios.add((float) Math.floor(planoDeVoo.horarioPartida+i));
                }
                List<OcupacaoAerovia> slotsOcupados = this.ocupacaoRep.findOcupadasSlots(aerovia.id, planoDeVoo.data, slotsHorarios).stream()
                        .filter(o -> o.slot_altitude == planoDeVoo.altitude)
                        .collect(Collectors.toList());

                for (OcupacaoAerovia slot : slotsOcupados) {
                    this.ocupacaoRep.removeOcupacao(slot);
                }
            }
        }
        return planoDeVoo;
    }

    public PlanoVooDTO autorizarPlanoDeVoo(PlanoVooDTO planoVoo) {
        if(this.verificarPlanoDeVoo(planoVoo).isEmpty()){
            Rota rota = this.rotasRep.findById(planoVoo.rotaId);
            // PlanoDeVoo planoDeVoo = new PlanoDeVoo(planoVoo.horarioPartida, planoVoo.data, planoVoo.altitude, planoVoo.velCruzeiro, rota);
            for(Aerovia aerovia: rota.aerovias) {
                List<Float> slotsHorarios = new ArrayList<>();

                float tempoVoo = aerovia.distancia / planoVoo.velCruzeiro;

                for(int i=0; i<tempoVoo; i++){
                    slotsHorarios.add((float) Math.floor(planoVoo.horarioPartida+ i));
                }

                for(float slot: slotsHorarios){
                    LocalDate date = planoVoo.data;
                    if(slot > 24){
                        slot = slot - 24;
                        date = date.plusDays(1);
                    }
                    OcupacaoAerovia ocupacaoAerovia = new OcupacaoAerovia(date, aerovia, (int)planoVoo.altitude, (int)slot);
                    this.ocupacaoRep.ocupa(ocupacaoAerovia);
                }
            }
            // TODO: chamar o outro MS aqui
            PlanoVooDTO planoDeVoo = microservicoDePlanosProxy.cadastraPlano(planoVoo);
            //return this.planosRep.salvaPlano(planoVoo);
            return planoDeVoo;
        }
        return null;
    }
}
