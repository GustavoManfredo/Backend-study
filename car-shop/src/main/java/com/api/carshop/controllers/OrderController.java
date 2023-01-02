package com.api.carshop.controllers;

import com.api.carshop.dto.OrderDto;
import com.api.carshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable(value = "id") Long id, @RequestBody OrderDto orderDto){
        return ResponseEntity.ok().body(orderService.update(orderDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long id){
        orderService.deleteById(id);
        return ResponseEntity.ok().body("Order deleted");
    }
}
