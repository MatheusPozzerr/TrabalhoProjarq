package com.example.servicoplanodevoo.dominio.services;

import com.example.servicoplanodevoo.Aplicacao.AutorizarPlanoDeVoo;
import com.example.servicoplanodevoo.Aplicacao.DTO.PlanoVooDTO;
import com.example.servicoplanodevoo.dominio.entities.PlanoDeVoo;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private AutorizarPlanoDeVoo autorizarPlanoDeVoo;

    public void receiveMessage(String message) {
        if (message.charAt(0) == '{'){
            PlanoVooDTO planoDto = fromJson(message);
            autorizarPlanoDeVoo.autorizaPlanoDeVoo(planoDto);
            System.out.println("DTO received: "+planoDto);
        }else{
            System.out.println("Message received: ["+message+"]");
        }
    }

    private PlanoVooDTO fromJson(String json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        System.out.println("Transformando em objeto");
        PlanoVooDTO plano = gson.fromJson(json, PlanoVooDTO.class);
        System.out.println(plano);
        return plano;
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
