package com.dev.trabProjarq.dominio.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

@Service
public class ServicoDeAerovias {
    private ServicoDePlanos servicoPlanos;
    private IAeroviaRep aeroviaRep;

    @Autowired
    public ServicoDeAerovias(IAeroviaRep aeroviaRep,ServicoDePlanos servicoPlanos) {
        this.servicoPlanos = servicoPlanos;
        this.aeroviaRep = aeroviaRep;
    }

    public void consultaSlotsLivres(int aeroviaId, Date data, int horario, float velocidade){
        Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        if (aerovia == null)
            return;

        float tempoVoo = aerovia.distancia / velocidade;

        
        List<PlanoDeVoo> planos = servicoPlanos.consultaFodasse(data, aerovia.id);
         
    }

}
