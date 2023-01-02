package com.api.carshop.controllers;

import com.api.carshop.dto.ProductDto;
import com.api.carshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(productService.save(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") Long id, @RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(productService.update(productDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteById(id);
        return ResponseEntity.ok().body("Product Deleted");
    }
}
