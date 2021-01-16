package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_has_product")
public class OrdersProducts  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_has_product")
    @JsonIgnore
    private int idOrderProducts;

    @Column(name = "quantity")
    private int quantity;



    @ManyToOne
    @JoinColumn(name = "order_id_order")
    @JsonIgnore
    private Order order;


 @ManyToOne
 @JoinColumn(name = "product_id_product")
 private Product product;

   public int getIdOrderProducts() {
        return idOrderProducts;
    }

    public void setIdOrderProducts(int idOrderProducts) {
        this.idOrderProducts = idOrderProducts;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
