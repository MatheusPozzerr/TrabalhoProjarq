package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Rota;

import java.util.List;

public interface IRotasRep{
    List<Rota> findRotas();

    //public List<Rota> getAllRotas();
    //public List<Rota> getRotasDestinos(RefGeo origem, RefGeo destino);

}
