package com.example.loanmanagement.service;

import com.example.loanmanagement.dto.OrderDto;
import com.example.loanmanagement.dto.request.OrderRequest;

import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Long id);
    void saveOrder(OrderRequest orderRequest);
    void updateOrder(OrderRequest orderRequest);
    List<OrderDto> getAll();
    void deleteById(Long id);
}
