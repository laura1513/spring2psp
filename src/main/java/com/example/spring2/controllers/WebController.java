package com.example.spring2.controllers;

import com.example.spring2.models.Piloto;
import com.example.spring2.servicios.PilotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {
    @Autowired
    private PilotoServicio pilotoServicio;

    @GetMapping("/api/pilotos")
    public ResponseEntity<List<Piloto>> getPilotos() {
        return ResponseEntity.ok(pilotoServicio.findAllPilotos());
    }

    @GetMapping("/api/pilotos/{id}")
    public ResponseEntity<Piloto> getPiloto(@PathVariable("id") String id) {
        return ResponseEntity.ok(pilotoServicio.findPiloto(id));
    }
    @PostMapping(value = "/api/pilotos")
    public ResponseEntity<Piloto> createPiloto(@RequestBody Piloto piloto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoServicio.createPiloto(piloto));
    }
    @PutMapping(value = "/api/pilotos/{id}")
    public ResponseEntity<Piloto> updatePiloto(@PathVariable("id") String id, @RequestBody Piloto piloto) {
        Piloto pilotoExist = pilotoServicio.findPiloto(piloto.getId());

        if (pilotoExist == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoServicio.updatePiloto(piloto));
    }

    @DeleteMapping(value = "/api/pilotos/{id}")
    public ResponseEntity<Piloto> deletePiloto(@PathVariable("id") String id) {
        return ResponseEntity.ok(pilotoServicio.deletePiloto(id));
    }
}
