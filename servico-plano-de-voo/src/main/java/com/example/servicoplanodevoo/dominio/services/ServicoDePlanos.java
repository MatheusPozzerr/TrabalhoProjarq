package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.*;
import net.bytebuddy.asm.Advice;
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

    public PlanoDeVoo autorizarPlanoDeVoo(PlanoVooDTO planoVoo) {
        return this.planosRep.salvaPlano(planoDeVoo);
    }
}
