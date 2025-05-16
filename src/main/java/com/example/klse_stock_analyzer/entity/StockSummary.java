package com.example.klse_stock_analyzer.entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class StockSummary {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime recordDatetime;
    private int numGainers;
    private int numLosers;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getRecordDatetime() {
        return recordDatetime;
    }

    public void setRecordDatetime(LocalDateTime recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    public int getNumGainers() {
        return numGainers;
    }

    public void setNumGainers(int numGainers) {
        this.numGainers = numGainers;
    }

    public int getNumLosers() {
        return numLosers;
    }

    public void setNumLosers(int numLosers) {
        this.numLosers = numLosers;
    }
}
