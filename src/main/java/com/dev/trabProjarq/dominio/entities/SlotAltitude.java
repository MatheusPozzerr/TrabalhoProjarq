package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;

@Entity
@Table(name = "SlotAltitude")
public class SlotAltitude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    public SlotAltitude(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
