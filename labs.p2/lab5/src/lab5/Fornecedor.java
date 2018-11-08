package lab5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Fornecedor
 * 
 * @author cilas
 *
 */
public class Fornecedor extends GestorProdutos implements Comparable<Fornecedor> {

	private String telefone;
	private String email;
	private String nome;
	private GeralController gc;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.gc = new GeralController();
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
		if (podeAdicionarProdutoSimples(nomeProduto, descricao, preco))
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
		gc.verificadorParametro(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		verificadorPreco(novoPreco, "Erro na edicao de produto: preco invalido.");
		gc.verificadorNaoExiste(id, "Erro na edicao do produto: produto nao existe.", this.produtos);
		ehProdutoSimples(id).setPreco(novoPreco);
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBOS
	
	public String cadastraProdutoCombo(String nomeProduto, String descricao, String fator, String produtos) {
		ProdutoCombo produto = new ProdutoCombo(nomeProduto, descricao, fator, produtos);
		if (podeAdicionarProdutoCombo(nomeProduto, descricao, fator, produtos)) {
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
		gc.verificadorParametro(nomeProduto, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		gc.verificadorNaoExiste(id, "Erro na edicao de combo: produto nao existe.", this.produtos);
		verificadorFator(novoFator, "Erro na edicao de combo: fator invalido.");
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
		gc.verificadorParametro(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		gc.verificadorNaoExiste(id, "Erro na exibicao de produto: produto nao existe.", this.produtos);
		return this.produtos.get(id).toString();
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeTodosProdutos() {
		return gc.arrayToString(sortArrayProdutosFornecedores());
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricao) {
		String id = nomeProduto + " - " + descricao;
		gc.verificadorParametro(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		gc.verificadorNaoExiste(id, "Erro na remocao de produto: produto nao existe.", this.produtos);
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
	private boolean podeAdicionarProdutoSimples(String nomeProduto, String descricao, String preco) {
		String id = nomeProduto + " - " + descricao;
		gc.verificadorParametro(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		gc.verificadorParametro(preco, "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		gc.verificadorExiste(id, "Erro no cadastro de produto: produto ja existe.", this.produtos);
		verificadorPreco(preco, "Erro no cadastro de produto: preco invalido.");
		return true;
	}
	
	private boolean podeAdicionarProdutoCombo(String nomeProduto, String descricao, String fator, String produtos) {
		String id = nomeProduto + " - " + descricao;
		gc.verificadorParametro(nomeProduto, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		gc.verificadorParametro(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		gc.verificadorExiste(id, "Erro no cadastro de combo: combo ja existe.", this.produtos);
		verificadorFator(fator, "Erro no cadastro de combo: fator invalido.");
		produtosComboValido(produtos, (nomeProduto + " - " + descricao));
		return true;
	}

	/**
	 * Metodo que cria um array com a representação em String dos produtos
	 * 
	 * @return array com representacao String dos produtos
	 */
	private ArrayList<String> sortArrayProdutosFornecedores() {
		@SuppressWarnings("unchecked")
		ArrayList<Comida> arrayProdutos = (ArrayList<Comida>) gc.makeArray(this.produtos);
		ArrayList<String> arrayStringProdutos = new ArrayList<>();
		Collections.sort(arrayProdutos);
		arrayStringProdutos.add(this.nome + " - " + arrayProdutos.get(0).toString());
		for (int i = 1; i < arrayProdutos.size(); i++) {
			arrayStringProdutos.add(this.nome + " - " + arrayProdutos.get(i).toString());
		}
		return arrayStringProdutos;
	}
}


