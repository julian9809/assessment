package com.credibanco.assessment.card.model;

import javax.persistence.*;

@Entity
@Table(name="tarjetas")
public class TarjetaModel {
    
    @Id
    private String id;

    private String numTarjeta;
    private String numValidacion;
    private String titular;
    private String cedula;
    private String tipo;
    private String telefono;
    private String estado;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNumValidacion() {
        return numValidacion;
    }
    public void setNumValidacion(String numValidacion) {
        this.numValidacion = numValidacion;
    }
    
    
}
