package com.example.store.service;

import com.example.store.entity.Sale;
import com.example.store.repo.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale insertSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getMonthlySales() {
        YearMonth thisMonth = YearMonth.now();
        LocalDate startDate = thisMonth.atDay(1);
        LocalDate endDate = thisMonth.atEndOfMonth();
        return saleRepository.findByDateBetween(startDate, endDate);
    }
}
