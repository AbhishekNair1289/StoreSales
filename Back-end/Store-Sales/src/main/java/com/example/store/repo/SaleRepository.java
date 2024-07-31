package com.example.store.repo;

import com.example.store.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Sale> findAllByDateBetween(LocalDate fromDate, LocalDate toDate);
}
