package com.stockexchange.service;

import com.stockexchange.model.stocks.Stock;
import com.stockexchange.model.usuario.Usuario;
import com.stockexchange.repostory.StockRepository;
import com.stockexchange.repostory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private StockRepository stockRepository;

    public Usuario createUsuario(Usuario userDto) {
//        Stock stock1 = new Stock("PETR4.SA", 10);
//        Stock stock2 = new Stock("ITUB3.SA", 5);
        //stockRepository.saveAll(Arrays.asList(stock1, stock2));

        return repository.save(userDto);

    }

    public List<Object[]> getUserStock(){
        return repository.findUsuarioAndStockSymbol();
    }

}
