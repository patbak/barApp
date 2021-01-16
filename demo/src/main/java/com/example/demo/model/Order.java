package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @ManyToOne
    @JoinColumn(name="customer_id_customer")

    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "receipt_id_receipt")
    @JsonIgnore
    private Receipt receipt;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    private List<OrdersProducts> ordersProducts;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "order")
    @JsonIgnore
    private VatInvoice vatInvoice;

    public List<OrdersProducts> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }



    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public VatInvoice getVatInvoice() {
        return vatInvoice;
    }

    public void setVatInvoice(VatInvoice vatInvoice) {
        this.vatInvoice = vatInvoice;
    }
}
