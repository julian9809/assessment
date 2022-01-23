package com.credibanco.assessment.card.controller;

import java.util.Map;

import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.exceptions.TarjetaException;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activarTarjeta")
public class ActivarController {

    @Autowired
    private ITarjetasService tarjetaService;

    @GetMapping(value = "/by/{numTarjeta}/{numValidacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> findByNumTarjetaAndNumValidacion(@PathVariable("numTarjeta") String numTarjeta, @PathVariable("numValidacion") String numValidacion) {
        
        TarjetaException tarjetaException = new TarjetaException();
        TarjetaDTO tarjeta = this.tarjetaService.findByNumTarjeta(numTarjeta);

        if (tarjeta == null) {
            return tarjetaException.tarjetaNoExiste();
        }

        if (!tarjeta.getNumValidacion().equals(numValidacion)){
            return tarjetaException.numValInv();
        }

        String panEnmascarado = "";
        panEnmascarado = tarjeta.getNumTarjeta().substring(0,6)+"******"+tarjeta.getNumTarjeta().substring(12);

        tarjeta.setEstado("Enrolada");
        this.tarjetaService.saveActivacion(tarjeta);
        return tarjetaException.exitoActivacion(panEnmascarado);
    }

}
