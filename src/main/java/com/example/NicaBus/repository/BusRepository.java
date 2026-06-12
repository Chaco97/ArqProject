package com.example.NicaBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NicaBus.entity.Bus;

import java.util.UUID;

public interface BusRepository extends JpaRepository<Bus, UUID> {
}