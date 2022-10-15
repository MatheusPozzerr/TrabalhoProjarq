package com.dev.trabProjarq.dominio.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plano_voo")
public class PlanoDeVoo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public Date data;
    public float altitude;
    public int velCruzeiro;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    public Rota rota;

    @ManyToOne
    @JoinColumn(name = "id_aeronave")
    public Aeronave aeronave;

    public PlanoDeVoo(){
        
    }

}
