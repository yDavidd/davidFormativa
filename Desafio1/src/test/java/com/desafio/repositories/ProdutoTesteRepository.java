package com.desafio.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.entities.Produto;

class ProdutoTesteRepository {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
		
		//when / act
		Produto saveProduto = produtoRepository.save(produto1);
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
		
	}
	
	@DisplayName("Testando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
		Produto produto2 = new Produto(null, "Celular","Iphone15",3600);
		
		//when / act
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		//Then / Assert
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
		
	}
	@DisplayName("Testando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
				
		//when / act
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(),saveProduto.getId());
		
	}
	@DisplayName("Testando By ID")
	@Test
	void testUpdateProduto() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
				
		//when / act
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Celular");
		produto1.setDescricao("Iphone15");
		produto1.setPreco(3600);
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		//Then / Assert
		assertNotNull(updateProduto);
		assertEquals("Celular", updateProduto.getNome());
		assertEquals("Iphone15", updateProduto.getDescricao());
		assertEquals(3600, updateProduto.getPreco());
		
	}
	@DisplayName("Testando By ID")
	@Test
	void testDeleteProduto() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "Celular","Iphone15",3600);
				
		//when / act
		produtoRepository.save(produto1);
		
		produtoRepository.deleteById(produto1.getId());
		
		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
		//Then / Assert
		assertNotNull(produtoOptional);

	}
	
}
