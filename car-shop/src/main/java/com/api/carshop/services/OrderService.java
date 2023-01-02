package com.api.carshop.services;

import com.api.carshop.dto.OrderDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.CustomerMapper;
import com.api.carshop.mappers.EmployeeMapper;
import com.api.carshop.mappers.OrderMapper;
import com.api.carshop.models.OrderModel;
import com.api.carshop.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final CustomerMapper customerMapper;
    private final EmployeeMapper employeeMapper;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    public OrderService(OrderRepository orderRepository, OrderMapper mapper, CustomerMapper customerMapper, EmployeeMapper employeeMapper, CustomerService customerService, EmployeeService employeeService) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.customerMapper = customerMapper;
        this.employeeMapper = employeeMapper;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @Transactional
    public OrderDto save(OrderDto orderDto){
        OrderModel order = mapper.mapToModel(orderValidate(orderDto));
        order.setCustomer(customerMapper.mapToModel(customerService.findById(orderDto.getCustomerId())));
        order.setEmployee(employeeMapper.mapToModel(employeeService.findById(orderDto.getEmployeeId())));
        final OrderModel orderEntity = orderRepository.save(order);
        return mapper.mapToDto(orderEntity);
    }

    @Transactional
    public OrderDto update(OrderDto orderDto, Long id){
        final OrderModel orderEntity = mapper.mapToModel(findById(id));
        orderDto.setId(orderEntity.getId());
        return mapper.mapToDto(orderRepository.save(mapper.mapToModel(orderValidate(orderDto))));
    }

    @Transactional
    public void deleteById(Long id){
        try {
            orderRepository.deleteById(id);
        } catch (Exception e){
            throw new ApiRequestException("Order not found!");
        }
    }

    public OrderDto findById(Long id){
        OrderModel orderEntity = checkIfIdExists(id);
        OrderDto order = mapper.mapToDto(orderEntity);
        order.setCustomerId(orderEntity.getCustomer().getId());
        order.setEmployeeId(orderEntity.getEmployee().getId());
        return order;
    }

    private OrderModel checkIfIdExists(Long id) {
        Optional<OrderModel> orderEntity = orderRepository.findById(id);
        if (!orderEntity.isPresent()){
            throw new ApiRequestException("Order not found");
        }
        return orderEntity.get();
    }

    private OrderDto orderValidate(OrderDto orderDto){
        orderDto.setDate(dateSetter(orderDto.getDate()));
        orderDto.setShipDate(shipDateSetter(orderDto.getShipDate(), orderDto));
        return orderDto;
    }

    private String dateSetter(String date){
        if (date != null){
            return date;
        }
        return LocalDate.now(ZoneId.of("Brazil/East")).toString();
    }

    private String shipDateSetter(String shipDate, OrderDto orderDto){
        if (shipDate == null && orderDto.getStatus().equalsIgnoreCase("Shipped")){
            return LocalDate.now(ZoneId.of("Brazil/East")).toString();
        }

        return shipDate;
    }
}
