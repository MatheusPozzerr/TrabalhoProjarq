package com.dev.trabProjarq.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;
import com.dev.trabProjarq.dominio.entities.Rota;

import com.dev.trabProjarq.dominio.services.ServicoDeRotas;


@Component
public class ConsultarRotas {
    private ServicoDeRotas servicoRotas;

    @Autowired
    public ConsultarRotas(ServicoDeRotas servicoRotas) {
        this.servicoRotas = servicoRotas;
    }

    public List<RotaDTO> BuscaRotasDestino(String destino, String origem){
        List<Rota> rotasSelecionadas = this.servicoRotas.BuscaRotasDestino(destino, origem);
        List<RotaDTO> rotasSelecionadasDto = new ArrayList<>();
        rotasSelecionadas.forEach( rota -> rotasSelecionadasDto.add(new RotaDTO(rota.getNome(), rota.getId(), rota.getAerovias())));
        return rotasSelecionadasDto;
    }
    
}
