package com.dev.trabProjarq.dominio.services;
import java.util.List;


import  com.dev.trabProjarq.dominio.entities.Aeronave;

public interface IAeronavesRep{
    public List<Aeronave> getAeronaves();
    public Aeronave createAeronave(Aeronave aeronave);
    public Aeronave updateAeronave(Aeronave aeronave);
    public Aeronave deleteAeronave(Aeronave aeronave);
}
