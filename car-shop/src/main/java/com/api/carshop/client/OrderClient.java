package com.api.carshop.client;

import com.api.carshop.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "orderClient", url = "${url}")
public interface OrderClient {
    @PostMapping("/order")
    ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto);
    @GetMapping("/order/{id}")
    ResponseEntity<OrderDto> getOrder(@PathVariable(value = "id") Long id);
    @PutMapping("/order/{id}")
    ResponseEntity<OrderDto> updateOrder(@PathVariable(value = "id") Long id, @RequestBody OrderDto orderDto);
    @DeleteMapping("/order/{id}")
    ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long id);
}
