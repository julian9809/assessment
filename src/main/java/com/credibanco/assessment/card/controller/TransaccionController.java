package com.credibanco.assessment.card.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;  

import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.dto.TransaccionDTO;
import com.credibanco.assessment.card.repository.TransaccionRepository;
import com.credibanco.assessment.card.service.interfaces.ITransaccionService;
import com.credibanco.assessment.card.service.interfaces.ITarjetasService;
import com.credibanco.assessment.card.exceptions.TransactionException;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crearTransaccion")
public class TransaccionController {
    
    @Autowired 
    private TransaccionRepository transaccionRepository;

    @Autowired
    private ITransaccionService transaccionService;

    @Autowired
    private ITarjetasService tarjetaService;

    @GetMapping(value = "/by/{id}/{numReferencia}/{total}/{direccion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> findByIdAndNumReferenciaAndTotalAndDireccion(@PathVariable("id") String id, @PathVariable("numReferencia") String numReferencia, @PathVariable("total") String total, @PathVariable String direccion) throws ParseException {
        
        TransactionException transaccionException = new TransactionException();
        TarjetaDTO tarjeta = this.tarjetaService.findById(id);

        if (tarjeta == null) {
            return transaccionException.tarjetaNoExiste(numReferencia);
        }

        if (!tarjeta.getEstado().equals("Enrolada")){
            return transaccionException.tarjetaNoEnrolada(numReferencia);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();        
		String dateToStr = dateFormat.format(date);

        DateFormat formatoOrigen = new SimpleDateFormat("HHmmss.00");
        DateFormat formatoDestino = new SimpleDateFormat("HH:mm:ss");
        Date hora = formatoOrigen.parse("090230.00");
        String horaFormato = formatoDestino.format(hora);

        TransaccionDTO transaccion = null;

        transaccion.setReferencia(numReferencia);
        transaccion.setEstTransaccion("Aprobada");
        transaccion.setDireccion(direccion);
        transaccion.setFecha(dateToStr);
        transaccion.setHora(horaFormato);
        transaccion.setId(id);
        transaccion.setTotal(Integer.parseInt(total));
        
        this.transaccionService.save(transaccion);
        return transaccionException.compraExitosa(numReferencia);
    }

}
