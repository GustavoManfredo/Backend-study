package com.api.carshop.services;

import com.api.carshop.dto.ProductDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.ProductMapper;
import com.api.carshop.models.ProductModel;
import com.api.carshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    public ProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ProductDto save(ProductDto productDto){
        final ProductModel productEntity = productRepository.save(mapper.mapToModel(productDto));
        return mapper.mapToDto(productEntity);
    }

    @Transactional
    public ProductDto update(ProductDto productDto, Long id){
        final ProductModel productEntity = mapper.mapToModel(findById(id));
        productDto.setId(productEntity.getId());
        return mapper.mapToDto(productRepository.save(mapper.mapToModel(productDto)));
    }

    @Transactional
    public void deleteById(Long id){
        try{
            productRepository.deleteById(id);
        } catch(Exception e){
            throw new ApiRequestException("Product not found!");
        }
    }

    public ProductDto findById(Long id){
        return mapper.mapToDto(checkIfIdExists(id));
    }

    private ProductModel checkIfIdExists(Long id) {
        Optional<ProductModel> productEntity = productRepository.findById(id);
        if (!productEntity.isPresent()){
            throw new ApiRequestException("Product not found!");
        }
        return productEntity.get();
    }
}
