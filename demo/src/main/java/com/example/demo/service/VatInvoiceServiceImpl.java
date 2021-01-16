package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.model.VatInvoice;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VatInvoiceServiceImpl implements VatInvoiceService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void generateVatInvoice(int orderId) {
        Order order = orderRepository.getOne(orderId);
        List<OrdersProducts> ordersProducts = order.getOrdersProducts();
        double nettoAmount = 0.0;
        double amount=0.0;
        for (int i=0; i<ordersProducts.size();i++){
            double price = ordersProducts.get(i).getProduct().getPrice();
            double vatRate = ordersProducts.get(i).getProduct().getVatRate();
            int quantity = ordersProducts.get(i).getQuantity();
            nettoAmount+=price*quantity;
            amount+=price*quantity*vatRate;
        }
        VatInvoice vatInvoice = order.getVatInvoice();
        if(vatInvoice==null)
            vatInvoice=new VatInvoice();
        vatInvoice.setAmountNetto(nettoAmount);
        vatInvoice.setAmountWithVat(amount);
        vatInvoice.setOrder(order);
        vatInvoice.setDateOfService(LocalDate.now());
        order.setVatInvoice(vatInvoice);
        orderRepository.saveAndFlush(order);
    }

    @Override
    public VatInvoice getVatInvoiceByOrderId(int orderId) {

        Order order = orderRepository.getOne(orderId);
        VatInvoice vatInvoice = order.getVatInvoice();
        System.out.println(vatInvoice.getIdInvoice());
        System.out.println(vatInvoice.getDateOfService());
        System.out.println(vatInvoice.getAmountNetto());
        return vatInvoice;
    }

}
