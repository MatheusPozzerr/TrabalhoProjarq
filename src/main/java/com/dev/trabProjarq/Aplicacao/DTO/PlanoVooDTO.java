package com.dev.trabProjarq.Aplicacao.DTO;

import java.time.LocalDate;

public class PlanoVooDTO {
    private int rotaId;

    private LocalDate data;

    private int horarioPartida;

    private float velocidadeCruzeiro;

    private int altitude;

    public PlanoVooDTO(int rotaId, LocalDate data, int horarioPartida, float velocidadeCruzeiro, int altitude) {
        this.rotaId = rotaId;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
        this.altitude = altitude;
    }

    public int getRotaId() {
        return rotaId;
    }

    public LocalDate getData() {
        return data;
    }

    public int getHorarioPartida() {
        return horarioPartida;
    }

    public float getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public int getAltitude() {
        return altitude;
    }
}
