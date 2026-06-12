package com.example.NicaBus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "rutas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id
    @GeneratedValue
    private UUID id;

    private String origen;

    private String destino;

    @Column(name = "terminal_origen")
    private String terminalOrigen;

    @Column(name = "terminal_destino")
    private String terminalDestino;

    @Column(name = "duracion_estimada")
    private String duracionEstimada;

    @Column(name = "precio_base")
    private BigDecimal precioBase;
}