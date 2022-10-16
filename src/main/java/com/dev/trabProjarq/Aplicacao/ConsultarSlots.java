package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;
import com.dev.trabProjarq.dominio.entities.Rota;
import com.dev.trabProjarq.dominio.entities.SlotAltitude;
import com.dev.trabProjarq.dominio.services.ServicoDeAerovias;
import com.dev.trabProjarq.dominio.services.ServicoDePlanos;
import com.dev.trabProjarq.dominio.services.ServicoDeRotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultarSlots {
    private ServicoDeAerovias servicoDeAerovias;

    @Autowired
    public ConsultarSlots(ServicoDeAerovias servicoDeAerovias) {
        this.servicoDeAerovias = servicoDeAerovias;
    }

    public List<Integer> consultaAltitudesLivres(int aeroviaId, Date data, Float horario, float velCruzeiro){
        return this.servicoDeAerovias.consultaSlotsLivres(aeroviaId, data, horario, velCruzeiro);
    }

}
