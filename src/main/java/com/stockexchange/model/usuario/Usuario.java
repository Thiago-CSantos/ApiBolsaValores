package com.stockexchange.model.usuario;

import com.stockexchange.dto.UserDto;
import com.stockexchange.model.stocks.Stock;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private List<Stock> symbolQuantidade;
    private Double total;

    public Usuario() {
    }

    public Usuario(UserDto dados) {
        this.nome = dados.nome();
        this.symbolQuantidade = dados.symbolQuantidade();
        this.total = dados.total();
    }

    public Usuario(String nome, List<Stock> symbolQuantidade, Double total) {
        this.nome = nome;
        this.symbolQuantidade = symbolQuantidade;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Stock> getSymbolQuantidade() {
        return symbolQuantidade;
    }

    public void setSymbolQuantidade(List<Stock> symbolQuantidade) {
        this.symbolQuantidade = symbolQuantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getSymbolQuantidade(), usuario.getSymbolQuantidade()) && Objects.equals(getTotal(), usuario.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSymbolQuantidade(), getTotal());
    }
}
