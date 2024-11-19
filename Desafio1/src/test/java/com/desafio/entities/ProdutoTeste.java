package com.desafio.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTeste {
	
	private Produto produto;
	
	//Arrange
	@BeforeEach
	void setUp() {
		produto = new Produto(1L, "Celular","Iphone15", 3600);
	}
	
	
	
	@Test
	@DisplayName("Testando o getter e setter do campo Id")
	void testId() {
		//Action
		produto.setId(2L);
		
		//Assert
		assertEquals(2L, produto.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo Nome")
	void testNome() {
		//Action
		produto.setNome("Celular");
		produto.setDescricao("Iphone15");
		produto.setPreco(3600);
		
		//Assert
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Produto  novoproduto = new Produto(3L, "Geladeira","Grande", 2500);
		//Assert
		assertAll("novoquarto", 
				()-> assertEquals(3L, novoproduto.getId()),
				()-> assertEquals("Geladeira", novoproduto.getNome()),
				()-> assertEquals("Grande", novoproduto.getDescricao()),
				()-> assertEquals(2500, novoproduto.getPreco())
				
				);
		
	}

}
