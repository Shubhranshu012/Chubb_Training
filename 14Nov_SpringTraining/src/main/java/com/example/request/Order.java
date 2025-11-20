package com.example.request;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;

public class Order {
    private String item;
    @Min(value = 1)//default message
    private float price;
    @Min(value = 1,message="Give me Quantity")
    @Range(min=1,max=10)
    private float quantity;
    private Address address;
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void setQuantity(float qt) {
        this.quantity = qt;
    }

    public float total() {
        return price * quantity;
    }

    public String getItem() {
        return item;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
