package com.example.NicaBus.Controller;

import com.example.NicaBus.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TripController {

    private final TripService tripService;

    @GetMapping("/search")
    public ResponseEntity<?> buscarViajes(

            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam LocalDate fecha) {

        return ResponseEntity.ok(
                tripService.buscarViajes(origen, destino, fecha)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerViaje(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                tripService.obtenerViaje(id)
        );
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<?> obtenerAsientos(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                tripService.obtenerAsientos(id)
        );
    }

}