package com.dev.trabProjarq.InterfacesAdaptadoras.Proxy;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="servico-plano-de-voo")
public interface DeletaPlanoProxy {
    @DeleteMapping("/servico-plano-de-voo/cancela/{planoId}")
    public PlanoDeVoo cancelaPlanoDeVoo(@PathVariable int planoId);
}