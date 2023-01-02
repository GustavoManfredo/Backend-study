package com.api.carshop.controllers;

import com.api.carshop.dto.ProductTypeDto;
import com.api.carshop.services.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product/types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public ResponseEntity<ProductTypeDto> saveProductType(@RequestBody ProductTypeDto productTypeDto){
        return ResponseEntity.ok().body(productTypeService.save(productTypeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeDto> getProductTypeById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(productTypeService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductTypeDto> updateProductType(@PathVariable(value = "id") Long id, @RequestBody ProductTypeDto productTypeDto){
        return ResponseEntity.ok().body(productTypeService.update(productTypeDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long id){
        productTypeService.deleteProductType(id);
        return ResponseEntity.ok().body("Product type deleted!");
    }
}
