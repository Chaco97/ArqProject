package com.example.NicaBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NicaBus.entity.Pago;

import java.util.UUID;

public interface PagoRepository extends JpaRepository<Pago, UUID> {
}