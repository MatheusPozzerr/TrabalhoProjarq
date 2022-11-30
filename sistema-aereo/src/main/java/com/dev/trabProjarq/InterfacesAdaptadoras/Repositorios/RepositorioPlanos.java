package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.InterfacesAdaptadoras.Proxy.DeletaPlanoProxy;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import com.dev.trabProjarq.dominio.services.IPlanosRep;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPlanos implements IPlanosRep {
    private RabbitTemplate rabbitTemplate;

    private DeletaPlanoProxy cancelaPlanoProxy;

    @Autowired
    public RepositorioPlanos(RabbitTemplate rabbitTemplate, DeletaPlanoProxy deletaPlanoProxy) {
        this.rabbitTemplate = rabbitTemplate;
        this.cancelaPlanoProxy = deletaPlanoProxy;
    }

    @Override
    public void autorizarPlanoDeVoo(PlanoVooDTO planoVoo) {
        String json = planoVoo.toJson();
        rabbitTemplate.convertAndSend("spring-boot-exchange", "servico", json);
    }

    @Override
    public PlanoDeVoo cancelaPlanoDeVoo(int id) {
        return this.cancelaPlanoProxy.cancelaPlanoDeVoo(id);
    }
}
