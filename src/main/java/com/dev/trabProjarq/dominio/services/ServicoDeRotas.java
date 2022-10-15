package com.dev.trabProjarq.dominio.services;

import java.util.List;
import java.util.stream.Collectors;

import com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios.RepositorioRotas;
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

    public List<Rota> consultaRotas(String origem, String destino) {
        System.out.println(rotasRep.findRotas().get(0).aerovias.get(0) + "VAPOVAPO");
        return rotasRep.findRotas().stream()
                .filter(rota -> rota.destino.nome.toLowerCase().equals(destino.toLowerCase())
                        && rota.origem.nome.toLowerCase().equals(origem.toLowerCase()))
                .collect(Collectors.toList());
    }
}
