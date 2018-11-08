package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.ProdutoCombo;
import lab5.ProdutoSimples;

class ProdutoComboTest {


	@Test
	void testToString() {
		ProdutoCombo produto = new ProdutoCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.25", "Tapioca - Tapioca de queijo - R$3,50 e Pudim - Pudim de leite - R$4,50");
		System.out.println(produto.toString());
		assertEquals(produto.toString(), "X-burguer + suco - X-burguer com suco de maracuja - R$4,80");
	}

	@Test
	void testGetPrecoComPromo() {
		fail("Not yet implemented");
	}

	@Test
	void testAplicaPromo() {
		fail("Not yet implemented");
	}
	
	@Test
	void testProdutoCombo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFator() {
		fail("Not yet implemented");
	}

	
}
