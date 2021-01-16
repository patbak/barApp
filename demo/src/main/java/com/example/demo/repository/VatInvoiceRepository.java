package com.example.demo.repository;

import com.example.demo.model.Receipt;
import com.example.demo.model.VatInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatInvoiceRepository extends JpaRepository<VatInvoice, Integer> {
}
