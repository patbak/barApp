package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersProductsRepository  extends JpaRepository<OrdersProducts, Integer> {
    List<OrdersProducts> findByOrder_IdOrder(int id);
}
