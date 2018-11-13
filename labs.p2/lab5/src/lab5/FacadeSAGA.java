package lab5;

import easyaccept.EasyAccept;
import lab5.controllers.GeralController;

/**
 * Facade principal
 * 
 * @author cilas
 *
 */
public class FacadeSAGA {

	private GeralController gc;

	/**
	 * Construtor de FacadeSAGA, inicializa o ClienteController e o
	 * FornecedorController
	 */
	public FacadeSAGA() {
		this.gc = new GeralController();
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLIENTES
	/**
	 * Metodo que adiciona um cliente
	 * 
	 * @param cpf         cpf do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * @return String mostrandp o cpf do cliente adicionado
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.gc.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * Metodo que edita um cliente
	 * 
	 * @param cpf       cpf do cliente
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.gc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Metodo que exibe um cliente determinado
	 * 
	 * @param cpf cpf do cliente
	 * @return String que representa o cliente
	 */
	public String exibeCliente(String cpf) {
		return this.gc.exibeCliente(cpf);
	}

	/**
	 * Metodo que exibe todos os clientes cadastrados
	 * 
	 * @return String com todos os clientes cadastrados
	 */
	public String exibeClientes() {
		return this.gc.exibeTodosClientes();
	}

	/**
	 * Metodo que remove um cliente a partir do cpf
	 * 
	 * @param cpf cpf do cliente
	 */
	public void removeCliente(String cpf) {
		this.gc.removeCliente(cpf);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FORNECEDORES

	/**
	 * Metodo que adiciona um fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return String mostrandp o nome do fornecedor adicionado
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.gc.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo que edita um fornecedor
	 * 
	 * @param nome      nome do fornecedor
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.gc.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * Metodo que exibe um fornecedor determinado
	 * 
	 * @param nome nome do fornecedor
	 * @return String com uma representacao do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return this.gc.exibeFornecedor(nome);
	}

	/**
	 * Metodo que exibe todos os fornecedores cadastrados
	 * 
	 * @return String com todos os fornecedores cadastrados
	 */
	public String exibeFornecedores() {
		return this.gc.exibeTodosFornecedores();
	}

	/**
	 * Metodo que remove um fornecedor a partir do nome
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		this.gc.removeFornecedor(nome);
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
	public String adicionaProduto(String nomeFornecedor, String nome, String descricao, String preco) {
		return this.gc.adicionaProdutoSimples(nomeFornecedor, nome, descricao, preco);
	}

	/**
	 * Metodo que edita um produto simples
	 * 
	 * @param nome           novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoPreco      novo preco do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaProduto(String nome, String descricao, String nomeFornecedor, String novoPreco) {
		this.gc.editaProdutoSimples(nome, descricao, nomeFornecedor, novoPreco);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBOS
	
	/**
	 * Metodo que adiciona um produto COMBO a um fornecedor 
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param fator          fator do produto
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String adicionaCombo(String nomeFornecedor, String nome, String descricao, String fator, String produtos) {
		return this.gc.adicionaCombo(nomeFornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * Metodo que edita um produto COMBO
	 * 
	 * @param nome           novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoFator      novo fator do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaCombo(String nome, String descricao, String nomeFornecedor, String novoFator) {
		this.gc.editaCombo(nome, descricao, nomeFornecedor, novoFator);
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
	public String exibeProduto(String nome, String descricao, String nomeFornecedor) {
		return this.gc.exibeProduto(nome, descricao, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todoss produtos de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor dos produtos
	 * @return String com todos os produtos de um fornecedor
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return this.gc.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados (de todos os fornecedores)
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeProdutos() {
		return this.gc.exibeTodosProdutos();
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void removeProduto(String nome, String descricao, String nomeFornecedor) {
		this.gc.removeProduto(nome, descricao, nomeFornecedor);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONTAS / COMPRAS
	
	public String adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descrProd) {
		return this.gc.adicionaCompra(cpf, nomeFornecedor, data, nomeProd, descrProd);
	}
	
	public String getDebito(String cpf, String nomeFornecedor) {
		return this.gc.getDebito(cpf , nomeFornecedor);
	}

	public String exibeContas(String cpf, String nomeFornecedor) {
		return this.gc.exibeContas(cpf, nomeFornecedor);
	}

	public String exibeContasClientes(String cpf) {
		return this.gc.exibeContasCliente(cpf);
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EASYACCEPT
	public static void main(String[] args) {
		args = new String[] { "lab5.FacadeSAGA", "acc_tst/use_case_1.txt", "acc_tst/use_case_2.txt",
				"acc_tst/use_case_3.txt", "acc_tst/use_case_4.txt", "acc_tst/use_case_5.txt" };
		EasyAccept.main(args);
	}
}