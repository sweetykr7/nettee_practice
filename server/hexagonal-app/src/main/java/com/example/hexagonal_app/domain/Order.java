package com.example.hexagonal_app.domain;

public class Order {
    private Long id;
    private String customerName;

    public Order(Long id, String customerName){
        this.id = id;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }
}
