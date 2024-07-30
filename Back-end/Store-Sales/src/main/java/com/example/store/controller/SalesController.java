package com.example.store.controller;

import com.example.store.entity.Sale;
import com.example.store.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/insert_sales")
    public Sale insertSale(@Valid @RequestBody Sale sale){
        return saleService.insertSale(sale);
    }

    @GetMapping("/monthly_sales")
    public List<Sale> getMonthlySale(){
        return  saleService.getMonthlySales();
    }
}
