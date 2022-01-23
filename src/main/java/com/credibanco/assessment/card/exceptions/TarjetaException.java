package com.credibanco.assessment.card.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TarjetaException {
    
    public ResponseEntity<Map<String, String>> error(){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "01");
            body.put("Mensaje", "Fallido");
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> exito(String numValidacion,String panEnmascarado,String id){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "00");
            body.put("Mensaje", "Éxito");
            body.put("Número de validación", numValidacion);
            body.put("PAN", panEnmascarado);
            body.put("Identificador del sistema", id);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> tarjetaNoExiste(){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "01");
            body.put("Mensaje", "Tarjeta no existe");            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> numValInv(){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "02");
            body.put("Mensaje", "Número de validación inválido");            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> exitoActivacion(String panEnmascarado){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "00");
            body.put("Mensaje", "Éxito");
            body.put("PAN", panEnmascarado);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> consultaExitosa(String panEnmascarado, String titular, String cedula, String telefono, String estado){
        try {
            Map<String, String> body = new HashMap<>();            
            body.put("PAN", panEnmascarado);
            body.put("Titular", titular);
            body.put("Cédula", cedula);
            body.put("Teléfono", telefono);
            body.put("Estado", estado);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> eliTarjeta(){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "00");
            body.put("Mensaje", "Se ha eliminado la tarjeta");            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> eliNoTarjeta(){
        try {
            Map<String, String> body = new HashMap<>();
            body.put("Código de respuesta", "01");
            body.put("Mensaje", "No se ha eliminado la tarjeta");            
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
