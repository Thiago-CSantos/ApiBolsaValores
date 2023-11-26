package com.stockexchange.dto;

import com.stockexchange.model.stocks.Stock;

import java.util.List;

public record UserDto(String nome, List<Stock> symbolQuantidade, Double total) {
}
