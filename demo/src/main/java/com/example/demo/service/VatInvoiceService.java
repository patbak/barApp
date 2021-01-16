package com.example.demo.service;

import com.example.demo.model.VatInvoice;
import org.springframework.stereotype.Service;


public interface VatInvoiceService {

    public void generateVatInvoice(int orderId);

    public VatInvoice getVatInvoiceByOrderId(int orderId);

}
