package com.api.carshop.controllers;

import com.api.carshop.dtos.OrdersDto;
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
    public ResponseEntity<OrdersDto> saveOrder(@RequestBody @Valid OrdersDto ordersDto){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.save(ordersDto));
    }

    @GetMapping
    public ResponseEntity<List<OrdersDto>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") Long id){
        Optional<OrdersDto> ordersDtoOptional = ordersService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDtoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long id){
        ordersService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdersDto> updateOrder(@PathVariable(value = "id") Long id, @RequestBody @Valid OrdersDto ordersDto){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.update(ordersDto, id));
    }
}
