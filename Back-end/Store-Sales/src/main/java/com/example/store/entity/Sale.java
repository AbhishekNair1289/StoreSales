package com.example.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Item is required")
    private String item;

    @NotNull(message = "Quantity is required")
    @Min(1)
    private int quantity;

    @NotNull(message = "Price per unit is required")
    @Min(0)
    private double pricePerUnit;

    @NotNull(message = "Total price is required")
    @Min(0)
    private double totalPrice;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Customer email is required")
    @Email
    private String customerEmail;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;

    @NotNull(message = "Discount is required")
    @Min(0)
    private double discount;

    @NotNull(message = "Product category is required")
    private String productCategory;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

	public Sale(@NotNull(message = "Item is required") String item,
			@NotNull(message = "Quantity is required") @Min(1) int quantity,
			@NotNull(message = "Price per unit is required") @Min(0) double pricePerUnit,
			@NotNull(message = "Total price is required") @Min(0) double totalPrice,
			@NotNull(message = "Date is required") LocalDate date,
			@NotNull(message = "Customer name is required") String customerName,
			@NotNull(message = "Customer email is required") @Email String customerEmail,
			@NotNull(message = "Payment method is required") String paymentMethod,
			@NotNull(message = "Discount is required") @Min(0) double discount,
			@NotNull(message = "Product category is required") String productCategory) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
		this.date = date;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.paymentMethod = paymentMethod;
		this.discount = discount;
		this.productCategory = productCategory;
	}

	public Sale() {
		super();
	}
    
}
