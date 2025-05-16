package com.example.klse_stock_analyzer.scheduler;

import com.example.klse_stock_analyzer.service.StockSummaryService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockSummaryJob implements Job {

    @Autowired
    private StockSummaryService stockSummaryService;

    @Override
    public void execute(JobExecutionContext context) {
        stockSummaryService.fetchAndStoreStockSummary();
    }
}
