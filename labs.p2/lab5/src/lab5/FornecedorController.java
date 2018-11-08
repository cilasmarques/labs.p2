package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de Fornecedor
 * 
 * @author cilas
 *
 */
public class FornecedorController {

	private Map<String, Fornecedor> fornecedores;
	private GeralController gc;

	public FornecedorController() {
		this.fornecedores = new HashMap<>();
		this.gc = new GeralController();
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FORNECEDOR
	/**
	 * Metodo que adiciona um fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return String mostrandp o nome do fornecedor adicionado
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		if (podeAdicionarFornecedor(nome, email, telefone, "cadastro do fornecedor"))
			this.fornecedores.put(nome, fornecedor);
		return nome;
	}

	/**
	 * Metodo que edita um fornecedor
	 * 
	 * @param nome      nome do fornecedor
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		gc.verificadorParametro(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		gc.verificadorParametro(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		gc.verificadorNaoExiste(nome, "Erro na edicao do fornecedor: fornecedor nao existe.", this.fornecedores);
		switch (atributo) {
		case "nome":
			throw new Error("Erro na edicao do fornecedor: nome nao pode ser editado.");
		case "email":
			this.fornecedores.get(nome).setEmail(novoValor);
			return;
		case "telefone":
			this.fornecedores.get(nome).setTelefone(novoValor);
			return;
		default:
			throw new Error("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	/**
	 * Metodo que exibe um fornecedor determinado
	 * 
	 * @param nome nome do fornecedor
	 * @return String com uma representacao do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		gc.verificadorNaoExiste(nome, "Erro na exibicao do fornecedor: fornecedor nao existe.", this.fornecedores);
		return this.fornecedores.get(nome).toString();
	}

	/**
	 * Metodo que exibe todos os fornecedores cadastrados
	 * 
	 * @return String com todos os fornecedores cadastrados
	 */
	public String exibeTodos() {
		@SuppressWarnings("unchecked")
		ArrayList<Fornecedor> arrayFornecedores = (ArrayList<Fornecedor>) gc.makeArray(this.fornecedores);
		Collections.sort(arrayFornecedores);
		ArrayList<String> arrayStringsFornecedores = gc.arrayInfosToString(arrayFornecedores);
		return gc.arrayToString(arrayStringsFornecedores);
	}

	/**
	 * Metodo que remove um fornecedor a partir do nome
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		gc.verificadorParametro(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		this.fornecedores.remove(nome);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS SIMPLES
	/**
	 * Metodo que adiciona um produto simples a um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String cadastraProdutoSimples(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		return fornecedorValido(nomeFornecedor, "no cadastro de produto").cadastraProdutoSimples(nomeProduto, descricao,
				preco);
	}

	/**
	 * Metodo que edita um produto simples
	 * 
	 * @param nome           novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoPreco      novo preco do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaProdutoSimples(String nomeProduto, String descricao, String nomeFornecedor, String novoPreco) {
		fornecedorValido(nomeFornecedor, "na edicao de produto").editaProdutoSimples(nomeProduto, descricao, novoPreco);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBOS
	
	/**
	 * Metodo que adiciona um produto combo a um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param fator          fator do produto
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String adicionaCombo(String nomeFornecedor, String nomeProduto, String descricao, String fator, String produtos) {
		return fornecedorValido(nomeFornecedor, "no cadastro de combo").cadastraProdutoCombo(nomeProduto, descricao, fator, produtos);
	}

	/**
	 * Metodo que edita um produto combo
	 * 
	 * @param nome           novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoFator      novo fator do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaCombo(String nomeProduto, String descricao, String nomeFornecedor, String novoFator) {
		fornecedorValido(nomeFornecedor, "na edicao de combo").editaProdutoCombo(nomeProduto, descricao, novoFator);
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS 
	
	/**
	 * Metodo que exibe um produto determinado
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @return String com uma representacao do produto
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return fornecedorValido(nomeFornecedor, "na exibicao de produto").exibeProduto(nomeProduto, descricao);
	}

	/**
	 * Metodo que exibe todoss produtos de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor dos produtos
	 * @return String com todos os produtos de um fornecedor
	 */
	public String exibeProdutos(String nomeFornecedor) {
		return fornecedorValido(nomeFornecedor, "na exibicao de produto").exibeTodosProdutos();
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados (de todos os fornecedores)
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeTodosProdutos() {
		@SuppressWarnings("unchecked")
		ArrayList<Fornecedor> arrayFornecedores = (ArrayList<Fornecedor>) gc.makeArray(this.fornecedores);
		ArrayList<String> arrayDeProdutos = new ArrayList<>();
		Collections.sort(arrayFornecedores);
		for (Fornecedor fornecedor : arrayFornecedores) {
			arrayDeProdutos.add(fornecedor.exibeTodosProdutos());
		}
		return gc.arrayToString(arrayDeProdutos);
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		fornecedorValido(nomeFornecedor, "na remocao de produto").removeProduto(nomeProduto, descricao);
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ UTIL
	
	/**
	 * Metodo que verifica se os parametros passados para a adicao do fornecedor sao
	 * validos
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @param campo    campo onde esta sendo chamada o metodo
	 * 
	 * @return String mostrando se que o fornecedor eh valido
	 */
	private boolean podeAdicionarFornecedor(String nome, String email, String telefone, String campo) {
		gc.verificadorExiste(nome, "Erro no cadastro de fornecedor: fornecedor ja existe.", this.fornecedores);
		gc.verificadorParametro(nome, "Erro no " + campo + ": nome nao pode ser vazio ou nulo.");
		gc.verificadorParametro(email, "Erro no " + campo + ": email nao pode ser vazio ou nulo.");
		gc.verificadorParametro(telefone, "Erro no " + campo + ": telefone nao pode ser vazio ou nulo.");
		return true;
	}

	/**
	 * Metodo que pega um fornecedor valido
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param campo          campo onde esta sendo chamada o metodo
	 * @return
	 */
	private Fornecedor fornecedorValido(String nomeFornecedor, String campo) {
		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);
		gc.verificadorParametro(nomeFornecedor, "Erro " + campo + ": fornecedor nao pode ser vazio ou nulo.");
		gc.verificadorNaoExiste(nomeFornecedor, "Erro " + campo + ": fornecedor nao existe.", this.fornecedores);
		return fornecedor;
	}

}
