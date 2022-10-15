package com.dev.trabProjarq.InterfacesAdaptadoras;

import java.util.List;

import com.dev.trabProjarq.Aplicacao.ConsultarRotas;
import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trafegoMenu")
public class TrafegoAereoMenu {
    private ConsultarRotas consultarRotas;

    @Autowired
    public TrafegoAereoMenu(ConsultarRotas consultarRotas) {
        this.consultarRotas = consultarRotas;
    }

    @GetMapping("/rotas")
    @CrossOrigin(origins = "*")
    public List<RotaDTO> consultaRotasDestinos(@RequestParam("destino") String destino, @RequestParam("origem") String origem) {
        return this.consultarRotas.buscaRotasDestino(destino, origem);
    }

}
