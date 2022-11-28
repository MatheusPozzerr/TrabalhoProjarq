package com.example.servicoplanodevoo.Aplicacao.DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class PlanoVooDTO {
    public int rotaId;

    public LocalDate data;

    public float horarioPartida;

    public float velCruzeiro;

    public int altitude;

    public PlanoVooDTO(int rotaId, LocalDate data, float horarioPartida, float velCruzeiro, int altitude) {
        this.rotaId = rotaId;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.velCruzeiro = velCruzeiro;
        this.altitude = altitude;
    }
}