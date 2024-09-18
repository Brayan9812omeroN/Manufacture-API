package com.pruebatecnica.manufactura_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.manufactura_api.dto.ProductDto;
import com.pruebatecnica.manufactura_api.dto.StatusDto;
import com.pruebatecnica.manufactura_api.model.Product;
import com.pruebatecnica.manufactura_api.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Storage Control", description = "Controller for manage products")
public class ProductController {
    private IProductService productService;

    ProductController(IProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    @Operation(
            summary = "Create Product",
            description = "Entry of products into stock and returns the list of products",
            tags = {"Storage Control"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request for creation with the list of products to be registered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto[].class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful product registration",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public List<Product> create(@RequestBody List<ProductDto> products){
        return productService.create(products);
    }

    @DeleteMapping("/out/{id}")
    @Operation(
            summary = "Remove Product",
            description = "Removes a product from stock by its ID",
            tags = {"Storage Control"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product successfully removed from stock",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public List<Product> out(@PathVariable Long id){
        return productService.out(id);
    }

    @PatchMapping("/defective/{id}")
    @Operation(
            summary = "Mark Product as Defective",
            description = "Marks a product as defective by its ID",
            tags = {"Storage Control"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request body with the status of the product to mark as defective",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StatusDto.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product successfully marked as defective",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public List<Product> defective(@PathVariable("id") Long id, @RequestBody StatusDto statusDto){
        return productService.defective(id, statusDto.getStatusName());
    }
    
    @GetMapping("/all")
    @Operation(
            summary = "Get All Products",
            description = "Fetches all products available in stock",
            tags = {"Storage Control"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of all products",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public List<Product> AllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/findByStatus/{statusName}")
    @Operation(
            summary = "Find Products by Status",
            description = "Fetches products based on their status ('Available' or 'Defective')",
            tags = {"Storage Control"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of products with the given status",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No products found with the given status",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    public List<Product> findStatus(@PathVariable("statusName") String statusName) {
    return productService.findProductsByStatus(statusName);
    }
}