package com.dev.trabProjarq.dominio.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class PlanoDeVoo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int id;

        public float horarioPartida;
        public LocalDate data;
        public float altitude;
        public float velCruzeiro;

        public int id_rota;

        public boolean isCanceled;

        public PlanoDeVoo() {

        }

        public PlanoDeVoo(float horarioPartida, LocalDate data, int altitude, float velCruzeiro, int id_rota) {
            this.horarioPartida = horarioPartida;
            this.data = data;
            this.altitude = altitude;
            this.velCruzeiro = velCruzeiro;
            this.id_rota = id_rota;
            this.isCanceled = false;
        }

}
