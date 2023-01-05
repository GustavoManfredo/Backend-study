package com.api.carshop.controllers;

import com.api.carshop.client.ProductClient;
import com.api.carshop.client.ProductTypeClient;
import com.api.carshop.dto.ProductDto;
import com.api.carshop.dto.ProductTypeDto;
import com.api.carshop.mappers.ProductTypeMapper;
import com.api.carshop.models.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductControllerTest {

    @Autowired
    ProductClient productClient;

    @Autowired
    ProductTypeClient productTypeClient;

    @Autowired
    ProductTypeMapper productTypeMapper;

    ProductDto productDto;
    ProductDto productDtoPut;
    ProductModel productModel;
    ProductTypeDto productTypeDto;

    @BeforeEach
    public void setup(){

        productTypeDto = ProductTypeDto.builder()
                .type("Moto")
                .description("Qualquer veiculo com duas rodas")
                .build();

        var createProductType = productTypeClient.saveProductType(productTypeDto);
        assertEquals(HttpStatus.CREATED, createProductType.getStatusCode());

        productDto = ProductDto.builder()
                .name("MT-03")
                .manufactureYear(2023)
                .brand("Yamaha")
                .description("300cc, Blue")
                .stock(7)
                .price(30540.99F)
                .typeId(createProductType.getBody().getId())
                .build();

        productDtoPut = ProductDto.builder()
                .name("Z900")
                .manufactureYear(2023)
                .brand("Kawasaki")
                .description("900cc, White")
                .stock(2)
                .price(59999.99F)
                .typeId(createProductType.getBody().getId())
                .build();

        productModel = ProductModel.builder()
                .name("MT-03")
                .manufactureYear(2023)
                .brand("Yamaha")
                .description("300cc, Blue")
                .stock(7)
                .price(30540.99F)
                .productType(productTypeMapper.mapToModel(createProductType.getBody()))
                .build();
    }

    @Test
    public void shouldDoCRUD(){
        var saveProduct = productClient.saveProduct(productDto);
        productModel.setId(saveProduct.getBody().getId());
        assertEquals(HttpStatus.CREATED, saveProduct.getStatusCode());
        assertEquals(productModel.getName(), saveProduct.getBody().getName());

        var getProductById = productClient.getProductById(productModel.getId());
        assertEquals(HttpStatus.OK, getProductById.getStatusCode());
        assertEquals(productModel.getId(), getProductById.getBody().getId());

        var updateProduct = productClient.updateProduct(productModel.getId(), productDtoPut);
        assertEquals(HttpStatus.OK, updateProduct.getStatusCode());
        assertEquals(productModel.getId(), updateProduct.getBody().getId());
        assertNotEquals(productModel.getName(), updateProduct.getBody().getName());

        var deleteProduct = productClient.deleteProduct(productModel.getId());
        assertEquals(HttpStatus.OK, deleteProduct.getStatusCode());
        assertEquals("Product Deleted", deleteProduct.getBody());

        productTypeClient.deleteProductType(productDto.getTypeId());
    }

}