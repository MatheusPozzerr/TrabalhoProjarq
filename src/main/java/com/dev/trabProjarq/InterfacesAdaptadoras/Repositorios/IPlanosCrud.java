package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

public interface IPlanosCrud extends JpaRepository<PlanoDeVoo, Integer> {


}
