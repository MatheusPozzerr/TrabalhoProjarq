package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;

@Entity
@Table(name = "slot_horario")
public class SlotHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int horario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "aerovia_id")
    private Aerovia aerovia;

    public SlotHorario(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Aerovia getAerovia() {
        return aerovia;
    }

    public void setAerovia(Aerovia aerovia) {
        this.aerovia = aerovia;
    }
    
}
