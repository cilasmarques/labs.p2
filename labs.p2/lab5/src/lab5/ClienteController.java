package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de cliente
 * 
 * @author cilas
 *
 */
public class ClienteController {

	private Map<String, Cliente> clientes;
	private GeralController gc;

	public ClienteController() {
		this.clientes = new HashMap<>();
		this.gc = new GeralController();
	}

	/**
	 * Metodo que adiciona um cliente
	 * 
	 * @param cpf         cpf do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * 
	 * @return String mostrandp o cpf do cliente adicionado
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		if (podeAdicionarCliente(cpf, nome, email, localizacao)) {
			this.clientes.put(cpf, cliente);
		}
		return cpf;
	}

	/**
	 * Metodo que edita um cliente
	 * 
	 * @param cpf       cpf do cliente
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		gc.verificadorParametro(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		gc.verificadorParametro(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		gc.verificadorNaoExiste(cpf, "Erro na edicao do cliente: cliente nao existe.", this.clientes);
		switch (atributo) {
		case "nome":
			this.clientes.get(cpf).setNome(novoValor);
			return;
		case "email":
			this.clientes.get(cpf).setEmail(novoValor);
			return;
		case "localizacao":
			this.clientes.get(cpf).setLocalizacao(novoValor);
			return;
		default:
			throw new Error("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	/**
	 * Metodo que exibe um cliente determinado
	 * 
	 * @param cpf cpf do cliente
	 * @return String que representa o cliente
	 */
	public String exibeCliente(String cpf) {
		gc.verificadorNaoExiste(cpf, "Erro na exibicao do cliente: cliente nao existe.", this.clientes);
		return this.clientes.get(cpf).toString();
	}

	/**
	 * Metodo que exibe todos os clientes cadastrados
	 * 
	 * @return String com todos os clientes cadastrados
	 */
	public String exibeTodos() {
		@SuppressWarnings("unchecked")
		ArrayList<Cliente> arrayClientes = (ArrayList<Cliente>) gc.makeArray(this.clientes);
		Collections.sort(arrayClientes);
		ArrayList<String> arrayStringsClientes = gc.arrayInfosToString(arrayClientes);
		return gc.arrayToString(arrayStringsClientes);
	}

	/**
	 * Metodo que remove um cliente a partir do cpf
	 * 
	 * @param cpf cpf do cliente
	 */
	public void removeCliente(String cpf) {
		this.clientes.remove(cpf);
	}

	/**
	 * Metodo que verifica se os parametros passados para a manipulacao do cliente
	 * sao validos
	 * 
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * @param cpf         cpf do cliente
	 * 
	 * @return String mostrando se o cliente eh valido
	 */
	private boolean podeAdicionarCliente(String cpf, String nome, String email, String localizacao) {
		gc.verificadorExiste(cpf, "Erro no cadastro do cliente: cliente ja existe.", this.clientes);
		gc.verificadorParametro(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		gc.verificadorParametro(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		gc.verificadorParametro(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11)
			throw new Error("Erro no cadastro do cliente: cpf invalido.");
		return true;
	}
}
