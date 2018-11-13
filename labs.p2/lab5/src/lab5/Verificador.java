package lab5;

import java.util.Map;

import lab5.pessoas.Cliente;
import lab5.pessoas.Fornecedor;

public class Verificador {

	/**
	 * 
	 * Metodo que verifica se pode adicionar uma cliente
	 *
	 * 
	 * @param cpf         cpf do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * @param map         mapa que contem os cliente cadastrados
	 */
	public void verificadorAdicionaCliente(String cpf, String nome, String email, String localizacao,
			Map<String, Cliente> map) {
		verificadorExiste(cpf, "Erro no cadastro do cliente: cliente ja existe.", map);
		verificadorParametro(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		verificadorParametro(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		verificadorParametro(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		verificadorParametro(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		verifcadorCPF(cpf, "Erro no cadastro do cliente: cpf invalido.");
	}

	/**
	 * 
	 * Metodo que verifica se pode adicionar um fornecedor
	 *
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @param map      mapa que contem os fornecedores cadastrados
	 */
	public void verificadorAdicionaFornecedor(String nome, String email, String telefone, Map<String, Fornecedor> map) {
		verificadorExiste(nome, "Erro no cadastro de fornecedor: fornecedor ja existe.", map);
		verificadorParametro(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		verificadorParametro(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		verificadorParametro(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
	}

	/**
	 * Metodo que verifica se pode editar uma pessoa
	 * 
	 * @param id        identificao da pessoa
	 * @param atributo  atributo a ser editado
	 * @param novoValor novo valor do atributo
	 * @param analisado campo onde esta sendo chamada a verificacao
	 * @param map       mapa a ser analisado
	 */
	public void verificadorEditaPessoa(String id, String atributo, String novoValor, String analisado, Map<?, ?> map) {
		verificadorNaoExiste(id, "Erro na edicao do " + analisado + ": " + analisado + " nao existe.", map);
		verificadorParametro(atributo, "Erro na edicao do " + analisado + ": atributo nao pode ser vazio ou nulo.");
		verificadorParametro(novoValor, "Erro na edicao do " + analisado + ": novo valor nao pode ser vazio ou nulo.");
	}

	/**
	 * Metodo que verifica se pode exibir um fornecedor
	 * 
	 * @param id        identificao da pessoa
	 * @param analisado campo onde esta sendo chamada a verificacao
	 * @param map       mapa a de fornecedores
	 */
	public void verificadorExibeFornecedor(String id, String analisado, Map<String, Fornecedor> map) {
		verificadorNaoExiste(id, "Erro na exibicao do " + analisado + ": " + analisado + " nao existe.", map);
	}

	/**
	 * Metodo que verifica se pode remover um fornecedor
	 * 
	 * @param nome nome do fornecedor
	 */
	public void verificadorRemoveFornecedor(String nome) {
		verificadorParametro(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
	}

	/**
	 * Metodo que verifica se pode adicionar um produto simples
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 */
	public void verificadorAdicionaProdSimples(String nomeFornecedor, String nomeProduto, String descricao,
			String preco) {
		verificadorParametro(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		verificadorParametro(preco, "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		double precoDouble = Double.parseDouble(preco);
		if (precoDouble < 0)
			throw new Error("Erro no cadastro de produto: preco invalido.");
	}

	/**
	 * Metodo que verifica se pode adicionar um produto simples
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param fator          fator do produto
	 * @param prodtuos       produtos que compoem o combo
	 */
	public void verificadorAdicionaProdCombo(String nomeFornecedor, String nomeProduto, String descricao, String fator,
			String produtos) {
		verificadorParametro(nomeProduto, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		verificadorParametro(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		double fatorDouble = Double.parseDouble(fator);
		if (1 <= fatorDouble || fatorDouble <= 0)
			throw new Error("Erro no cadastro de combo: fator invalido.");
	}

	/**
	 * Metodo que verifica se pode editar um produto simples
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param novoPreco   novo preco do produto
	 */
	public void verificadorEditaProdSimples(String nomeProduto, String descricao, String novoPreco) {
		verificadorParametro(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		double precoDouble = Double.parseDouble(novoPreco);
		if (precoDouble < 0)
			throw new Error("Erro na edicao de produto: preco invalido.");
	}

	/**
	 * Metodo que verifica se pode editar um produto combo
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param novoFator   novo fator do produto
	 */
	public void verificadorEditaProdCombo(String nomeProduto, String descricao, String novoFator) {
		verificadorParametro(nomeProduto, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		double fatorDouble = Double.parseDouble(novoFator);
		if (1 <= fatorDouble || fatorDouble <= 0)
			throw new Error("Erro na edicao de combo: fator invalido.");
	}

	/**
	 * Metodo que verifica se pode exibir um produto
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 */
	public void verificadorExibeProduto(String nomeProduto, String descricao) {
		verificadorParametro(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
	}

	/**
	 * Metodo que verifica se pode remover um produto
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 */
	public void verificadorRemocaoProd(String nomeProduto, String descricao) {
		verificadorParametro(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
	}

	/**
	 * Metodo que verifica se pode pegar o debito de uma conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param fornecedores   mapa de fornecedores
	 */
	public void verificaGetDebito(String cpf, String nomeFornecedor, Map<String, Fornecedor> fornecedores) {
		verifcadorCPF(cpf, "Erro ao recuperar debito: cpf invalido.");
		verificadorParametro(nomeFornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		verificadorNaoExiste(nomeFornecedor, "Erro ao recuperar debito: fornecedor nao existe.", fornecedores);
	}

	/**
	 * Metodo que verifica se pode exibir conta espeficica
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param fornecedores   mapa de fornecedores
	 */
	public void verificadorExibeContas(String cpf, String nomeFornecedor, Map<String, Fornecedor> fornecedores) {
		verifcadorCPF(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		verificadorParametro(nomeFornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		verificadorNaoExiste(nomeFornecedor, "Erro ao exibir conta do cliente: fornecedor nao existe.", fornecedores);
	}

	/**
	 * Metodo que verifica se pode realizar um pagamento
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param fornecedores   mapa de fornecedores
	 */
	public void verificadorRealizaPagamento(String cpf, String nomeFornecedor, Map<String, Fornecedor> fornecedores) {
		verificadorParametro(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		verifcadorCPF(cpf, "Erro no pagamento de conta: cpf invalido.");
		verificadorParametro(nomeFornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		verificadorNaoExiste(nomeFornecedor, "Erro no pagamento de conta: fornecedor nao existe.", fornecedores);
	}

	/**
	 * Metodo que verifica se o CPF eh valido, lancando um Error caso nao seja
	 * 
	 * @param cpf   cpf do cliente
	 * @param saida saida a ser exibida no erro
	 */
	public void verifcadorCPF(String cpf, String saida) {
		if (cpf.length() != 11)
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se um parametro eh nulo ou nao
	 * 
	 * @param parametro parametro a ser analisado
	 * @param saida     mensagem retornada caso o parametro seja invalido
	 */
	public void verificadorParametro(String parametro, String saida) {
		if (parametro == null || parametro.trim().equals(""))
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se uma chave existe em um determinado mapa
	 * 
	 * @param key   chave a ser analisada
	 * @param saida mensagem retornada caso a chave exista
	 * @param mapa  mapa a ser analisado se contem a chave
	 */
	public void verificadorExiste(String key, String saida, Map<?, ?> array) {
		if (array.containsKey(key))
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se uma chave nao existe em um determinado mapa
	 * 
	 * @param key   chave a ser analisada
	 * @param saida mensagem retornada caso a nao chave exista
	 * @param mapa  mapa a ser analisado se contem a chave
	 */
	public void verificadorNaoExiste(String key, String saida, Map<?, ?> array) {
		if (!array.containsKey(key))
			throw new NullPointerException(saida);
	}
	
	/* Metodo que esta no GeralController e que esta bugando.
	 * 
	 * public void verificadorAdicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descrProd, Map<String, Fornecedor> fornecedores, Map<String, Comida> produtos, Map<String, Cliente> clientes) {
		String id = nomeProd + " - " + descrProd;
		if (cpf.length() != 11)
			throw new Error("Erro ao cadastrar compra: cpf invalido.");
		verificadorParametro(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		verificadorParametro(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		verificadorParametro(descrProd, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
		verificadorParametro(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		verificadorNaoExiste(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao existe.", fornecedores);
		verificadorNaoExiste(cpf, "Erro ao cadastrar compra: cliente nao existe.", clientes);
		if (data.length() != 10)
			throw new Error("Erro ao cadastrar compra: data invalida.");
		verificadorNaoExiste(id, "Erro ao cadastrar compra: produto nao existe.", produtos);
	}*/
	
}
