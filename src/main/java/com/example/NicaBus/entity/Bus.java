package com.example.NicaBus.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cooperativa_id")
    private Cooperativa cooperativa;

    @Column(unique = true)
    private String placa;

    @Column(name = "capacidad_asientos")
    private Integer capacidadAsientos;

    private String tipo;

    private Boolean activo;
}