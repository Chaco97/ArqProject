package com.example.NicaBus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;


@Entity
@Table(name = "cooperativas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cooperativa {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    private String ruc;

    @Column(name = "correo_contacto")
    private String correoContacto;

    @Column(name = "telefono_contacto")
    private String telefonoContacto;
}