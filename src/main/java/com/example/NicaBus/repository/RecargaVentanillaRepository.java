package com.example.NicaBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NicaBus.entity.RecargaVentanilla;

import java.util.Optional;
import java.util.UUID;

public interface RecargaVentanillaRepository extends JpaRepository<RecargaVentanilla, UUID> {

    Optional<RecargaVentanilla> findByReferencia(String referencia);

}