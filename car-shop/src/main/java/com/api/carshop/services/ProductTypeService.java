package com.api.carshop.services;

import com.api.carshop.dtos.ProductTypeDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.ProductTypeModel;
import com.api.carshop.repositories.ProductTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    final
    ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Transactional
    public ProductTypeModel save(ProductTypeDto productTypeDto, ProductTypeModel productTypeModel) {
        if (existsByType(productTypeModel.getType())){
            throw new ApiRequestException("This Type it is already registered in the database!");
        }
        BeanUtils.copyProperties(productTypeDto, productTypeModel);
        return productTypeRepository.save(productTypeModel);
    }

    @Transactional
    public ProductTypeModel update(ProductTypeDto productTypeDto, ProductTypeModel productTypeModel){
        BeanUtils.copyProperties(productTypeDto, productTypeModel);
        return productTypeRepository.save(productTypeModel);
    }

    private boolean existsByType(String type){
        return productTypeRepository.existsByType(type);
    }
    public List<ProductTypeModel> findAll() {
        return productTypeRepository.findAll();
    }


    public Optional<ProductTypeModel> findById(Long id) {
        Optional<ProductTypeModel> productTypeModelOptional = productTypeRepository.findById(id);
        if (!productTypeModelOptional.isPresent()){
            throw new ApiRequestException("Product type not found!");
        }
        return productTypeRepository.findById(id);
    }

    @Transactional
    public void delete(ProductTypeModel productTypeModel) {
        productTypeRepository.delete(productTypeModel);
    }
}
