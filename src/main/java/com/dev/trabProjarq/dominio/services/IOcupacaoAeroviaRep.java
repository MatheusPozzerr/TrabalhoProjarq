package com.dev.trabProjarq.dominio.services;

import java.util.Date;
import java.util.List;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

public interface IOcupacaoAeroviaRep {
    List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, Date data, List<Integer> slotsHorarios);
}
