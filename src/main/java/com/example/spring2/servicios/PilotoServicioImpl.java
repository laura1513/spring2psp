package com.example.spring2.servicios;

import com.example.spring2.models.Piloto;
import com.example.spring2.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoServicioImpl implements PilotoServicio{
    @Autowired
    private PilotoRepositorio pilotoRepositorio;
    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepositorio.findAll();
    }

    @Override
    public Piloto findPiloto(String id) {
        return pilotoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Piloto createPiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public Piloto updatePiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public Piloto deletePiloto(String id) {
        Piloto pilotoB = findPiloto(id);
        pilotoRepositorio.deleteById(id);
        return pilotoB;
    }
}
