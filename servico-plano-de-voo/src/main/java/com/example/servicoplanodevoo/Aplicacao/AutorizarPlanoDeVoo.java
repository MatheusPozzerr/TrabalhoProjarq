package com.example.servicoplanodevoo.Aplicacao;


import java.util.List;

import com.example.servicoplanodevoo.Aplicacao.DTO.PlanoVooDTO;
import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import com.example.servicoplanodevoo.dominio.services.ServicoDePlanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorizarPlanoDeVoo {

    private ServicoDePlanos servicoDePlanos;

    @Autowired
    public AutorizarPlanoDeVoo(ServicoDePlanos servicoDePlanos){
        this.servicoDePlanos = servicoDePlanos;
    }

    public PlanoDeVoo autorizaPlanoDeVoo(PlanoVooDTO planoVooDTO){
        return this.servicoDePlanos.autorizarPlanoDeVoo(planoVooDTO);
    }
}
