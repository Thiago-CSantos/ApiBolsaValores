package com.stockexchange.repostory;

import com.stockexchange.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query("SELECT u.nome, s.symbol FROM Usuario u INNER JOIN u.symbolQuantidade s")
    List<Object[]> findUsuarioAndStockSymbol();

}
