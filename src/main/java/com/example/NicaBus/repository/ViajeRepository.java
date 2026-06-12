package com.example.NicaBus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NicaBus.entity.Viaje;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ViajeRepository extends JpaRepository<Viaje, UUID> {

    List<Viaje> findByRutaOrigenAndRutaDestinoAndFechaViaje(
            String origen,
            String destino,
            LocalDate fecha
    );

}