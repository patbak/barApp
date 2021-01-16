package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "vat_invoice")
public class VatInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private int idInvoice;

    @Column(name = "date_of_service")
    private LocalDate dateOfService;

    @Column(name = "amount_netto")
    private double amountNetto;

    @Column(name = "amount_with_vat")
    private double amountWithVat;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "orders_id_order")
    private Order order;

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }

    public double getAmountNetto() {
        return amountNetto;
    }

    public void setAmountNetto(double amountNetto) {
        this.amountNetto = amountNetto;
    }

    public double getAmountWithVat() {
        return amountWithVat;
    }

    public void setAmountWithVat(double amountWithVat) {
        this.amountWithVat = amountWithVat;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
