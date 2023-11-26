package com.stockexchange.repostory;

import com.stockexchange.model.stocks.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
