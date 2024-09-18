package com.pruebatecnica.manufactura_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.manufactura_api.model.Status;



@Repository
public interface IStatusRepository extends CrudRepository<Status, Long> {

    Optional<Status> findByName (String name);

}