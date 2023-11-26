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
    private String data;
    private Double abertura;
    private Double maxima;
    private Double minima;
    private Double fechamento;
    private Double volume;
    @Column(name = "quantidade")
    private Integer quantidade;

    public Stock(String symbol, String data, Double abertura, Double maxima, Double minima, Double fechamento, Double volume, Integer quantidade) {
        this.symbol = symbol;
        this.data = data;
        this.abertura = abertura;
        this.maxima = maxima;
        this.minima = minima;
        this.fechamento = fechamento;
        this.volume = volume;
        this.quantidade = quantidade;
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getAbertura() {
        return abertura;
    }

    public void setAbertura(Double abertura) {
        this.abertura = abertura;
    }

    public Double getMaxima() {
        return maxima;
    }

    public void setMaxima(Double maxima) {
        this.maxima = maxima;
    }

    public Double getMinima() {
        return minima;
    }

    public void setMinima(Double minima) {
        this.minima = minima;
    }

    public Double getFechamento() {
        return fechamento;
    }

    public void setFechamento(Double fechamento) {
        this.fechamento = fechamento;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return Objects.equals(getId(), stock.getId()) && Objects.equals(getSymbol(), stock.getSymbol()) && Objects.equals(getData(), stock.getData()) && Objects.equals(getAbertura(), stock.getAbertura()) && Objects.equals(getMaxima(), stock.getMaxima()) && Objects.equals(getMinima(), stock.getMinima()) && Objects.equals(getFechamento(), stock.getFechamento()) && Objects.equals(getVolume(), stock.getVolume()) && Objects.equals(getQuantidade(), stock.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymbol(), getData(), getAbertura(), getMaxima(), getMinima(), getFechamento(), getVolume(), getQuantidade());
    }
}
