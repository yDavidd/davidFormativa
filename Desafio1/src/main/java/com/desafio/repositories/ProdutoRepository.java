package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto,Long> {

}
