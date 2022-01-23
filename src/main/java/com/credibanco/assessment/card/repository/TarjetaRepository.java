package com.credibanco.assessment.card.repository;


import com.credibanco.assessment.card.model.TarjetaModel;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TarjetaRepository extends CrudRepository<TarjetaModel, String>{
    //public abstract ArrayList<TarjetaModel> findByNumTarjeta(String numTarjeta);

    @Transactional(readOnly = true)
    Optional<TarjetaModel> findByNumTarjeta(String numTarjeta);
}
