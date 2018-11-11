package lab5.pessoas;

import java.util.HashMap;
import java.util.Map;

import lab5.contas.Conta;
import lab5.produtos.ProdutoSimples;

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
	
	public String adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descrProd) {
		String id = cpf + " - " + nomeFornecedor;
		Conta conta = new Conta();
		this.contas.put(id, conta);
		this.contas.get(id).adicionaCompra(data, nomeProd, descrProd);
		return  id;
	}
	
	public String getDebito(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		return this.contas.get(id).getDebito();
	}

	public String exibeContas(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id))
			throw new Error("Erro na exibicao de contas: conta nao existe.");
		return this.contas.get(id).toString();
	}

	public String exibeTodasContas() {
		return "";
	}
	
	
}
