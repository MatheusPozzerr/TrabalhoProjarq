package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.services.ServicoDePlanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorizarPlanoDeVoo {

    private ServicoDePlanos servicoDePlanos;

    @Autowired
    public AutorizarPlanoDeVoo(ServicoDePlanos servicoDePlanos){
        this.servicoDePlanos = servicoDePlanos;
    }

    public void autorizaPlanoDeVoo(PlanoVooDTO planoVooDTO){
        this.servicoDePlanos.autorizarPlanoDeVoo(planoVooDTO);
    }
}
