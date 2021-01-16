package com.example.demo.controller;

import com.example.demo.model.Receipt;
import com.example.demo.model.VatInvoice;
import com.example.demo.repository.VatInvoiceRepository;
import com.example.demo.service.VatInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/invoices")
public class VatInvoiceController {

    @Autowired
    private VatInvoiceService vatInvoiceService;



    @GetMapping("/generateInvoiceByOrderId/{orderId}")
    public ResponseEntity<String> generateVatInvoiceByOrderId(@PathVariable("orderId") int orderId){
       vatInvoiceService.generateVatInvoice(orderId);

        return  new ResponseEntity<>("Faktura wygenerowana", HttpStatus.OK);
    }

    @GetMapping("/getInvoiceByOrderId/{orderId}")
    public VatInvoice getVatInvoiceByOrderId(@PathVariable("orderId") int orderId){
        VatInvoice vatInvoice = vatInvoiceService.getVatInvoiceByOrderId(orderId);

    return vatInvoice;
    }

}
