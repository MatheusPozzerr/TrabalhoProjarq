package com.example.servicoplanodevoo.InterfacesAdaptadoras.Repositorios;


import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanosCrud extends JpaRepository<PlanoDeVoo, Integer> {


}
