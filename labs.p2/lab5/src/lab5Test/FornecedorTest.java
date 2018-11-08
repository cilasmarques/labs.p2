package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Fornecedor;

class FornecedorTest {

	@Test
	void testSetTelefone() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.setTelefone("(83)9.99999-9991");
		assertEquals(fornecedor.toString(), "Cilas - cilas@meuemail.com - (83)9.99999-9991");
	}

	@Test
	void testSetEmail() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.setEmail("unliked@meuemail.com");
		assertEquals(fornecedor.toString(), "Cilas - unliked@meuemail.com - (83)9.99999-9999");
	}

	@Test
	void testToString() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		assertEquals(fornecedor.toString(), "Cilas - cilas@meuemail.com - (83)9.99999-9999");
	}

	@Test
	void testEqualsObject() {
		Fornecedor fornecedor1 = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		Fornecedor fornecedor2 = new Fornecedor("Unliked", "cilas@meuemail.com", "(83)9.99999-9999");
		Fornecedor fornecedor3 = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-0000");
		assertEquals(fornecedor1.equals(fornecedor2), false);
		assertEquals(fornecedor1.equals(fornecedor3), true);
	}

	@Test
	void testAdicionaProduto() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		assertEquals(fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50"), "Tapioca - Tapioca de queijo");		
	}

	@Test
	void testAdicionaProdutoNomeNulo() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples(null, "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaProdutoNomeVazio() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("", "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaProdutoDescicaoNula() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Tapioca", null, "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}

	@Test
	void testAdicionaProdutoDescicaoVazia() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Tapioca", "", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testAdicionaProdutoPrecoNulo() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", null);
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaProdutoPrecoVazio() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testEditaProduto() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.editaProdutoSimples("Tapioca", "Tapioca de queijo", "2.50");
		assertEquals(fornecedor.exibeProduto("Tapioca", "Tapioca de queijo"), "Tapioca - Tapioca de queijo - R$2,50");
	}
	
	@Test
	void testEditaProduto2() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("", "Tapioca de queijo", "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testEditaProduto3() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("Tapioca", "", "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testEditaProduto4() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("Tapioca", "Falsa",  "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do produto: produto nao existe.");
		}
	}

	@Test
	void testExibeProduto() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples( "Tapioca", "Tapioca de queijo", "3.50");
		assertEquals(fornecedor.exibeProduto("Tapioca", "Tapioca de queijo"), "Tapioca - Tapioca de queijo - R$3,50");
		}

	@Test
	void testExibirTodosProdutos() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.cadastraProdutoSimples("Pudim", "Pudim de leite", "3.50");
		assertEquals(fornecedor.exibeTodosProdutos(), "Cilas - Pudim - Pudim de leite - R$3,50 | Cilas - Tapioca - Tapioca de queijo - R$3,50");
	}

	@Test
	void testRemoverProduto() {
		Fornecedor fornecedor = new Fornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.removeProduto("Tapioca", "Tapioca de queijo");
		try {
			fornecedor.exibeProduto("Tapioca", "Tapioca de queijo");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}
}
