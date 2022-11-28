package com.example.servicoplanodevoo.dominio.services;

import com.example.servicoplanodevoo.Aplicacao.DTO.PlanoVooDTO;
import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicoDePlanos {
    private IPlanosRep planosRep;

    @Autowired
    public ServicoDePlanos(IPlanosRep planosRep) {
        this.planosRep = planosRep;    }

    public PlanoDeVoo cancelarPlanoDeVoo(int id) {
        PlanoDeVoo plano = this.planosRep.findPlanoById(id);
        if (plano != null) {
            plano.isCanceled = true;
            this.planosRep.salvaPlano(plano);
        }
        return plano;
    }

    public PlanoDeVoo autorizarPlanoDeVoo(PlanoVooDTO planoDeVooDTO) {
        PlanoDeVoo planoDeVoo = new PlanoDeVoo(planoDeVooDTO.horarioPartida, planoDeVooDTO.data, planoDeVooDTO.altitude, planoDeVooDTO.velCruzeiro, planoDeVooDTO.rotaId);
        return this.planosRep.salvaPlano(planoDeVoo);
    }
}