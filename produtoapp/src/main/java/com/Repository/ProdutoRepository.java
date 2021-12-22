package com.Repository;

import com.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    Produto findByCodigo (long codigo);
}
