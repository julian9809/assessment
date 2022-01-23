package com.credibanco.assessment.card.service.interfaces;

import java.util.List;

import com.credibanco.assessment.card.dto.CTarjetaDTO;
import com.credibanco.assessment.card.dto.TarjetaDTO;

import org.springframework.stereotype.Service;

@Service
public interface ITarjetasService {
    
    List<TarjetaDTO> findAll();

    TarjetaDTO findByNumTarjeta(String numTarjeta);

    void save(CTarjetaDTO tarjeta);

    void saveActivacion(TarjetaDTO tarjeta);

}
