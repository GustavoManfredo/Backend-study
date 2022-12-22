package com.api.carshop.services;

import com.api.carshop.dtos.OrdersDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.OrdersModel;
import com.api.carshop.repositories.OrdersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    final
    OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Transactional
    public OrdersModel save(OrdersModel ordersModel, OrdersDto ordersDto) {
        BeanUtils.copyProperties(ordersDto, ordersModel);
        return ordersRepository.save(ordersModel);
    }

    public List<OrdersModel> findAll() {
        return ordersRepository.findAll();
    }

    public Optional<OrdersModel> findById(Long id) {
        Optional<OrdersModel> ordersModelOptional = ordersRepository.findById(id);
        if (!ordersModelOptional.isPresent()){
            throw new ApiRequestException("Order not found!");
        }
        return ordersRepository.findById(id);
    }

    @Transactional
    public void delete(OrdersModel ordersModel) {
        ordersRepository.delete(ordersModel);
    }

    @Transactional
    public OrdersModel update(OrdersModel ordersModel, OrdersDto ordersDto) {
        BeanUtils.copyProperties(ordersDto, ordersModel);
        return ordersRepository.save(ordersModel);
    }
}
