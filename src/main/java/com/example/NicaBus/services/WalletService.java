package com.example.NicaBus.services;

import com.example.NicaBus.entity.RecargaVentanilla;
import com.example.NicaBus.entity.Usuario;
import com.example.NicaBus.repository.RecargaVentanillaRepository;
import com.example.NicaBus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final UsuarioRepository usuarioRepository;
    private final RecargaVentanillaRepository recargaRepository;

    public BigDecimal obtenerSaldo(UUID usuarioId){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow();

        return usuario.getSaldo();

    }

    public RecargaVentanilla generarReferencia(UUID usuarioId,
                                               BigDecimal monto){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow();

        RecargaVentanilla recarga = new RecargaVentanilla();

        recarga.setUsuario(usuario);
        recarga.setMonto(monto);
        recarga.setEstado("PENDIENTE");

        recarga.setReferencia(
                "REF-" +
                        UUID.randomUUID()
                                .toString()
                                .substring(0,6)
                                .toUpperCase()
        );

        recarga.setFechaCreacion(LocalDateTime.now());

        recarga.setFechaExpiracion(
                LocalDateTime.now().plusHours(24)
        );

        return recargaRepository.save(recarga);

    }

}