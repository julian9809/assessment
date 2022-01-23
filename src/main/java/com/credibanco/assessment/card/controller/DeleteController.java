package com.credibanco.assessment.card.controller;

import java.util.Map;

import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.exceptions.TarjetaException;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eliminarTarjeta")
public class DeleteController {
    
    @Autowired
    private ITarjetasService tarjetaService;

    @DeleteMapping(value = "/{id}/{numValidacion}/{numTarjeta}/delete")
    public ResponseEntity<Map<String, String>> deleteTarjeta(@PathVariable String id, @PathVariable String numValidacion, @PathVariable String numTarjeta) {
        
        TarjetaException tarjetaException = new TarjetaException();
        TarjetaDTO tarjeta = this.tarjetaService.findById(id);

        if (tarjeta == null) {
            return tarjetaException.eliNoTarjeta();
        } else if (!tarjeta.getNumValidacion().equals(numValidacion)) {
            return tarjetaException.eliNoTarjeta();
        } else if (!tarjeta.getNumTarjeta().equals(numTarjeta)) {
            return tarjetaException.eliNoTarjeta();
        }
        this.tarjetaService.deleteById(id);
        return tarjetaException.eliTarjeta();
    }

}
