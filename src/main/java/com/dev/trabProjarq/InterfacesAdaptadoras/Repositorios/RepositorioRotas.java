package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.dominio.entities.Rota;
import com.dev.trabProjarq.dominio.services.IRotasRep;

@Component
public class RepositorioRotas implements IRotasRep{
    private IRotasCrud rotasCrud;

    @Autowired
    public RepositorioRotas(IRotasCrud rotasCrud){
        this.rotasCrud = rotasCrud;
    }

    @Override
    public List<Rota> findRotas(){
        return this.rotasCrud.findAll();
    }

}
