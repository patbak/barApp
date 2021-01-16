package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

    Receipt findByOrder_IdOrder(int id);
}
