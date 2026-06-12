package com.example.NicaBus.repository;
import com.example.NicaBus.entity.Cooperativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CooperativaRepository extends JpaRepository<Cooperativa, UUID> {
}