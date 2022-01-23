package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.credibanco.assessment.card.dto.CTarjetaDTO;
import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.model.TarjetaModel;
import com.credibanco.assessment.card.repository.TarjetaRepository;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;
import com.credibanco.assessment.card.util.MHelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarjetaService implements ITarjetasService {
    //@Autowired
    //TarjetaRepository tarjetaRepository;    

    //public TarjetaModel guardarTarjeta(TarjetaModel tarjeta){        
    //    return tarjetaRepository.save(tarjeta);
    //}

    @Autowired
    private TarjetaRepository tarjetaRepository;    

    @Override
    public List<TarjetaDTO> findAll() {

        List<TarjetaDTO> dto = new ArrayList<TarjetaDTO>();

        Iterable<TarjetaModel> tarjetas = this.tarjetaRepository.findAll(); 

        for (TarjetaModel tarjeta : tarjetas) {
            TarjetaDTO tarjetaDTO = MHelpers.modelMapper().map(tarjeta, TarjetaDTO.class);

            dto.add(tarjetaDTO);
        }

        return dto;
    }

    @Override
    public TarjetaDTO findByNumTarjeta(String numTarjeta) {

        Optional<TarjetaModel> tarjetas = this.tarjetaRepository.findByNumTarjeta(numTarjeta);

        if(!tarjetas.isPresent()) {
            return null;
        }

        return MHelpers.modelMapper().map(tarjetas.get(), TarjetaDTO.class);
    }

    @Override
    public void save(CTarjetaDTO tarjeta) {
        TarjetaModel tarjetas = MHelpers.modelMapper().map(tarjeta, TarjetaModel.class);
        
        this.tarjetaRepository.save(tarjetas);
    }

    @Override
    public void saveActivacion(TarjetaDTO tarjeta) {
        TarjetaModel tarjetas = MHelpers.modelMapper().map(tarjeta, TarjetaModel.class);

        this.tarjetaRepository.save(tarjetas);
        
    }

    @Override
    public TarjetaDTO findById(String id) {
        Optional<TarjetaModel> tarjetas = this.tarjetaRepository.findById(id);

        if(!tarjetas.isPresent()) {
            return null;
        }

        return MHelpers.modelMapper().map(tarjetas.get(), TarjetaDTO.class);
    }
}
