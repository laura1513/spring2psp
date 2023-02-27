package com.example.spring2.repositorios;

import com.example.spring2.models.Piloto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PilotoRepositorio extends MongoRepository<Piloto, String> {
    Piloto findByNombre(String nombre);
    List<Piloto> findByNombreContaining(String nombre);
    List<Piloto> findByEquipoOrderByNumero(String equipo);
    void deleteById(String id);
    Optional<Piloto> findById(String id);
}
