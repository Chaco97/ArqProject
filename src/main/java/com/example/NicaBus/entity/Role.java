package com.example.NicaBus.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
        @Id
        @GeneratedValue
        private UUID id;

        @Column(nullable = false, unique = true)
        private String nombre;

}
