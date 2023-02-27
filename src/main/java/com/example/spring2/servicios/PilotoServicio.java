package com.example.spring2.servicios;

import com.example.spring2.models.Piloto;

import java.util.List;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();
    Piloto findPiloto(String id);
    Piloto createPiloto(Piloto piloto);
    Piloto updatePiloto(Piloto piloto);
    Piloto deletePiloto(String id);
}
