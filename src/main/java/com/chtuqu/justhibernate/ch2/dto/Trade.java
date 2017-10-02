package com.chtuqu.justhibernate.ch2.dto;

import javax.persistence.*;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = -1;

    private double quantity;

    private String security;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", security='" + security + '\'' +
                '}';
    }
}
