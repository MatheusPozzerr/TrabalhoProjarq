package com.dev.trabProjarq.dominio.services;
import java.util.List;

import org.springframework.stereotype.Component;

import  com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

@Component
public interface IPlanosRep {
    List<PlanoDeVoo> findPlanos();

}
