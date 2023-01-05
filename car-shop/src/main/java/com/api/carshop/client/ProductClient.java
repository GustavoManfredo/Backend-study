package com.api.carshop.client;

import com.api.carshop.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "productClient", url = "${url}")
public interface ProductClient {
    @PostMapping("/product")
    ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto);
    @GetMapping("/product/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable(value = "id") Long id);
    @PutMapping("/product/{id}")
    ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") Long id, @RequestBody ProductDto productDto);
    @DeleteMapping("/product/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long id);
}
