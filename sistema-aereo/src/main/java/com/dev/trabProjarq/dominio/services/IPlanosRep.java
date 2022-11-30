package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

public interface IPlanosRep {
    void autorizarPlanoDeVoo(PlanoVooDTO planoVoo);

    PlanoDeVoo cancelaPlanoDeVoo(int id);
}