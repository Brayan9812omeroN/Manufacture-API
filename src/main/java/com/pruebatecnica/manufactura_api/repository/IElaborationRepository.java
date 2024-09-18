package com.pruebatecnica.manufactura_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.manufactura_api.model.Elaboration;


@Repository
public interface IElaborationRepository extends CrudRepository<Elaboration, Long>{

    Optional<Elaboration> findByName(String name);

}