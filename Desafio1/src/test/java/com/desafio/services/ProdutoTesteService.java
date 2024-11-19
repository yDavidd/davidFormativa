package com.desafio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.entities.Produto;
import com.desafio.repositories.ProdutoRepository;

class ProdutoTesteService {
	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@BeforeEach
	void serUp() {
		produtoRepository.deleteAll();
	}
	
	@DisplayName("Testando salvar Produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "Celular","Iphone15",3600);
		
		Produto resultado = produtoServico.saveProduto(produto);
		
		assertNotNull(resultado);
		assertNotNull("Celular", resultado.getNome());
		assertNotNull(resultado.getId() > 0);
		
	}
	
	@DisplayName("Testando listar todos os Produto")
	@Test
	void testListarTodos() {
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
		Produto produto2 = new Produto(null, "Celular","Iphone15",3600);
		
		produtoServico.saveProduto(produto1);
		produtoServico.saveProduto(produto2);
		
		List<Produto> resultado = produtoServico.getAllProdutos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}

	
}
