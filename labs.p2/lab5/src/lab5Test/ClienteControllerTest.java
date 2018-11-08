package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.ClienteController;

class ClienteControllerTest {

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CADASTRA
	@Test
	void testAdicionaCliente() {
		ClienteController cliente = new ClienteController();
		assertEquals(cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra"), "66666666613");
	}

	@Test
	void testAdicionaClienteCPFInvalido() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("123", "Cilas", "cilas@meuemail.com", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: cpf invalido.");
		}
	}

	@Test
	void testAdicionaClienteCPFVazio() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("", "Cilas", "cilas@meuemail.com", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteCPFNulo() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente(null, "Cilas", "cilas@meuemail.com", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteNomeVazio() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", "", "cilas@meuemail.com", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteNomeNulo() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", null, "cilas@meuemail.com", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteEmailVazio() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", "Cilas", "", "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteEmailNulo() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", "Cilas", null, "Terra");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testAdicionaClienteLocalizacaoVazio() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}

	@Test
	void testAdicionaClienteLocalizacaoNulo() {
		ClienteController cliente = new ClienteController();
		try {
			cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", null);
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EDITA

	@Test
	void testEditaClienteNome() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente.editaCliente("66666666613", "nome", "Unliked");
		assertEquals(cliente.exibeCliente("66666666613"), "Unliked - Terra - cilas@meuemail.com");
	}

	@Test
	void testEditaClienteEmail() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente.editaCliente("66666666613", "email", "unliked@meuemail.com");
		assertEquals(cliente.exibeCliente("66666666613"), "Cilas - Terra - unliked@meuemail.com");
	}

	@Test
	void testEditaClienteLocalizacao() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente.editaCliente("66666666613", "localizacao", "Marte");
		assertEquals(cliente.exibeCliente("66666666613"), "Cilas - Marte - cilas@meuemail.com");
	}

	@Test
	void testEditaClienteAtributo() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		try {
			cliente.editaCliente("66666666613", "a", "Marte");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do cliente: atributo nao existe.");
		}
	}

	@Test
	void testEditaClienteLocalizacaoNulo() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		try {
			cliente.editaCliente("66666666613", "localizacao", null);
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}

	// // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EXIBE
	@Test
	void testExibeCliente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		assertEquals(cliente.exibeCliente("66666666613"), "Cilas - Terra - cilas@meuemail.com");
	}

	@Test
	void testExibeTodosClientes() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente.adicionaCliente("99999999913", "Milena", "milena@delaemail.com", "Terra");
		assertEquals(cliente.exibeTodos(), "Cilas - Terra - cilas@meuemail.com | Milena - Terra - milena@delaemail.com");
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVE
	@Test
	void testRemoveCliente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente.removeCliente("66666666613");
		try {
			cliente.exibeCliente("66666666613");
		} catch (Error erro) {
			assertEquals(erro.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}
}
