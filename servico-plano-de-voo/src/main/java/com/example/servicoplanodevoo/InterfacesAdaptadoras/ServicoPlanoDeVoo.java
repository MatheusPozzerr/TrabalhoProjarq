package com.example.servicoplanodevoo.InterfacesAdaptadoras;

import com.example.servicoplanodevoo.Aplicacao.AutorizarPlanoDeVoo;
import com.example.servicoplanodevoo.Aplicacao.CancelaPlanoDeVoo;
import com.example.servicoplanodevoo.Aplicacao.DTO.PlanoVooDTO;
import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plano-de-voo")
public class ServicoPlanoDeVoo {
    private AutorizarPlanoDeVoo autorizarPlanoDeVoo;
    private CancelaPlanoDeVoo cancelaPlanoDeVoo;

    @Autowired
    public ServicoPlanoDeVoo(AutorizarPlanoDeVoo autorizarPlanoDeVoo, CancelaPlanoDeVoo cancelaPlanoDeVoo){
        this.autorizarPlanoDeVoo = autorizarPlanoDeVoo;
        this.cancelaPlanoDeVoo = cancelaPlanoDeVoo;
    }

    @PostMapping("/novo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanoDeVoo>cadastraPlano(@RequestBody PlanoVooDTO planoDTO){
        PlanoDeVoo plano = this.autorizarPlanoDeVoo.autorizaPlanoDeVoo(planoDTO);
        if (plano != null) {
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/cancela/{planoId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanoDeVoo> cancelaPlano(@PathVariable int planoId){
        PlanoDeVoo plano = this.cancelaPlanoDeVoo.cancelaPlano(planoId);
        if (plano != null) {
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
