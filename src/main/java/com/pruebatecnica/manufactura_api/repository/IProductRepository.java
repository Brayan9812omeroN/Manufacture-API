package com.pruebatecnica.manufactura_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pruebatecnica.manufactura_api.model.Product;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT p FROM Product p WHERE p.statusId.name = :statusName ORDER BY p.id ASC")
    List<Product> findProductsByStatusName(@Param(value = "statusName") String statusName);
    
}