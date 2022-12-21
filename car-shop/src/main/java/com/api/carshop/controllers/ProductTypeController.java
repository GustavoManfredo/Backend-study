package com.api.carshop.controllers;

import com.api.carshop.dtos.ProductTypeDto;
import com.api.carshop.models.ProductTypeModel;
import com.api.carshop.services.ProductTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products/type")
public class ProductTypeController {

    final
    ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveProductType(@RequestBody @Valid ProductTypeDto productTypeDto){
        var productTypeModel = new ProductTypeModel();
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.save(productTypeDto, productTypeModel));
    }

    @GetMapping()
    public ResponseEntity<List<ProductTypeModel>> getAllProductsTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProductTypeById(@PathVariable(value = "id") Long id){
        Optional<ProductTypeModel> productTypeModelOptional = productTypeService.findById(id);
        return productTypeModelOptional.<ResponseEntity<Object>>map(productTypeModel -> ResponseEntity.status(HttpStatus.OK).body(productTypeModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductType(@PathVariable(value = "id") Long id){
        Optional<ProductTypeModel> productTypeModelOptional = productTypeService.findById(id);
        productTypeService.delete(productTypeModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product type deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductType(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductTypeDto productTypeDto){
        Optional<ProductTypeModel> productTypeModelOptional = productTypeService.findById(id);
        var productTypeModel = new ProductTypeModel();
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.update(productTypeDto, productTypeModel));
    }

}
