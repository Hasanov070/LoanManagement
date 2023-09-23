package com.example.loanmanagement.repository;

import com.example.loanmanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
        Order getOrderById(Long id);
}
