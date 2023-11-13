package com.stockexchange.model.stocks;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Symbol")
    private String symbol;
    @Column(name = "quantidade")
    private Integer quantidade;

    public Stock(String symbol, Integer quantidade) {
        this.symbol = symbol;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantide() {
        return quantidade;
    }

    public void setQuantide(Integer quantide) {
        this.quantidade = quantide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return Objects.equals(getId(), stock.getId()) && Objects.equals(getSymbol(), stock.getSymbol()) && Objects.equals(getQuantide(), stock.getQuantide());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymbol(), getQuantide());
    }
}
