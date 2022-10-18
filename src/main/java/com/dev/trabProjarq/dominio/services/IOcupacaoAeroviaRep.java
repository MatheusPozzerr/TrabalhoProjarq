package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

import java.time.LocalDate;
import java.util.List;

public interface IOcupacaoAeroviaRep {
    List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, LocalDate data, List<Float> slotsHorarios);

    OcupacaoAerovia ocupa(OcupacaoAerovia ocupacaoAerovia);

    void removeOcupacao(OcupacaoAerovia ocupacaoAerovia);
}
