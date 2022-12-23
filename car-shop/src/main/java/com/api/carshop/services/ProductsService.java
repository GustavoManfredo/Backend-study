package com.api.carshop.services;

import com.api.carshop.dtos.ProductTypeDto;
import com.api.carshop.dtos.ProductsDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.ProductsModel;
import com.api.carshop.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    final
    ProductsRepository productsRepository;
    final
    ProductTypeService productTypeService;

    public ProductsService(ProductsRepository productsRepository, ProductTypeService productTypeService) {
        this.productsRepository = productsRepository;
        this.productTypeService = productTypeService;
    }

    @Transactional
    public ProductsDto save(ProductsDto productsDto) {
        return mapModelToDto(productsRepository.save(mapDtoToModel(productsDto)));
    }

    private ProductsModel mapDtoToModel(ProductsDto productsDto){
        var productsModel = new ProductsModel();
        productsModel.setId(productsDto.getId());
        productsModel.setName(productsDto.getName());
        productsModel.setPrice(productsDto.getPrice());
        productsModel.setStock(productsDto.getStock());
        productsModel.setBrand(productsDto.getBrand());
        productsModel.setManufactureYear(productsDto.getManufactureYear());
        productsModel.setDescription(productsDto.getDescription());
        productsModel.setProductType(productTypeService.findById(productsDto.getProductTypeId()).get());
        return productsModel;
    }

    private ProductsDto mapModelToDto(ProductsModel productsModel){
        var productsDto = new ProductsDto();
        productsDto.setId(productsModel.getId());
        productsDto.setName(productsModel.getName());
        productsDto.setPrice(productsModel.getPrice());
        productsDto.setStock(productsModel.getStock());
        productsDto.setBrand(productsModel.getBrand());
        productsDto.setManufactureYear(productsModel.getManufactureYear());
        productsDto.setDescription(productsModel.getDescription());
        productsDto.setProductType(ProductTypeDto.builder()
                .type(productsModel.getProductType().getType())
                .description(productsModel.getProductType().getDescription())
                .build());
        return productsDto;
    }

    public List<ProductsDto> findAll() {
        return productsRepository.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    private Optional<ProductsModel> findById(Long id) {
        Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
        if (!productsModelOptional.isPresent()){
            throw new ApiRequestException("Product not found!");
        }
        return productsRepository.findById(id);
    }

    public Optional<ProductsDto> findByIdDto(Long id){
        Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
        if (!productsModelOptional.isPresent()){
            throw new ApiRequestException("Product not found!");
        }
        return Optional.of(mapModelToDto(productsModelOptional.get()));
    }

    @Transactional
    public void delete(Long id) {
        Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
        productsRepository.delete(productsModelOptional.get());
    }

    @Transactional
    public ProductsDto update(ProductsDto productsDto, Long id) {
        Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
        productsDto.setId(productsModelOptional.get().getId());
        return mapModelToDto(productsRepository.save(mapDtoToModel(productsDto)));
    }
}
