package com.example.klse_stock_analyzer.service;

import com.example.klse_stock_analyzer.entity.StockSummary;
import com.example.klse_stock_analyzer.repository.StockSummaryRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockSummaryService {

    @Autowired
    private StockSummaryRepository repository;

    public void fetchAndStoreStockSummary() {
        try {
            Document doc = Jsoup.connect("https://klse.i3investor.com/index.jsp").get();

            Element gainersLabel = doc.selectFirst("span.mkt-summ-lbl.badge:contains(Gainers)");
            int gainers = 0;
            if (gainersLabel != null) {
                Element rowDiv = gainersLabel.closest("div.row");
                if (rowDiv != null) {
                    Element gainersNumberDiv = rowDiv.selectFirst("div.col-5.up.text-end strong");
                    if (gainersNumberDiv != null) {
                        gainers = Integer.parseInt(gainersNumberDiv.text().trim());
                    }
                }
            }

            Element losersLabel = doc.selectFirst("span.mkt-summ-lbl.badge.bg-danger:contains(Losers)");
            int losers = 0;
            if (losersLabel != null) {
                Element rowDiv = losersLabel.closest("div.row");
                if (rowDiv != null) {
                    Element losersNumberDiv = rowDiv.selectFirst("div.col-5.down.text-end strong");
                    if (losersNumberDiv != null) {
                        losers = Integer.parseInt(losersNumberDiv.text().trim());
                    }
                }
            }

            StockSummary summary = new StockSummary();
            summary.setRecordDatetime(LocalDateTime.now());
            summary.setNumGainers(gainers);
            summary.setNumLosers(losers);

            repository.save(summary);

            System.out.println("Stock summary saved: Gainers = " + gainers + ", Losers = " + losers);

        } catch (Exception e) {
            System.err.println("Failed to fetch stock data: " + e.getMessage());
        }
    }
}
