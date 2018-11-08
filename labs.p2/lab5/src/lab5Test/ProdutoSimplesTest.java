package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Cliente;
import lab5.ProdutoSimples;

class ProdutoSimplesTest {

	@Test
	void testGetId() {
		ProdutoSimples produto = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		assertEquals(produto.getId(), "Tapioca - Tapioca de queijo");
	}

	@Test
	void testSetDescricao() {
		ProdutoSimples produto = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		produto.setDescricao("Tapioca de carne");
		assertEquals(produto.toString(), "Tapioca - Tapioca de carne - R$3,50");	
	}

	@Test
	void testSetPreco() {
		ProdutoSimples produto = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		produto.setPreco("2,00");
		assertEquals(produto.toString(), "Tapioca - Tapioca de queijo - R$2,00");
	}

	@Test
	void testToString() {
		ProdutoSimples produto = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		assertEquals(produto.toString(), "Tapioca - Tapioca de queijo - R$3,50");
	}

	@Test
	void testEqualsObject() {
		ProdutoSimples produto1 = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		ProdutoSimples produto2 = new ProdutoSimples("Tapioca", "Tapioca de carne", "3.50");
		ProdutoSimples produto3 = new ProdutoSimples("Tapioca", "Tapioca de queijo", "4.50");
		assertEquals(produto1.equals(produto2), false);
		assertEquals(produto1.equals(produto3), true);	
	}
	
	@Test
	void testHashCode() {
		ProdutoSimples produto1 = new ProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		ProdutoSimples produto2 = new ProdutoSimples("Tapioca", "Tapioca de carne", "3.50");
		int h1 = produto1.hashCode();
		int h2 = produto2.hashCode();
		assertEquals(h1 != h2, true);
		assertEquals(h1 == h1, true);
	}

}
