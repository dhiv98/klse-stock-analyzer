package com.example.klse_stock_analyzer.config;

import com.example.klse_stock_analyzer.scheduler.StockSummaryJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail stockSummaryJobDetail() {
        return JobBuilder.newJob(StockSummaryJob.class)
                .withIdentity("stockSummaryJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger stockSummaryTrigger() {
        // Schedule to run once a day at 9:00 AM
        return TriggerBuilder.newTrigger()
                .forJob(stockSummaryJobDetail())
                .withIdentity("stockSummaryTrigger")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(9, 0))
                .build();
    }
}
