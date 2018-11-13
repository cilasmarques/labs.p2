package lab5.pessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab5.produtos.Comida;
import lab5.produtos.ProdutoCombo;
import lab5.produtos.ProdutoSimples;

/**
 * Classe Fornecedor
 * 
 * @author cilas
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

	private String telefone;
	private String email;
	private String nome;
	private Map<String, Comida> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/**
	 * Metodo que permite mudar o telefone
	 * 
	 * @param telefone telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo que permite mudar o email
	 * 
	 * @param email email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.nome);
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS SIMPLES
	/**
	 * Metodo que adiciona um produto a um fornecedor
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param preco       preco do produto
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String cadastraProdutoSimples(String nomeProduto, String descricao, String preco) {
		ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricao, preco);
		String id = nomeProduto + " - " + descricao;
		if (this.produtos.containsKey(id))
			throw new Error("Erro no cadastro de produto: produto ja existe.");
		this.produtos.put(produto.getId(), produto);
		return nomeProduto + " - " + descricao;
	}

	/**
	 * Metodo que edita um produto
	 * 
	 * @param nomeProduto novo nome do produto
	 * @param descricao   nova descricao do produto
	 * @param preco       novo preco do produto
	 */
	public void editaProdutoSimples(String nomeProduto, String descricao, String novoPreco) {
		String id = nomeProduto + " - " + descricao;
		if (!this.produtos.containsKey(id))
			throw new Error("Erro na edicao do produto: produto nao existe.");
		ehProdutoSimples(id).setPreco(novoPreco);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBOS

	public String cadastraProdutoCombo(String nomeProduto, String descricao, String fator, String produtos) {
		ProdutoCombo produto = new ProdutoCombo(nomeProduto, descricao, fator, produtos);
		String id = nomeProduto + " - " + descricao;
		if (this.produtos.containsKey(id))
			throw new Error("Erro no cadastro de combo: combo ja existe.");
		
		else if (produtosComboValido(produtos, id)) {
			produto.setProdutos(getProdutosComPreco(produtos));
			this.produtos.put(produto.getId(), produto);
		}
		return nomeProduto + " - " + descricao;
	}

	/**
	 * Metodo que edita um produto combo
	 * 
	 * @param nome           novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoPreco      novo preco do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaProdutoCombo(String nomeProduto, String descricao, String novoFator) {
		String id = nomeProduto + " - " + descricao;
		if (!this.produtos.containsKey(id))
			throw new Error("Erro na edicao de combo: produto nao existe.");
		ehProdutoCombo(id).setFator(novoFator);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS

	/**
	 * Metodo que exibe um produto determinado
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @return String com uma representacao do produto
	 */
	public String exibeProduto(String nomeProduto, String descricao) {
		String id = nomeProduto + " - " + descricao;
		if (!this.produtos.containsKey(id))
			throw new Error("Erro na exibicao de produto: produto nao existe.");
		return this.produtos.get(id).toString();
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeTodosProdutos() {
		ArrayList<Comida> arrayProdutos = getArrayProdutos();
		Collections.sort(arrayProdutos);
		ArrayList<String> arrayStringProdutos = arrayPutInfos(arrayProdutos);
		return arrayToString(arrayStringProdutos);
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricao) {
		String id = nomeProduto + " - " + descricao;
		if (!this.produtos.containsKey(id))
			throw new Error("Erro na remocao de produto: produto nao existe.");
		this.produtos.remove(id);
	}

	/**
	 * Metodo que verifica se os parametros passados para a adicao do produto sao
	 * validos
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   email do produto
	 * @param preco       telefone do produto
	 * @param campo       campo onde esta sendo chamada o metodo
	 * 
	 * @return String mostrando se que o produto eh valido
	 */

	/**
	 * Metodo que cria um array com a representação em String dos produtos
	 * 
	 * @return array com representacao String dos produtos
	 */

	public ArrayList<Comida> getArrayProdutos() {
		ArrayList<Comida> arrayDeInfos = new ArrayList<>();
		for (Object key : this.produtos.keySet()) {
			arrayDeInfos.add(this.produtos.get(key));
		}
		return arrayDeInfos;
	}

	private ArrayList<String> arrayPutInfos(ArrayList<?> arrayProdutos) {
		ArrayList<String> arrayDeInfos = new ArrayList<>();
		for (int i = 0; i < arrayProdutos.size(); i++) {
			arrayDeInfos.add(this.nome + " - " + arrayProdutos.get(i).toString());
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que coloca as informações de um array em uma unica string
	 * 
	 * @param arrayFornecedores array a ser convertido
	 * @return String com as informações do array
	 */
	private String arrayToString(ArrayList<?> arrayFornecedores) {
		String saida = arrayFornecedores.get(0).toString();
		for (int i = 1; i < arrayFornecedores.size(); i++) {
			saida += " | " + arrayFornecedores.get(i);
		}
		return saida;
	}

	private ProdutoSimples ehProdutoSimples(String id) {
		if (this.produtos.containsKey(id) && this.produtos.get(id).getClass().equals(ProdutoSimples.class))
			return (ProdutoSimples) this.produtos.get(id);
		throw new Error("Produto nao eh simples");
	}

	private ProdutoCombo ehProdutoCombo(String id) {
		if (this.produtos.containsKey(id) && this.produtos.get(id).getClass().equals(ProdutoCombo.class))
			return (ProdutoCombo) this.produtos.get(id);
		throw new Error("Produto nao eh combo");
	}

	private String getProdutosComPreco(String produtos) {
		String produtosComPreco = "";
		for (String produto : (produtos.split(", "))) {
			produtosComPreco += this.produtos.get(produto).toString();
		}
		return produtosComPreco;
	}

	private boolean produtosComboValido(String produtos, String id) {
		for (String idProduto : (produtos.split(", "))) {
			if (!this.produtos.containsKey(idProduto))
				throw new Error("Erro no cadastro de combo: produto nao existe.");
			else if (this.produtos.containsKey(idProduto) && this.produtos.get(idProduto).getClass().equals(ProdutoCombo.class))
				throw new Error("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		}
		return true;
	}

	public Map<String, Comida> getProdutos() {
		return this.produtos;
	}

}
