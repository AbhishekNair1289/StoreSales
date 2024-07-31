package com.example.store.service;

import com.example.store.entity.Sale;
import com.example.store.repo.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    SaleRepository repo;

    @Override
    public Sale insertSale(@Valid Sale sale)  {
        
        return repo.save(sale);
    }

    @Override
    public List<Sale> getMonthlySales() {
        YearMonth thisMonth = YearMonth.now();
        LocalDate startDate = thisMonth.atDay(1);
        LocalDate endDate = thisMonth.atEndOfMonth();
        return repo.findByDateBetween(startDate, endDate);
    }

	@Override
	public List<Sale> getAllSales() {
		return repo.findAll();
	}
	
	@Override
	public List<Sale> getSalesByDateRange(LocalDate fromDate, LocalDate toDate) {
        return repo.findAllByDateBetween(fromDate, toDate);
    }

}
