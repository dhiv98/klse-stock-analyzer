#KLSE Stock Analyzer 

This Spring Boot application fetches KLSE stock market summary daily (gainers and losers) from (https://klse.i3investor.com/index.jsp) and stores the data into an H2 database.

##Tech Stack

- Java 1.8
- Spring Boot 2.7.x
- Spring Boot JPA (Hibernate)
- Spring Boot Quartz Scheduler
- H2 Database
- Jsoup (HTML parsing)

##Table Schema

| record_datetime       | num_gainers | num_losers |
|-----------------------|-------------|------------|
| 2025-05-15 21:34:27   | 459         | 626        |

##Features

- Quartz job runs daily at 9:00 AM
- Manual trigger via REST endpoint `/trigger-job`
- Saves data to H2 database (viewable in browser)

##How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/klse-stock-analyzer.git
   cd klse-stock-analyzer

2. Open in IntelliJ IDEA or Eclipse
3. Run the KlseStockAnalyzerApplication.java file
4. Access the H2 Console:
    ```in the console
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:file:./data/klse_stock_db
   Username: sa
   Password: [leave empty]
    
5. To manually trigger the job
   URL: http://localhost:8080/trigger-job
