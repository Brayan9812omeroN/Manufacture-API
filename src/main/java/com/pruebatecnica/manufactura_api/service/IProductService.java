package com.pruebatecnica.manufactura_api.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pruebatecnica.manufactura_api.dto.ProductDto;
import com.pruebatecnica.manufactura_api.model.Product;

public interface IProductService {

    List<Product> getAllProducts();
    List<Product> create (List<ProductDto> products);
    List<Product> out(Long id);
    List<Product> defective(Long id, String status);
    List<Product> findProductsByStatus (@Param(value = "statusName") String statusName);

}