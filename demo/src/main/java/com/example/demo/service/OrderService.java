package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.model.Product;

import java.util.List;

public interface OrderService {


     void addOrdersToDatabase(List<OrdersProducts> ordersProducts);

     void deleteOrderById(int id);

     void addProductsToOrder(int idOrder, List<OrdersProducts> ordersProducts);


}
