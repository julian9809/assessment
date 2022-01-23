package com.credibanco.assessment.card.controller;

import java.util.Map;

import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.exceptions.TarjetaException;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultarTarjeta")
public class ConsultarController {
    
    @Autowired
    private ITarjetasService tarjetaService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Map<String, String>> consultarTarjeta(@RequestParam String id) {

        TarjetaException tarjetaException = new TarjetaException();        
        TarjetaDTO tarjeta = this.tarjetaService.findById(id);

        if (tarjeta == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String panEnmascarado = "";
        panEnmascarado = tarjeta.getNumTarjeta().substring(0,6)+"******"+tarjeta.getNumTarjeta().substring(12);

        return tarjetaException.consultaExitosa(panEnmascarado,tarjeta.getTitular(),tarjeta.getCedula(),tarjeta.getTelefono(),tarjeta.getEstado());
    }
}
