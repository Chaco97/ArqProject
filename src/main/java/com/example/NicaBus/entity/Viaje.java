package com.example.NicaBus.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;



@Entity
@Table(name = "viajes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Viaje {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @Column(name = "fecha_viaje")
    private LocalDate fechaViaje;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(name = "hora_llegada_estimada")
    private LocalDateTime horaLlegadaEstimada;

    @Column(name = "precio_actual")
    private BigDecimal precioActual;

    private String estado;
}