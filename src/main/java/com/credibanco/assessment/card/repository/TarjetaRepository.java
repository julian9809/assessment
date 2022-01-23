package com.credibanco.assessment.card.repository;

import java.util.ArrayList;

import com.credibanco.assessment.card.model.TarjetaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends CrudRepository<TarjetaModel, String>{
    public abstract ArrayList<TarjetaModel> findByNumTarjeta(String numTarjeta);
}
