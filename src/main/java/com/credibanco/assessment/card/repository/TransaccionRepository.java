package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.TransaccionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<TransaccionModel, String> {
    
}
