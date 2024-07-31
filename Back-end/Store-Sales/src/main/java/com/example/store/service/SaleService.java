package com.example.store.service;

import com.example.store.entity.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    public Sale insertSale(Sale sale);
    public List<Sale> getMonthlySales();
    public List<Sale> getAllSales();
    public List<Sale> getSalesByDateRange(LocalDate fromDate, LocalDate toDate);
}
