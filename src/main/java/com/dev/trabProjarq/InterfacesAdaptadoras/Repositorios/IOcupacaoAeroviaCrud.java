package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

public interface IOcupacaoAeroviaCrud extends JpaRepository<OcupacaoAerovia, Integer> {


}
