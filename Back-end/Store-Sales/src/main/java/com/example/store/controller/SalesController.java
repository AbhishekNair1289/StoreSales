package com.example.store.controller;

import com.example.store.entity.Sale;
import com.example.store.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @CrossOrigin(origins = "http://127.0.0.1:5500") 
    @PostMapping("/insert_sales")
    public ResponseEntity<?> insertSale(@Valid @RequestBody Sale sale) {
    	try {
            Sale insertedSale = saleService.insertSale(sale);
            return ResponseEntity.ok(insertedSale);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/monthly_sales")
    public List<Sale> getMonthlySale(){
        return  saleService.getMonthlySales();
    }
    
    @GetMapping("/all")
    public List<Sale> getAllSales(@RequestParam(required = false) String fromDate,
                                  @RequestParam(required = false) String toDate) {
        if (fromDate != null && toDate != null) {
            LocalDate from = LocalDate.parse(fromDate);
            LocalDate to = LocalDate.parse(toDate);
            return saleService.getSalesByDateRange(from, to);
        } else {
            return saleService.getAllSales();
        }
    }
}
