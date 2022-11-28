package com.dev.trabProjarq.Aplicacao.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    public static PlanoVooDTO fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, PlanoVooDTO.class);
    }

    public String toJson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter().nullSafe());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        @Override
        public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
            if (localDate == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.value(localDate.toString());
        }

        @Override
        public LocalDate read(final JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return ZonedDateTime.parse(jsonReader.nextString()).toLocalDate();
        }
    }
}