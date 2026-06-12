package com.example.NicaBus.Controller;

import com.example.NicaBus.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/balance")
    public ResponseEntity<?> obtenerSaldo(
            @RequestParam UUID usuarioId) {

        return ResponseEntity.ok(
                walletService.obtenerSaldo(usuarioId)
        );
    }

    @PostMapping("/topup/branch")
    public ResponseEntity<?> generarReferencia(

            @RequestParam UUID usuarioId,
            @RequestParam BigDecimal monto) {

        return ResponseEntity.ok(
                walletService.generarReferencia(
                        usuarioId,
                        monto
                )
        );
    }

}