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
    private int id;

    private Date data;
    private float altitude;
    private int velCruzeiro;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    private Rota rota;

    @ManyToOne
    @JoinColumn(name = "id_aeronave")
    private Aeronave aeronave;

    public PlanoDeVoo(){
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getVelCruzeiro() {
        return velCruzeiro;
    }

    public void setVelCruzeiro(int velCruzeiro) {
        this.velCruzeiro = velCruzeiro;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
