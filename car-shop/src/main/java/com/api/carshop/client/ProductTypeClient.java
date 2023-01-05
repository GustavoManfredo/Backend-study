package com.api.carshop.client;

import com.api.carshop.dto.ProductTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "productTypeClient", url = "${url}")
public interface ProductTypeClient {
    @PostMapping("/product/types")
    ResponseEntity<ProductTypeDto> saveProductType(@RequestBody ProductTypeDto productTypeDto);
    @GetMapping("/product/types/{id}")
    ResponseEntity<ProductTypeDto> getProductTypeById(@PathVariable(value = "id") Long id);
    @PutMapping("/product/types/{id}")
    ResponseEntity<ProductTypeDto> updateProductType(@PathVariable(value = "id") Long id, @RequestBody ProductTypeDto productTypeDto);
    @DeleteMapping("/product/types/{id}")
    ResponseEntity<String> deleteProductType(@PathVariable(value = "id") Long id);
}
