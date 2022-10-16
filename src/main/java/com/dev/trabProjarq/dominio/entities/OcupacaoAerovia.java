package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "ocupacao_aerovia")
public class OcupacaoAerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_aerovia")
	public Aerovia aerovia;

	public int slot_altitude;

	public int slot_horario;
	
    public OcupacaoAerovia() {
        
    }
    
}
