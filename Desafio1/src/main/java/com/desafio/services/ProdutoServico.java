package com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.entities.Produto;
import com.desafio.repositories.ProdutoRepository;

@Service
public class ProdutoServico {
	
	private final ProdutoRepository produtoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public ProdutoServico(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
