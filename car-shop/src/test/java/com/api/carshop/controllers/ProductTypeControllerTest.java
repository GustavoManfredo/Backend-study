package com.api.carshop.controllers;

import com.api.carshop.client.ProductTypeClient;
import com.api.carshop.dto.ProductTypeDto;
import com.api.carshop.models.ProductTypeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductTypeControllerTest {

    @Autowired
    ProductTypeClient productTypeClient;

    ProductTypeDto productTypeDto;

    ProductTypeModel productTypeModel;

    ProductTypeDto productTypeDtoPut;

    @BeforeEach
    public void setup(){
        productTypeDto = ProductTypeDto.builder()
                .type("Moto")
                .description("Qualquer veiculo com duas rodas")
                .build();

        productTypeModel = ProductTypeModel.builder()
                .type("Moto")
                .description("Qualquer veiculo com duas rodas")
                .build();

        productTypeDtoPut = ProductTypeDto.builder()
                .type("Carro")
                .description("Qualquer veiculo com quatro rodas")
                .build();
    }

    @Test
    public void shouldDoCRUD(){
        var saveProductType = productTypeClient.saveProductType(productTypeDto);
        productTypeModel.setId(saveProductType.getBody().getId());
        assertEquals(HttpStatus.CREATED, saveProductType.getStatusCode());
        assertEquals(productTypeModel.getType(), saveProductType.getBody().getType());

        var getProductTypeById = productTypeClient.getProductTypeById(productTypeModel.getId());
        assertEquals(HttpStatus.OK, getProductTypeById.getStatusCode());
        assertEquals(productTypeModel.getId(), getProductTypeById.getBody().getId());

        var updateProductType = productTypeClient.updateProductType(productTypeModel.getId(), productTypeDtoPut);
        assertEquals(HttpStatus.OK, updateProductType.getStatusCode());
        assertEquals(productTypeModel.getId(), updateProductType.getBody().getId());
        assertNotEquals(productTypeModel.getType(), updateProductType.getBody().getType());

        var deleteProductType = productTypeClient.deleteProductType(productTypeModel.getId());
        assertEquals(HttpStatus.OK, deleteProductType.getStatusCode());
        assertEquals("Product type deleted!", deleteProductType.getBody());
    }

}