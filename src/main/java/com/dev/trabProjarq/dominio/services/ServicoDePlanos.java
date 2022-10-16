package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoDePlanos {
    private IPlanosRep planosRep;

    @Autowired
    public ServicoDePlanos(IPlanosRep planosRep) {
        this.planosRep = planosRep;
    }

    public List<PlanoDeVoo> consultaFodasse(Date data, int horario, int aeroviaId) {
        List<PlanoDeVoo> planos = this.planosRep.findPlanos().stream()
                .filter(plano -> plano.data.equals(data))
                .collect(Collectors.toList());

        List<PlanoDeVoo> planosFiltrados = new ArrayList<>();

        for (PlanoDeVoo plano : planos) {
            List<Aerovia> aerovias = plano.rota.aerovias;
            for (Aerovia aerovia : aerovias) {
                if (aerovia.id == aeroviaId) {
                    float tempoVoo = aerovia.distancia / plano.velCruzeiro;

                    int diff = (int)Math.ceil(Math.abs(plano.horarioPartida - tempoVoo));

                    List<Integer> slotsOcupados = new ArrayList<>();

                    slotsOcupados.add((int)Math.floor(plano.horarioPartida));
                    for (int i=0; i<diff; i++) {
                        slotsOcupados.add((int)Math.floor(plano.horarioPartida) + i);
                    }

                    planosFiltrados.add(plano);
                }
            }
        }

        return planosFiltrados;
    }

    public void verificarPlanoDeVoo() {

    }

    public void cancelarPlanoDeVoo() {

    }

    public void autorizarPlanoDeVoo() {

    }

}
