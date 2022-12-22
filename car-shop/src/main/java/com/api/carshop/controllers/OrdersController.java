package com.api.carshop.controllers;

import com.api.carshop.dtos.OrdersDto;
import com.api.carshop.models.OrdersModel;
import com.api.carshop.services.OrdersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/orders")
public class OrdersController {

    final
    OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<Object> saveOrder(@RequestBody @Valid OrdersDto ordersDto){
        var ordersModel = new OrdersModel();
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.save(ordersModel, ordersDto));
    }

    @GetMapping
    public ResponseEntity<List<OrdersModel>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") Long id){
        Optional<OrdersModel> ordersModelOptional = ordersService.findById(id);
        return ordersModelOptional.<ResponseEntity<Object>>map(ordersModel -> ResponseEntity.status(HttpStatus.OK).body(ordersModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable(value = "id") Long id){
        Optional<OrdersModel> ordersModelOptional = ordersService.findById(id);
        ordersService.delete(ordersModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable(value = "id") Long id, @RequestBody @Valid OrdersDto ordersDto){
        Optional<OrdersModel> ordersModelOptional = ordersService.findById(id);
        var ordersModel = new OrdersModel();
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.update(ordersModel, ordersDto));
    }
}
