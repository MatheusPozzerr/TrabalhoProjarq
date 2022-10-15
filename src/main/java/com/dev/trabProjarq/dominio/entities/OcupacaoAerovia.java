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

	public Aerovia aerovia;

	public int slotAltitude;

	public int slotHorario;
	
    public OcupacaoAerovia() {
        
    }
    
}
