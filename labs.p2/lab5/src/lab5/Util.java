package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lab5.pessoas.Cliente;
import lab5.pessoas.Fornecedor;
import lab5.produtos.Comida;

public class Util {

	public void verificadorAdicionaCliente(String cpf, String nome, String email, String localizacao,
			Map<String, Cliente> map) {
		verificadorExiste(cpf, "Erro no cadastro do cliente: cliente ja existe.", map);
		verificadorParametro(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		verificadorParametro(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		verificadorParametro(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		verificadorParametro(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11)
			throw new Error("Erro no cadastro do cliente: cpf invalido.");
	}

	public void verificadorAdicionaFornecedor(String nome, String email, String telefone, Map<String, Fornecedor> map) {
		verificadorExiste(nome, "Erro no cadastro de fornecedor: fornecedor ja existe.", map);
		verificadorParametro(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		verificadorParametro(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		verificadorParametro(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
	}

	public void verificadorEditaPessoa(String id, String atributo, String novoValor, String analisado, Map<?, ?> map) {
		verificadorNaoExiste(id, "Erro na edicao do " + analisado + ": " + analisado + " nao existe.", map);
		verificadorParametro(atributo, "Erro na edicao do " + analisado + ": atributo nao pode ser vazio ou nulo.");
		verificadorParametro(novoValor, "Erro na edicao do " + analisado + ": novo valor nao pode ser vazio ou nulo.");
	}

	public void verificadorExibeFornecedor(String id, String analisado, Map<String, Fornecedor> map) {
		verificadorNaoExiste(id, "Erro na exibicao do " + analisado + ": " + analisado + " nao existe.", map);
	}

	public void verificadorRemoveFornecedor(String nome) {
		verificadorParametro(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
	}

	public void verificadorAdicionaProdSimples(String nomeFornecedor, String nomeProduto, String descricao,
			String preco) {
		verificadorParametro(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		verificadorParametro(preco, "Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
		double precoDouble = Double.parseDouble(preco);
		if (precoDouble < 0)
			throw new Error("Erro no cadastro de produto: preco invalido.");
	}

	public void verificadorAdicionaProdCombo(String nomeFornecedor, String nomeProduto, String descricao, String fator,
			String produtos) {
		verificadorParametro(nomeProduto, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		verificadorParametro(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		double fatorDouble = Double.parseDouble(fator);
		if (1 <= fatorDouble || fatorDouble <= 0)
			throw new Error("Erro no cadastro de combo: fator invalido.");
	}

	public void verificadorEditaProdSimples(String nomeProduto, String descricao, String novoPreco) {
		verificadorParametro(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		double precoDouble = Double.parseDouble(novoPreco);
		if (precoDouble < 0)
			throw new Error("Erro na edicao de produto: preco invalido.");
	}

	public void verificadorEditaProdCombo(String nomeProduto, String descricao, String novoFator) {
		verificadorParametro(nomeProduto, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		double fatorDouble = Double.parseDouble(novoFator);
		if (1 <= fatorDouble || fatorDouble <= 0)
			throw new Error("Erro na edicao de combo: fator invalido.");
	}

	public void verificadorExibeProduto(String nomeProduto, String descricao) {
		verificadorParametro(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
	}

	public void verificadorRemocaoProd(String nomeProduto, String descricao) {
		verificadorParametro(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		verificadorParametro(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
	}

	public void verificadorAdicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd,
			String descrProd, Map<String, Fornecedor> fornecedores, Map<String, Comida> produtos, Map<String, Cliente> clientes) {
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
		}

	public ArrayList<?> makeArray(Map<?, ?> map) {
		ArrayList<Object> arrayDeInfos = new ArrayList<>();
		for (Object key : map.keySet()) {
			arrayDeInfos.add(map.get(key));
		}
		return arrayDeInfos;
	}

	public ArrayList<String> arrayInfosToString(ArrayList<?> array) {
		ArrayList<String> arrayDeInfos = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			arrayDeInfos.add(array.get(i).toString());
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que coloca as informações de um array em uma unica string
	 * 
	 * @param array array a ser convertido
	 * @return String com as informações do array
	 */
	public String arrayToString(List<String> array) {
		String saida = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			saida += " | " + array.get(i);
		}
		return saida;
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

}
