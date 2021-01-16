package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Receipt;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptService receiptService;


    @GetMapping("/getReceipts")
    public List<Receipt> getReceipts(){

        return receiptRepository.findAll();
    }

    @GetMapping("/getReceiptByOrderId/{orderId}")
    public Receipt getReceiptById(@PathVariable("orderId") int orderId){
        receiptService.countAmount(orderId);
        Receipt receipt =   receiptRepository.findByOrder_IdOrder(orderId);
        return receipt;
    }
}
