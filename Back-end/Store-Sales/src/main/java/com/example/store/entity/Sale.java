package com.example.store.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotEmpty(message = "Item is required")
    private String item;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double price;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotEmpty(message = "Customer name is required")
    private String customerName;

    @Email(message = "Customer email should be valid")
    private String customerEmail;

    @NotEmpty(message = "Payment method is required")
    private String paymentMethod;

    public Sale() {
    }

    public Sale(Long id, String item, int quantity, double price, LocalDate date, String customerName, String customerEmail, String paymentMethod) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Item is required") String getItem() {
        return item;
    }

    public void setItem(@NotEmpty(message = "Item is required") String item) {
        this.item = item;
    }

    @Min(value = 1, message = "Quantity must be at least 1")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(value = 1, message = "Quantity must be at least 1") int quantity) {
        this.quantity = quantity;
    }

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    public double getPrice() {
        return price;
    }

    public void setPrice(@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") double price) {
        this.price = price;
    }

    public @NotNull(message = "Date is required") LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull(message = "Date is required") LocalDate date) {
        this.date = date;
    }

    public @NotEmpty(message = "Customer name is required") String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@NotEmpty(message = "Customer name is required") String customerName) {
        this.customerName = customerName;
    }

    public @Email(message = "Customer email should be valid") String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(@Email(message = "Customer email should be valid") String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public @NotEmpty(message = "Payment method is required") String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotEmpty(message = "Payment method is required") String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
