package com.dev.trabProjarq.dominio.services;
import java.util.List;

import org.springframework.stereotype.Component;

import  com.dev.trabProjarq.dominio.entities.Rota;

@Component
public interface IRotasRep{
    List<Rota> findRotas();

    //public List<Rota> getAllRotas();
    //public List<Rota> getRotasDestinos(RefGeo origem, RefGeo destino);

}
