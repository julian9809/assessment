package com.credibanco.assessment.card.model;

import javax.persistence.*;

@Entity
@Table(name="transacciones")
public class TransaccionModel {
    

    @Id
    private String referencia;

    private String estTransaccion;
    private int total;
    private String direccion;
    private String fecha;
    private String hora;
    private String id;

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getEstTransaccion() {
        return estTransaccion;
    }
    public void setEstTransaccion(String estTransaccion) {
        this.estTransaccion = estTransaccion;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }   
    
}
