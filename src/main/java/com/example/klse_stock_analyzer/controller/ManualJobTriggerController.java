package com.example.klse_stock_analyzer.controller;

import com.example.klse_stock_analyzer.service.StockSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManualJobTriggerController {

    @Autowired
    private StockSummaryService stockSummaryService;

    @GetMapping("/trigger-job")
    public String triggerJob() {
        stockSummaryService.fetchAndStoreStockSummary();
        return "Stock summary job triggered manually!";
    }
}