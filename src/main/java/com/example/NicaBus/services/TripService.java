package com.example.NicaBus.services;

import com.example.NicaBus.entity.Boleto;
import com.example.NicaBus.entity.Viaje;
import com.example.NicaBus.repository.BoletoRepository;
import com.example.NicaBus.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final ViajeRepository viajeRepository;
    private final BoletoRepository boletoRepository;

    public List<Viaje> buscarViajes(String origen,
                                    String destino,
                                    LocalDate fecha){

        return viajeRepository.findByRutaOrigenAndRutaDestinoAndFechaViaje(
                origen,
                destino,
                fecha
        );
    }

    public Viaje obtenerViaje(UUID id){

        return viajeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Viaje no encontrado"));
    }

    public List<Boleto> obtenerAsientos(UUID viajeId){

        Viaje viaje = obtenerViaje(viajeId);

        return boletoRepository.findByViaje(viaje);
    }

}