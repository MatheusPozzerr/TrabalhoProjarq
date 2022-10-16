package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plano_voo")
public class PlanoDeVoo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public float horarioPartida;
    public LocalDate data;
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
