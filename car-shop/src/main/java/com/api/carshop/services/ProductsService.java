package com.api.carshop.services;

import com.api.carshop.dtos.ProductsDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.ProductsModel;
import com.api.carshop.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    final
    ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Transactional
    public ProductsModel save(ProductsModel productsModel, ProductsDto productsDto) {
        BeanUtils.copyProperties(productsDto, productsModel);
        return productsRepository.save(productsModel);
    }

    public List<ProductsModel> findAll() {
        return productsRepository.findAll();
    }

    public Optional<ProductsModel> findById(Long id) {
        Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
        if (!productsModelOptional.isPresent()){
            throw new ApiRequestException("Product not found!");
        }
        return productsRepository.findById(id);
    }

    public void delete(ProductsModel productsModel) {
        productsRepository.delete(productsModel);
    }

    public Object update(ProductsModel productsModel, ProductsDto productsDto) {
        BeanUtils.copyProperties(productsDto, productsModel);
        return productsRepository.save(productsModel);
    }
}
