package com.example.NicaBus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;



@Entity
@Table(name = "boletos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boleto {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "numero_asiento")
    private Integer numeroAsiento;

    private String estado;

    @Column(name = "codigo_qr")
    private String codigoQr;

    @Column(name = "expiracion_reserva")
    private LocalDateTime expiracionReserva;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
}