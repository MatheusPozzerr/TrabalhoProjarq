package com.example.servicoplanodevoo.dominio.services;

import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;

import java.util.List;

public interface IPlanosRep {
    List<PlanoDeVoo> findPlanos();

    PlanoDeVoo salvaPlano(PlanoDeVoo planoDeVoo);

    PlanoDeVoo findPlanoById(int planoId);

}