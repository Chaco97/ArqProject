package com.example.NicaBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NicaBus.entity.Ruta;

import java.util.List;
import java.util.UUID;

public interface RutaRepository extends JpaRepository<Ruta, UUID> {

    List<Ruta> findByOrigenAndDestino(
            String origen,
            String destino
    );

}