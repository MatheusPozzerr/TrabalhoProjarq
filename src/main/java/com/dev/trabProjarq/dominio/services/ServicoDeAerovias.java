package com.dev.trabProjarq.dominio.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

@Service
public class ServicoDeAerovias {
    private IAeroviaRep aeroviaRep;
    private IOcupacaoAeroviaRep ocupacaoRep;

    @Autowired
    public ServicoDeAerovias(IAeroviaRep aeroviaRep, IOcupacaoAeroviaRep ocupacaoRep) {
        this.aeroviaRep = aeroviaRep;
        this.ocupacaoRep = ocupacaoRep;
    }

    public void consultaSlotsLivres(int aeroviaId, Date data, int horario, float velCruzeiro){
        Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        List<Integer> slotsTodos = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> slotsHorarios = new ArrayList<>();

        float tempoVoo = aerovia.distancia / velCruzeiro;

        List<OcupacaoAerovia> ocupadas = this.ocupacaoRep.findOcupadasSlots(aeroviaId, data, slotsHorarios);
        // Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        // if (aerovia == null)
        //     return;

        // float tempoVoo = aerovia.distancia / velocidade;

        
        // List<PlanoDeVoo> planos = servicoPlanos.consultaFodasse(data, aerovia.id);
         
    }

    public void consultaSlots(Date data, List<Integer> slotsHorarios) {

    }

}
