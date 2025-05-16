package com.example.klse_stock_analyzer.repository;
import com.example.klse_stock_analyzer.entity.StockSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockSummaryRepository extends JpaRepository<StockSummary, Long> {
}
