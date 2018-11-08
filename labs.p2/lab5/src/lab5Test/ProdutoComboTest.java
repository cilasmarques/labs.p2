package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.ProdutoCombo;
import lab5.ProdutoSimples;

class ProdutoComboTest {

	@Test
	void testGetId() {
		ProdutoCombo produtoCombo = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		assertEquals(produtoCombo.getId(), "Tapioca + Coca - Tapioca de queijo com CocaCola");
	}

	@Test
	void testToString() {
		ProdutoCombo produtoCombo = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		assertEquals(produtoCombo.toString(), "Tapioca + Coca - Tapioca de queijo com CocaCola - R$4,50");
	}

	@Test
	void testSetFator() {
		ProdutoCombo produtoCombo = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		produtoCombo.setFator("0.125");
		assertEquals(produtoCombo.toString(), "Tapioca + Coca - Tapioca de queijo com CocaCola - R$5,25");
		
	}

	@Test
	void testEqualsObject() {
		ProdutoCombo produtoCombo1 = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		ProdutoCombo produtoCombo2 = new ProdutoCombo("Tapioca + Pesi", "Tapioca de queijo com PepsiCola", "0.50", "Tapioca - Tapioca de queijo - R$3,50, Pepsi - PespiCola tradicional - R$2,00");
		ProdutoCombo produtoCombo3 = new ProdutoCombo("Tapioca + Refrigerante", "Tapioca de queijo com Refrigerante", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		assertEquals(produtoCombo1.equals(produtoCombo2), false);
		assertEquals(produtoCombo1.equals(produtoCombo3), true);	
	}
	
	
	@Test
	void testHashCode() {
		ProdutoCombo produtoCombo1 = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		ProdutoCombo produtoCombo2 = new ProdutoCombo("Tapioca + Pesi", "Tapioca de queijo com PepsiCola", "0.50", "Tapioca - Tapioca de queijo - R$3,50, Pepsi - PespiCola tradicional - R$2,00");
		int h1 = produtoCombo1.hashCode();
		int h2 = produtoCombo2.hashCode();
		assertEquals(h1 != h2, true);
		assertEquals(h1 == h1, true);
	}

	@Test
	void testGetPrecoComPromo() {
		ProdutoCombo produtoCombo = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		assertEquals(produtoCombo.getPrecoComPromo(), "4,50");
	}

	@Test
	void testAplicaPromo() {
		ProdutoCombo produtoCombo = new ProdutoCombo("Tapioca + Coca", "Tapioca de queijo com CocaCola", "0.25", "Tapioca - Tapioca de queijo - R$3,50, Coca - CocaCola tradicional - R$2,50");
		assertEquals(produtoCombo.aplicaPromo(2.00, 0.50), 1.00);
	}
	
}
