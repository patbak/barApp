package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.model.Receipt;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void countAmount(int orderId) {
        double amount=0.0;
      Order order  = orderRepository.getOne(orderId);
       List<OrdersProducts> ordersProducts = order.getOrdersProducts();
       for (int i=0;i<ordersProducts.size();i++){
          double price = ordersProducts.get(i).getProduct().getPrice();
          double vatRate = ordersProducts.get(i).getProduct().getVatRate();
          int quantity = ordersProducts.get(i).getQuantity();
          amount+=price*vatRate*quantity;
       }

       Receipt receipt = order.getReceipt();
       if(receipt==null)
           receipt=new Receipt();
       receipt.setAmount(amount);
       order.setReceipt(receipt);
       orderRepository.saveAndFlush(order);

    }



}
