package com.example.NicaBus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;



@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "boleto_id")
    private Boleto boleto;

    private String metodo;

    private BigDecimal monto;

    private String estado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
}