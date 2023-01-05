package com.api.carshop.services;

import com.api.carshop.dto.ProductDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.ProductMapper;
import com.api.carshop.mappers.ProductTypeMapper;
import com.api.carshop.models.ProductModel;
import com.api.carshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final ProductTypeMapper productTypeMapper;
    private final ProductTypeService productTypeService;
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper, ProductTypeMapper productTypeMapper, ProductTypeService productTypeService) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.productTypeMapper = productTypeMapper;
        this.productTypeService = productTypeService;
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto){
        ProductModel product = mapper.mapToModel(productDto);
        product.setProductType(productTypeMapper.mapToModel(productTypeService.findById(productDto.getTypeId())));
        final ProductModel productEntity = productRepository.save(product);
        return mapper.mapToDto(productEntity);
    }

    @Override
    @Transactional
    public ProductDto update(ProductDto productDto, Long id){
        final ProductModel productEntity = mapper.mapToModel(findById(id));
        productDto.setId(productEntity.getId());
        return mapper.mapToDto(productRepository.save(mapper.mapToModel(productDto)));
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        try{
            productRepository.deleteById(id);
        } catch(Exception e){
            throw new ApiRequestException("Product not found!");
        }
    }

    @Override
    public ProductDto findById(Long id){
        ProductModel productEntity = checkIfIdExists(id);
        ProductDto product = mapper.mapToDto(checkIfIdExists(id));
        product.setTypeId(productEntity.getProductType().getId());
        return product;
    }

    private ProductModel checkIfIdExists(Long id) {
        Optional<ProductModel> productEntity = productRepository.findById(id);
        if (!productEntity.isPresent()){
            throw new ApiRequestException("Product not found!");
        }
        return productEntity.get();
    }

}
