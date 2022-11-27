package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.services.ServicoDePlanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CancelaPlanoDeVoo {
    private ServicoDePlanos servicoPlano;

    @Autowired
    public CancelaPlanoDeVoo(ServicoDePlanos servicoPlano){
        this.servicoPlano = servicoPlano;
    }

    public PlanoVooDTO cancelaPlano(int id){
        return this.servicoPlano.cancelarPlanoDeVoo(id);
    }
}
