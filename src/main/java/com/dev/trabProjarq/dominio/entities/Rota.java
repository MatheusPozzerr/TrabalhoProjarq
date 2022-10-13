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
    private List<Aerovia> aerovias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;

    private String destino;
    private String origem;

    public Rota(){
        
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }



    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Aerovia> getAerovias() {
        return aerovias;
    }

    public void setAerovias(List<Aerovia> aerovias) {
        this.aerovias = aerovias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
