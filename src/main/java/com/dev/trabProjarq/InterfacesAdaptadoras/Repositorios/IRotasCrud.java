package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.dev.trabProjarq.dominio.entities.Rota;

public interface IRotasCrud extends JpaRepository<Rota, Integer> {


}
