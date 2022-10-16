package com.dev.trabProjarq.dominio.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "ocupacao_aerovia")
public class OcupacaoAerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_aerovia")
	public Aerovia aerovia;

	public int slot_altitude;

	public int slot_horario;
	
    public OcupacaoAerovia() {
        
    }
    
}
