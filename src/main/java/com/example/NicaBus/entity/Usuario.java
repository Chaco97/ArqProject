package com.example.NicaBus.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Role rol;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    private String cedula;

    @Column(unique = true)
    private String correo;

    @Column(unique = true)
    private String telefono;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
}