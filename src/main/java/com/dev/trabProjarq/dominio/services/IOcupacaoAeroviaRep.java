package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

import java.util.List;

public interface IOcupacaoAeroviaRep {
    List<OcupacaoAerovia> findAll();
}
