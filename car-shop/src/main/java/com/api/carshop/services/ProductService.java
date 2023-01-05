package com.api.carshop.services;

import com.api.carshop.dto.ProductDto;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto, Long id);
    void deleteById(Long id);
    ProductDto findById(Long id);
}
