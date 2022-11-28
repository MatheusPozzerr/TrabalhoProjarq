package com.example.servicoplanodevoo.InterfacesAdaptadoras;

import com.example.servicoplanodevoo.Aplicacao.AutorizarPlanoDeVoo;
import com.example.servicoplanodevoo.Aplicacao.CancelaPlanoDeVoo;
import com.example.servicoplanodevoo.Aplicacao.DTO.PlanoVooDTO;
import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;

@RestController
@RequestMapping("/servico-plano-de-voo")
public class ServicoPlanoDeVoo {
    private CancelaPlanoDeVoo cancelaPlanoDeVoo;

    @Autowired
    public ServicoPlanoDeVoo(AutorizarPlanoDeVoo autorizarPlanoDeVoo, CancelaPlanoDeVoo cancelaPlanoDeVoo){
        this.cancelaPlanoDeVoo = cancelaPlanoDeVoo;
    }

    @DeleteMapping("/cancela/{planoId}")
    @CrossOrigin(origins = "*")
    public PlanoDeVoo cancelaPlanoDeVoo(@PathVariable int planoId){
        PlanoDeVoo plano = this.cancelaPlanoDeVoo.cancelaPlano(planoId);
        if (plano != null) {
            return plano;
        }
        return null;
    }
}
