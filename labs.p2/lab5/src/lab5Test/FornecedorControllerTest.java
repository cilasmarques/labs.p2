package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.FornecedorController;

class FornecedorControllerTest {


	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CADASTRA
	@Test
	void testAdicionaFornecedor() {
		FornecedorController fornecedor = new FornecedorController();
		assertEquals(fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999"), "Cilas");		
	}

	@Test
	void testAdicionaFornecedorNomeVazio() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor("", "cilas@meuemail.com", "(83)9.99999-9999");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaFornecedorNomeNulo() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor(null, "cilas@meuemail.com", "(83)9.99999-9999");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaFornecedorEmailVazio() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor("Cilas", "", "(83)9.99999-9999");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaFornecedorEmailNulo() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor("Cilas", null, "(83)9.99999-9999");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaFornecedorTelefoneVazio() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaFornecedorTelefoneNulo() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", null);
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EDITA

	@Test
	void testEditaFornecedorEmail() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.editaFornecedor("Cilas", "email", "unliked@meuemail.com");
		assertEquals(fornecedor.exibeFornecedor("Cilas"), "Cilas - unliked@meuemail.com - (83)9.99999-9999");
	}

	@Test
	void testEditaFornecedorTelefone() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.editaFornecedor("Cilas", "telefone", "(83)9.99999-9991");
		assertEquals(fornecedor.exibeFornecedor("Cilas"), "Cilas - cilas@meuemail.com - (83)9.99999-9991");
	}
	
	@Test
	void testEditaFornecedorNome() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.editaFornecedor("Cilas", "nome", "unliked");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
	}

	@Test
	void testEditaFornecedorAtributo() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.editaFornecedor("Cilas", "a", "(83)9.99999-9999");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EXIBE
	@Test
	void testExibeFornecedor() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		assertEquals(fornecedor.exibeFornecedor("Cilas"), "Cilas - cilas@meuemail.com - (83)9.99999-9999");
	}

	@Test
	void testExibeTodosFornecedores() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.adicionaFornecedor("Milena", "milena@delaemail.com", "(83)9.0000.0000");
		assertEquals(fornecedor.exibeTodos(),"Cilas - cilas@meuemail.com - (83)9.99999-9999 | Milena - milena@delaemail.com - (83)9.0000.0000");
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVE
	@Test
	void testRemoveFornecedor() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.removeFornecedor("Cilas");
		try {
			fornecedor.exibeFornecedor("Cilas");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CADASTRA
	@Test
	void testAdicionaProduto() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		assertEquals(fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50"), "Tapioca - Tapioca de queijo");		
	}

	@Test
	void testAdicionaProdutoFornecedorNulo() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.cadastraProdutoSimples(null, "Tapioca", "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaProdutoFornecedorVazio() {
		FornecedorController fornecedor = new FornecedorController();
		try {
			fornecedor.cadastraProdutoSimples("", "Tapioca", "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaProdutoNomeNulo() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", null, "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaProdutoNomeVazio() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", "", "Tapioca de queijo", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaProdutoDescicaoNula() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", null, "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}

	@Test
	void testAdicionaProdutoDescicaoVazia() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "", "3.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testAdicionaProdutoPrecoNulo() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", null);
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaProdutoPrecoVazio() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		try {
			fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EDITA
	@Test
	void testEditaProduto() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.editaProdutoSimples("Tapioca", "Tapioca de queijo", "Cilas",  "2.50");
		assertEquals(fornecedor.exibeProduto("Tapioca", "Tapioca de queijo", "Cilas"), "Tapioca - Tapioca de queijo - R$2,50");
	}
	
	@Test
	void testEditaProduto2() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("", "Tapioca de queijo", "Cilas",  "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testEditaProduto3() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("Tapioca", "", "Cilas",  "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testEditaProduto4() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		try {
			fornecedor.editaProdutoSimples("Tapioca", "Falsa", "Cilas",  "2.50");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do produto: produto nao existe.");
		}
	}
		
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EXIBE
	@Test
	void testExibeProduto() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		assertEquals(fornecedor.exibeProduto("Tapioca", "Tapioca de queijo", "Cilas"), "Tapioca - Tapioca de queijo - R$3,50");
		}

	@Test
	void testExibirTodosProdutos() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.cadastraProdutoSimples("Cilas", "Pudim", "Pudim de leite", "3.50");
		assertEquals(fornecedor.exibeTodosProdutos(), "Cilas - Pudim - Pudim de leite - R$3,50 | Cilas - Tapioca - Tapioca de queijo - R$3,50");
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVE
	@Test
	void testRemoverProduto() {
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("Cilas", "cilas@meuemail.com", "(83)9.99999-9999");
		fornecedor.cadastraProdutoSimples("Cilas", "Tapioca", "Tapioca de queijo", "3.50");
		fornecedor.removeProduto("Tapioca", "Tapioca de queijo","Cilas");
		try {
			fornecedor.exibeProduto("Tapioca", "Tapioca de queijo", "Cilas");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}
	
	
}

