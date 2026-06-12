package com.example.NicaBus.repository;
import com.example.NicaBus.entity.Viaje;
import com.example.NicaBus.entity.Usuario;
import com.example.NicaBus.entity.Boleto;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BoletoRepository extends JpaRepository<Boleto, UUID> {

    List<Boleto> findByViaje(Viaje viaje);

    List<Boleto> findByUsuario(Usuario usuario);

}