package com.example.NicaBus.Controller;

import com.example.NicaBus.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> reservar(

            @RequestParam UUID usuarioId,
            @RequestParam UUID viajeId,
            @RequestParam Integer numeroAsiento) {

        return ResponseEntity.ok(
                bookingService.crearReserva(
                        usuarioId,
                        viajeId,
                        numeroAsiento
                )
        );
    }

}