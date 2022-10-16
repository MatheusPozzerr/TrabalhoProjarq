package com.dev.trabProjarq.InterfacesAdaptadoras;

import java.sql.Date;
import java.util.List;

import com.dev.trabProjarq.Aplicacao.ConsultarRotas;
import com.dev.trabProjarq.Aplicacao.ConsultarSlots;
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
    private ConsultarSlots consultarSlots;

    @Autowired
    public TrafegoAereoMenu(ConsultarRotas consultarRotas, ConsultarSlots consultarSlots) {
        this.consultarRotas = consultarRotas;
        this.consultarSlots = consultarSlots;
    }

    @GetMapping("/rotas")
    @CrossOrigin(origins = "*")
    public List<RotaDTO> consultaRotasDestinos(@RequestParam("destino") String destino, @RequestParam("origem") String origem) {
        return this.consultarRotas.buscaRotasDestino(destino, origem);
    }

    @GetMapping("/altitudes-livres")
    @CrossOrigin(origins = "*")
    public List<Integer> consultaAltitudesLivres(int aeroviaId, Date data, Float horario, float velCruzeiro){
        return this.consultarSlots.consultaAltitudesLivres(aeroviaId, data, horario, velCruzeiro);
    }

}
