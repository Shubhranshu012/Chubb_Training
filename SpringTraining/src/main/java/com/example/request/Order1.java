package com.example.request;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Order1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	private String item;
	private float price;
	private int quantity;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
        this.item = item;
    }
	public int getQuantity() {
        return quantity;
    }

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}