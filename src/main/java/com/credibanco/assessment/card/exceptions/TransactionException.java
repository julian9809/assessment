package com.credibanco.assessment.card.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TransactionException {
    
    public ResponseEntity<Map<String, String>> tarjetaNoExiste(String numReferencia){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "01");
            body.put("Mensaje", "Tarjeta no existe");
            body.put("Estado", "Rechazada");
            body.put("Número de referencia", numReferencia);            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> tarjetaNoEnrolada(String numReferencia){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "02");
            body.put("Mensaje", "Tarjeta no enrolada");
            body.put("Estado", "Rechazada");
            body.put("Número de referencia", numReferencia);            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> compraExitosa(String numReferencia){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "00");
            body.put("Mensaje", "Compra Exitosa");
            body.put("Estado", "Aprobada");
            body.put("Número de referencia", numReferencia);            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
