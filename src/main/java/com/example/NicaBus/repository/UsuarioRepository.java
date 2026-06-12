package com.example.NicaBus.repository;
import com.example.NicaBus.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByTelefono(String telefono);

    boolean existsByCorreo(String correo);

    boolean existsByTelefono(String telefono);

}