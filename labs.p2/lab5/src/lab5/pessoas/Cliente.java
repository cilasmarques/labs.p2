package lab5.pessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab5.contas.Conta;
import lab5.produtos.Comida;

/**
 * Classe cliente
 * 
 * @author cilas
 *
 */

public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String localizacao;
	private String email;
	private String nome;
	private Map<String, Conta> contas;

	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.cpf = cpf;
		this.contas = new HashMap<>();
	}

	/**
	 * Metodo que permite mudar o nome
	 * 
	 * @param nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que permite mudar o localizacao
	 * 
	 * @param localizacao do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo que permite mudar o email
	 * 
	 * @param email email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.nome);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONTAS / COMPRAS

	public String adicionaCompra(String cpf, String nomeFornecedor, String data, Comida produto) {
		String id = cpf + " - " + nomeFornecedor;
		Conta conta = new Conta();
		if (this.contas.containsKey(id)) {
			this.contas.get(id).adicionaCompra(data, produto);
		} else {
			this.contas.put(id, conta);
			this.contas.get(id).adicionaCompra(data, produto);
		}
		return id;
	}

	public String getDebito(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id))
			throw new Error("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return this.contas.get(id).getDebito();
	}

	public String exibeContas(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id))
			throw new Error("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		return "Cliente: " + this.nome + " | " + nomeFornecedor + this.contas.get(id).toString();
	}

	public String exibeTodasContas(String cpf) {
		String saida = "";
		for (String id: getContasCPF(cpf)) {
			saida += " | " + id.substring(14) + this.contas.get(id).toString();
		}
		return "Cliente: " + this.nome + saida;
	}
	
	private ArrayList<String> getContasCPF(String cpf) {
		ArrayList<String> contasCPF = new ArrayList<>();
		for (String id : this.contas.keySet()) {
			if (id.substring(0, 11).equals(cpf))
				contasCPF.add(id);
		}
		Collections.sort(contasCPF);
		if(contasCPF.size() == 0) 
			throw new Error("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		return contasCPF;
	}
	
}
