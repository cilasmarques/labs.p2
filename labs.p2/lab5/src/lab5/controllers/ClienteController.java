package lab5.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab5.pessoas.Cliente;
import lab5.produtos.Comida;

/**
 * Controlador de cliente
 * 
 * @author cilas
 *
 */
public class ClienteController {

	private Map<String, Cliente> clientes;

	public ClienteController() {
		this.clientes = new HashMap<>();
	}

	/**
	 * Metodo que permite pegar o mapa de clientes
	 * 
	 * @return Retorna o mapa de clientes
	 */
	public Map<String, Cliente> getClientes() {
		return this.clientes;
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
		this.clientes.put(cpf, cliente);
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
		if (!this.clientes.containsKey(cpf))
			throw new Error("Erro na edicao do cliente: cliente nao existe.");
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
		if (!this.clientes.containsKey(cpf))
			throw new Error("Erro na exibicao do cliente: cliente nao existe.");
		return this.clientes.get(cpf).toString();
	}

	/**
	 * Metodo que exibe todos os clientes cadastrados
	 * 
	 * @return String com todos os clientes cadastrados
	 */
	public String exibeTodos() {
		ArrayList<Cliente> arrayClientes = getArrayClientes();
		Collections.sort(arrayClientes);
		return arrayToString(arrayClientes);
	}

	/**
	 * Metodo que remove um cliente a partir do cpf
	 * 
	 * @param cpf cpf do cliente
	 */
	public void removeCliente(String cpf) {
		this.clientes.remove(cpf);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONTAS / COMPRAS

	/**
	 * Metodo que adiciona uma compra de um cliente
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param data           data da compra
	 * @param produto        produto a ser adicionado
	 * @return String com o id da conta do cliente
	 */
	public String adicionaCompra(String cpf, String nomeFornecedor, String data, Comida produto) {
		return clienteValido(cpf, "ao cadastrar compra").adicionaCompra(cpf, nomeFornecedor, data, produto);
	}

	/**
	 * Metodo que pega o debito da conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return String com o preco da divida
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		return clienteValido(cpf, "ao recuperar debito").getDebito(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que exibe uma determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return Strinf com a conta especificada
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		return clienteValido(cpf, "ao exibir conta do cliente").exibeContas(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todas as contas de um cliente
	 * 
	 * @param cpf cpf do cliente
	 * @return String com todas as contas do cliente
	 */
	public String exibeContasCliente(String cpf) {
		return clienteValido(cpf, "ao exibir contas do cliente").exibeTodasContas(cpf);
	}

	/**
	 * Metodo que realiza o pagamento de determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String nomeFornecedor) {
		clienteValido(cpf, "no pagamento de conta").realizaPagamento(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que pega um cliente valido
	 * 
	 * @param cpf   cpf do cliente
	 * @param campo campo onde esta sendo chamada o metodo
	 * @return cliente valido
	 */
	private Cliente clienteValido(String cpf, String campo) {
		if (cpf == null || cpf.trim().equals(""))
			throw new Error("Erro " + campo + ": cliente nao pode ser vazio ou nulo.");
		else if (!this.clientes.containsKey(cpf))
			throw new Error("Erro " + campo + ": cliente nao existe.");
		Cliente cliente = clientes.get(cpf);
		return cliente;
	}

	/**
	 * Metodo que transforma o mapa de clientes em um array
	 * 
	 * @return Array de clientes
	 */
	private ArrayList<Cliente> getArrayClientes() {
		ArrayList<Cliente> arrayDeInfos = new ArrayList<>();
		for (Object key : this.clientes.keySet()) {
			arrayDeInfos.add(this.clientes.get(key));
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que coloca as informações de um array em uma unica string
	 * 
	 * @param arrayClientes array a ser convertido
	 * @return String com as informações do array
	 */
	private String arrayToString(ArrayList<Cliente> arrayClientes) {
		ArrayList<String> arrayDeInfos = new ArrayList<>();
		for (int i = 0; i < arrayClientes.size(); i++) {
			arrayDeInfos.add(arrayClientes.get(i).toString());
		}

		String saida = arrayClientes.get(0).toString();
		for (int i = 1; i < arrayClientes.size(); i++) {
			saida += " | " + arrayClientes.get(i);
		}
		return saida;
	}

}
