package com.api.carshop.services;

import com.api.carshop.dto.ProductTypeDto;

public interface ProductTypeService {
    ProductTypeDto save(ProductTypeDto productTypeDto);
    ProductTypeDto update(ProductTypeDto productTypeDto, Long id);
    void deleteProductType(Long id);
    ProductTypeDto findById(Long id);
}
