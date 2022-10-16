package com.dev.trabProjarq.dominio.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

@Service
public class ServicoDeAerovias {
    private IAeroviaRep aeroviaRep;
    private IOcupacaoAeroviaRep ocupacaoRep;

    @Autowired
    public ServicoDeAerovias(IAeroviaRep aeroviaRep, IOcupacaoAeroviaRep ocupacaoRep) {
        this.aeroviaRep = aeroviaRep;
        this.ocupacaoRep = ocupacaoRep;
    }

    public List<Integer> consultaSlotsLivres(int aeroviaId, Date data, Float horario, float velCruzeiro){
        Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        List<Integer> slotsTodos = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Float> slotsHorarios = new ArrayList<>();

        Float tempoVoo = aerovia.distancia / velCruzeiro;

        tempoVoo = tempoVoo + horario;
        
        slotsHorarios.add((float) Math.floor(horario));

        while(tempoVoo > horario){
            slotsHorarios.add((float) Math.floor(horario));
            tempoVoo--;
        } 
        
        slotsHorarios.add((float) Math.ceil(horario));

        List<OcupacaoAerovia> ocupadas = this.ocupacaoRep.findOcupadasSlots(aeroviaId, data, slotsHorarios);

        List<Integer> altitudesOcupadas = ocupadas.stream().map( ocupaAerovia -> ocupaAerovia.slot_altitude).collect(Collectors.toList());

        slotsTodos = slotsTodos.stream().filter(slotsLivres -> !altitudesOcupadas.contains(slotsLivres)).collect(Collectors.toList());

        return slotsTodos;
        // Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        // if (aerovia == null)
        //     return;

        // float tempoVoo = aerovia.distancia / velocidade;

        
        // List<PlanoDeVoo> planos = servicoPlanos.consultaFodasse(data, aerovia.id);
         
    }

    public void consultaSlots(Date data, List<Integer> slotsHorarios) {

    }

}
