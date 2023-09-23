package com.example.loanmanagement.controller;

import com.example.loanmanagement.dto.OrderDto;
import com.example.loanmanagement.dto.request.OrderRequest;
import com.example.loanmanagement.model.Order;
import com.example.loanmanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {
    final OrderService orderService;

    @GetMapping(value = "/orderList")
    public List<OrderDto> getOrderInfo(){
        return orderService.getAll();
    }
    @GetMapping(value = "/getOrderById/{id}")
    public OrderDto getOrderById(@PathVariable(value = "id")Long id){
        return orderService.getOrderById(id);
    }
    @PostMapping(value = "/saveOrder")
    public void saveOrder(@RequestBody OrderRequest orderRequest)
    {
        orderService.saveOrder(orderRequest);
    }
    @PostMapping(value = "/updateOrder")
    public void updateOrder(@RequestBody OrderRequest orderRequest)
    {
        orderService.updateOrder(orderRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        orderService.deleteById(id);
    }
}
