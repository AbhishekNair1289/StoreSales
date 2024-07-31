package com.example.store.service;

import com.example.store.entity.Sale;

import java.util.List;

public interface SaleService {

    public Sale insertSale(Sale sale);
    public List<Sale> getMonthlySales();
    public List<Sale> getAllSales();
}
