package com.dev.trabProjarq.dominio.services.Proxy;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="servico-plano-de-voo")
public interface MicroservicoDePlanosProxy {
    @PostMapping("/servico-plano-de-voo/plano-de-voo/novo")
    @CrossOrigin(origins = "*")
    ResponseEntity<PlanoDeVoo> cadastraPlano(@RequestBody PlanoVooDTO planoDTO);

    @DeleteMapping("/servico-plano-de-voo/plano-de-voo/cancela/{planoId}")
    @CrossOrigin(origins = "*")
    ResponseEntity<PlanoDeVoo> cancelaPlano(@PathVariable int planoId);
}
