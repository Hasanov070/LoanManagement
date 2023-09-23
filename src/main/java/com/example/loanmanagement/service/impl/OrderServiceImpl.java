package com.example.loanmanagement.service.impl;

import com.example.loanmanagement.dto.OrderDto;
import com.example.loanmanagement.dto.request.OrderRequest;
import com.example.loanmanagement.model.Order;
import com.example.loanmanagement.repository.OrderRepository;
import com.example.loanmanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.getOrderById(id);
        return OrderDto.builder()
                .amount(order.getAmount())
                .type(order.getType())
                .build();
    }

    @Override
    public void saveOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .amount(orderRequest.getAmount())
                .type(orderRequest.getType())
                .build();

    }

    @Override
    public void updateOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .id(orderRequest.getId())
                .bankTo(orderRequest.getBankTo())
                .accountTo(orderRequest.getAccountTo())
                .amount(orderRequest.getAmount())
                .type(orderRequest.getType())
                .build();

    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders)
        {
            OrderDto orderDto = OrderDto.builder()
                    .amount(order.getAmount())
                    .type(order.getType())
                    .build();
            orderDtos.add(orderDto);
        }
        return  orderDtos;
    }

    @Override
    public void deleteById(Long id) {
        Order order = orderRepository.getOrderById(id);
        orderRepository.deleteById(id);

    }
}
