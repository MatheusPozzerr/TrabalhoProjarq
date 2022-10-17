package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.entities.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ServicoDePlanos {
    private IPlanosRep planosRep;
    private IRotasRep rotasRep;
    private IOcupacaoAeroviaRep ocupacaoRep;

    @Autowired
    public ServicoDePlanos(IPlanosRep planosRep, IRotasRep rotasRep, IOcupacaoAeroviaRep ocupacaoRep) {
        this.planosRep = planosRep;
        this.rotasRep = rotasRep;
        this.ocupacaoRep = ocupacaoRep;
    }

    // public List<PlanoDeVoo> consultaFodasse(Date data, int horario, int aeroviaId) {
    //     List<PlanoDeVoo> planos = this.planosRep.findPlanos().stream()
    //             .filter(plano -> plano.data.equals(data))
    //             .collect(Collectors.toList());

    //     List<PlanoDeVoo> planosFiltrados = new ArrayList<>();

    //     for (PlanoDeVoo plano : planos) {
    //         List<Aerovia> aerovias = plano.rota.aerovias;
    //         for (Aerovia aerovia : aerovias) {
    //             if (aerovia.id == aeroviaId) {
    //                 float tempoVoo = aerovia.distancia / plano.velCruzeiro;

    //                 int diff = (int)Math.ceil(Math.abs(plano.horarioPartida - tempoVoo));

    //                 List<Integer> slotsOcupados = new ArrayList<>();

    //                 slotsOcupados.add((int)Math.floor(plano.horarioPartida));
    //                 for (int i=0; i<diff; i++) {
    //                     slotsOcupados.add((int)Math.floor(plano.horarioPartida) + i);
    //                 }

    //                 planosFiltrados.add(plano);
    //             }
    //         }
    //     }

    //     return planosFiltrados;
    // }

    public List<Aerovia> verificarPlanoDeVoo(PlanoVooDTO propostaPlano) {
        /**
         * Verificar um plano de voo: verifica se um plano de voo pode ser liberado. 
         *      - O plano de  voo  deve  indicar  a  data,  horário  e  o  número  do  voo,  a  rota  escolhida,  a 
         *          velocidade de cruzeiro e a altitude que pretende ser utilizada. 
         *      - Retorna os trechos com problema ou um ok, conforme o caso. 
         */
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

        // TODO: return OK
        return trechosComProblemas;
    }

    public void cancelarPlanoDeVoo() {

    }

    public void autorizarPlanoDeVoo() {

    }

}
