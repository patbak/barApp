package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrdersProductsRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrdersProductsRepository ordersProductsRepository;

    @Override
    public void addOrdersToDatabase(List<OrdersProducts> ordersProducts) {

        Order order = new Order();
        for (int i=0;i<ordersProducts.size();i++){
            ordersProducts.get(i).setOrder(order);
        }
        order.setOrdersProducts(ordersProducts);

        orderRepository.saveAndFlush(order);
    }



    @Override
    public void addProductsToOrder(int idOrder,List<OrdersProducts> ordersProducts) {
        Order order = orderRepository.getOne(idOrder);
        List<OrdersProducts> temp = new ArrayList<>();
        List<OrdersProducts> ordersProductsOld = order.getOrdersProducts();
        temp.addAll(ordersProductsOld);
        temp.addAll(ordersProducts);
        for(int i=0;i<temp.size();i++){
            temp.get(i).setOrder(order);
            System.out.println(temp.get(i).getQuantity());
        }
        order.setOrdersProducts(temp);
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);

    }


}
