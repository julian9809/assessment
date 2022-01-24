package com.credibanco.assessment.card.service.interfaces;

import com.credibanco.assessment.card.dto.TransaccionDTO;

import org.springframework.stereotype.Service;

@Service
public interface ITransaccionService {
    
    void save(TransaccionDTO tarjeta);

}
