package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;
import com.dev.trabProjarq.dominio.entities.Rota;
import com.dev.trabProjarq.dominio.entities.SlotAltitude;
import com.dev.trabProjarq.dominio.services.ServicoDePlanos;
import com.dev.trabProjarq.dominio.services.ServicoDeRotas;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ConsultarSlots {
    private ServicoDePlanos servicoDePlanos;

    @Autowired
    public ConsultarSlots(ServicoDePlanos servicoDePlanos) {
        this.servicoDePlanos = servicoDePlanos;
    }

    public List<SlotAltitude> consultaAltitudesLivres(int horario, float velocidade){
        List<Rota> altitudes = this.servicoDePlanos.verificarPlanoDeVoo(horario, velocidade);
        List<RotaDTO> altitudesSelecionadasDTO = new ArrayList<>();
        altitudesSelecionadasDTO.forEach( rota -> altitudesSelecionadasDTO.add(new RotaDTO(rota)));
        return altitudesSelecionadasDTO;
    }
}
