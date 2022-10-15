package com.dev.trabProjarq.dominio.services;

import java.util.Optional;

import com.dev.trabProjarq.dominio.entities.Aerovia;

public interface IAeroviaRep {
    Optional<Aerovia> findAerovia(int aeroviaId);
}
