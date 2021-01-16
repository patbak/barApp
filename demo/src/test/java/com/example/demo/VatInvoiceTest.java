package com.example.demo;

import com.example.demo.model.Receipt;
import com.example.demo.model.VatInvoice;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.repository.VatInvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class VatInvoiceTest {

        @Autowired
        private VatInvoiceRepository vatInvoiceRepository;

        @Test
        @Transactional
        public void getReceiptTest()throws Exception{
            List<VatInvoice> vatInvoices = vatInvoiceRepository.findAll();

            assertTrue(vatInvoices.size()>0);
        }

}
