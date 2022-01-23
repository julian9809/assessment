package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;

import com.credibanco.assessment.card.model.TarjetaModel;
import com.credibanco.assessment.card.repository.TarjetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {
    @Autowired
    TarjetaRepository tarjetaRepository;

    public ArrayList<TarjetaModel> obtenerTarjetas(){
        return (ArrayList<TarjetaModel>) tarjetaRepository.findAll();
    }

    public TarjetaModel guardarTarjeta(TarjetaModel tarjeta){        
        return tarjetaRepository.save(tarjeta);
    }
}
