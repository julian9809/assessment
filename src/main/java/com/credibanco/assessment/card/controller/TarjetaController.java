package com.credibanco.assessment.card.controller;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

import com.credibanco.assessment.card.dto.CTarjetaDTO;
import com.credibanco.assessment.card.exceptions.TarjetaException;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crearTarjeta")
public class TarjetaController {
    @Autowired
    private ITarjetasService tarjetaService;

    
    @PostMapping()
    public ResponseEntity<Map<String, String>> guardarTarjeta(@RequestBody CTarjetaDTO tarjeta){

        TarjetaException tarjetaException = new TarjetaException();

        if (tarjeta.getNumTarjeta() == null || tarjeta.getNumTarjeta().isEmpty() || tarjeta.getNumTarjeta().length() < 16 || tarjeta.getNumTarjeta().length() > 16) {
            return tarjetaException.error();
        }        

        tarjeta.setId(getSHA256(tarjeta.getNumTarjeta()));
        tarjeta.setNumValidacion(genNumValidacion());
        tarjeta.setEstado("Creada");

        String panEnmascarado = "";
        panEnmascarado = tarjeta.getNumTarjeta().substring(0,6)+"******"+tarjeta.getNumTarjeta().substring(12);

        this.tarjetaService.save(tarjeta);

        return tarjetaException.exito(tarjeta.getNumValidacion(), panEnmascarado, tarjeta.getId());
    }


    public static String getSHA256(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return toReturn;
    }

    public static String genNumValidacion(){
        int N = 1;
        int M = 100;
        String numValidacion = String.valueOf((int) Math.floor(Math.random()*(N-M+1)+M));
        return numValidacion;
    }
}