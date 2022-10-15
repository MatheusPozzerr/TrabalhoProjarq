package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

import java.util.List;

public interface IPlanosRep {
    List<PlanoDeVoo> findPlanos();
}

