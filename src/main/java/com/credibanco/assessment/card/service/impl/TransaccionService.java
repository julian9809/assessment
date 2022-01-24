package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.dto.TransaccionDTO;
import com.credibanco.assessment.card.model.TransaccionModel;
import com.credibanco.assessment.card.repository.TransaccionRepository;
import com.credibanco.assessment.card.service.interfaces.ITransaccionService;
import com.credibanco.assessment.card.util.MHelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransaccionService implements ITransaccionService {
    
    @Autowired 
    private TransaccionRepository transaccionRepository;

    @Override
    public void save(TransaccionDTO transaccion) {
        TransaccionModel transaccions = MHelpers.modelMapper().map(transaccion, TransaccionModel.class);
        
        this.transaccionRepository.save(transaccions);
    }

    

}
