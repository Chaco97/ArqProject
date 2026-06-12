package com.example.NicaBus.services;

import com.example.NicaBus.entity.Boleto;
import com.example.NicaBus.entity.Usuario;
import com.example.NicaBus.entity.Viaje;
import com.example.NicaBus.repository.BoletoRepository;
import com.example.NicaBus.repository.UsuarioRepository;
import com.example.NicaBus.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final UsuarioRepository usuarioRepository;
    private final ViajeRepository viajeRepository;
    private final BoletoRepository boletoRepository;

    public Boleto crearReserva(UUID usuarioId,
                               UUID viajeId,
                               Integer numeroAsiento){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow();

        Viaje viaje = viajeRepository.findById(viajeId)
                .orElseThrow();

        Boleto boleto = new Boleto();

        boleto.setUsuario(usuario);
        boleto.setViaje(viaje);
        boleto.setNumeroAsiento(numeroAsiento);
        boleto.setEstado("RESERVADO");
        boleto.setCreadoEn(LocalDateTime.now());

        return boletoRepository.save(boleto);

    }

}