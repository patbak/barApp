package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.model.Receipt;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ReceiptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReceiptTest {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Test
    @Transactional
    public void getReceiptTest()throws Exception{
        List<Receipt> receipts = receiptRepository.findAll();

        assertTrue(receipts.size()>0);
    }

}
