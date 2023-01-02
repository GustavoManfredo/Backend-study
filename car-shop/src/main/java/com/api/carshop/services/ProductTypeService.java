package com.api.carshop.services;

import com.api.carshop.dto.ProductTypeDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.ProductTypeMapper;
import com.api.carshop.models.ProductTypeModel;
import com.api.carshop.repositories.ProductTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductTypeMapper mapper;

    @Transactional
    public ProductTypeDto save(ProductTypeDto productTypeDto){
        final ProductTypeModel productTypeEntity = productTypeRepository.save(mapper.mapToModel(validateProductType(productTypeDto)));
        return mapper.mapToDto(productTypeEntity);
    }

    @Transactional
    public ProductTypeDto update(ProductTypeDto productTypeDto, Long id){
        final ProductTypeModel productTypeEntity = mapper.mapToModel(findById(id));
        productTypeDto.setId(productTypeEntity.getId());
        return mapper.mapToDto(productTypeRepository.save(mapper.mapToModel(productTypeDto)));
    }

    @Transactional
    public void deleteProductType(Long id){
        try {
            productTypeRepository.deleteById(id);
        } catch (Exception e){
            throw new ApiRequestException("Product type not found!");
        }
    }

    public ProductTypeDto findById(Long id){
        return mapper.mapToDto(checkIfIdExists(id));
    }

    private ProductTypeModel checkIfIdExists(Long id){
        final Optional<ProductTypeModel> productTypeEntity = productTypeRepository.findById(id);

        if (!productTypeEntity.isPresent()){
            throw new ApiRequestException("Product type not found!");
        }

        return productTypeEntity.get();
    }

    private ProductTypeDto validateProductType(ProductTypeDto productTypeDto){
        productTypeDto.setType(validateType(productTypeDto.getType()));
        return productTypeDto;
    }

    private String validateType(String type){
        if (productTypeRepository.existsByType(type)){
            throw new ApiRequestException("Invalid type!");
        }
        return type;
    }
}
