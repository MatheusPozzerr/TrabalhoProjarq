package com.dev.trabProjarq.dominio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

@Service
public class ServicoDePlanos {
    private IPlanosRep planosRep;

    @Autowired
    public ServicoDePlanos(IPlanosRep planosRep) {
        this.planosRep = planosRep;
    }

    public void verificarPlanoDeVoo() {
    
    }

	public void cancelarPlanoDeVoo() {
    
    }

	public void autorizarPlanoDeVoo() {
    
    }

}
