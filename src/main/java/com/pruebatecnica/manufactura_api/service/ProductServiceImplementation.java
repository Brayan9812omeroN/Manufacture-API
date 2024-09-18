package com.pruebatecnica.manufactura_api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.pruebatecnica.manufactura_api.dto.ProductDto;
import com.pruebatecnica.manufactura_api.model.Elaboration;
import com.pruebatecnica.manufactura_api.model.Product;
import com.pruebatecnica.manufactura_api.model.Status;
import com.pruebatecnica.manufactura_api.repository.IElaborationRepository;
import com.pruebatecnica.manufactura_api.repository.IProductRepository;
import com.pruebatecnica.manufactura_api.repository.IStatusRepository;

@Service
public class ProductServiceImplementation implements IProductService{

    private IProductRepository productRepository;
    private IStatusRepository statusRepository;
    private IElaborationRepository elaborationRepository;

    ProductServiceImplementation(IProductRepository productRepository, IStatusRepository statusRepository, IElaborationRepository elaborationRepository){
        this.productRepository = productRepository;
        this.statusRepository = statusRepository;
        this.elaborationRepository = elaborationRepository;
    }

    private Product convertDTOToEntity(ProductDto productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());

        Optional<Status> status = statusRepository.findByName(productDTO.getStatusName());
        status.ifPresent(product::setStatusId);

        Optional<Elaboration> elaboration = elaborationRepository.findByName(productDTO.getElaborationName());
        elaboration.ifPresent(product::setElaborationId);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

   public List<Product> create(List<ProductDto> productDtos) {
        List<Product> products = productDtos.stream()
                                             .map(this::convertDTOToEntity)
                                             .collect(Collectors.toList());
        return this.productRepository.saveAll(products);
    }

    @Override
    public List<Product> out(Long id) {
        this.productRepository.deleteById(id);
        return this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    @Override
    public List<Product> defective(Long id, String statusName) {
        Product product = this.productRepository.findById(id).orElse(null);
        if (product != null) {
            Status status = statusRepository.findByName(statusName).orElse(null);
            if (status != null) {
                product.setStatusId(status);
                this.productRepository.save(product);
            }
        }
        return this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Product> findProductsByStatus(@Param(value = "statusName") String statusName) {
        return this.productRepository.findProductsByStatusName(statusName);
    }

}