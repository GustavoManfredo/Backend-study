package com.api.carshop.services;

import com.api.carshop.dtos.ProductTypeDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.ProductTypeModel;
import com.api.carshop.repositories.ProductTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductTypeService {

    final
    ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Transactional
    public ProductTypeDto save(ProductTypeDto productTypeDto) {
        if (existsByType(productTypeDto.getType())){
            throw new ApiRequestException("This Type it is already registered in the database!");
        }
        return mapModelToDto(productTypeRepository.save(mapDtoToModel(productTypeDto)));
    }

    @Transactional
    public ProductTypeDto update(ProductTypeDto productTypeDto, Long id){
        Optional<ProductTypeModel> productTypeModelOptional = productTypeRepository.findById(id);
        productTypeDto.setId(productTypeModelOptional.get().getId());
        return mapModelToDto(productTypeRepository.save(mapDtoToModel(productTypeDto)));
    }

    private ProductTypeDto mapModelToDto(ProductTypeModel productTypeModel){
        return ProductTypeDto.builder()
                .id(productTypeModel.getId())
                .type(productTypeModel.getType())
                .description(productTypeModel.getDescription())
                .build();
    }

    private ProductTypeModel mapDtoToModel(ProductTypeDto productTypeDto){
        var productTypeModel = new ProductTypeModel();
        productTypeModel.setId(productTypeDto.getId());
        productTypeModel.setType(productTypeDto.getType());
        productTypeModel.setDescription(productTypeDto.getDescription());
        return productTypeModel;
    }

    private boolean existsByType(String type){
        return productTypeRepository.existsByType(type);
    }
    public List<ProductTypeDto> findAll() {
        return productTypeRepository.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    public Optional<ProductTypeModel> findById(Long id) {
        Optional<ProductTypeModel> productTypeModelOptional = productTypeRepository.findById(id);
        if (!productTypeModelOptional.isPresent()){
            throw new ApiRequestException("Product type not found!");
        }
        return productTypeRepository.findById(id);
    }

    public Optional<ProductTypeDto> findByIdDto(Long id){
        Optional<ProductTypeModel> productTypeModelOptional = productTypeRepository.findById(id);
        if (!productTypeModelOptional.isPresent()){
            throw new ApiRequestException("Product type not found!");
        }
        return Optional.of(mapModelToDto(productTypeModelOptional.get()));
    }

    @Transactional
    public void delete(Long id) {
        Optional<ProductTypeModel> productTypeModelOptional = productTypeRepository.findById(id);
        productTypeRepository.delete(productTypeModelOptional.get());
    }
}
