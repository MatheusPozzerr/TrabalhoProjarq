package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.dev.trabProjarq.dominio.entities.Aerovia;

public interface IAeroviaCrud extends JpaRepository<Aerovia, Integer> {


}
