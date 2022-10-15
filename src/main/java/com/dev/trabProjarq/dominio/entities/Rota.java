package com.dev.trabProjarq.dominio.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rota")
public class Rota {

    @ManyToMany
    @JoinTable(name = " rota_aerovia ",
    joinColumns =  @JoinColumn(name = " id_rota "),
    inverseJoinColumns = @JoinColumn(name = " id_aerovia "))
    public List<Aerovia> aerovias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public String nome;

    public RefGeo destino;
    public RefGeo origem;

    public Rota(){
        
    }
    
}
