package com.api.carshop.services;

import com.api.carshop.dto.OrderDto;

public interface OrderService {
    OrderDto save(OrderDto orderDto);
    OrderDto update(OrderDto orderDto, Long id);
    void deleteById(Long id);
    OrderDto findById(Long id);
}
