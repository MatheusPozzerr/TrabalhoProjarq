package com.dev.trabProjarq.dominio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.trabProjarq.dominio.entities.Rota;

@Service
public class ServicoDeRotas {
    private IRotasRep rotasRep;

    @Autowired
    public ServicoDeRotas(IRotasRep rotasRep) {
        this.rotasRep = rotasRep;
    }

    public List<Rota> BuscaRotasDestino(String destino, String origem) {
        System.out.println(rotasRep.findRotas().get(0).getAerovias().get(0)+ "VAPOVAPO");
        return rotasRep.findRotas().stream()
                .filter(rota -> rota.getDestino().toLowerCase().equals(destino.toLowerCase())
                        && rota.getOrigem().toLowerCase().equals(origem.toLowerCase()))
                .collect(Collectors.toList());

    }

}
