package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GestorProdutos {

	protected Map<String, Produto> produtos = new HashMap<>();
	protected GeralController gc = new GeralController();
	
	protected ArrayList<String> getProdSimples(Map<String, Produto> produtos) {
		ArrayList<String> produtosSimples = new ArrayList<>();
		for (String key: produtos.keySet()) {
			if(produtos.get(key).getClass().equals(ProdutoSimples.class))
				produtosSimples.add(produtos.get(key).toString());
		}
		Collections.sort(produtosSimples);
		return produtosSimples;
	}
	
	protected ArrayList<String> getProdCombo(Map<String, Produto> produtos) {
		ArrayList<String> produtosCombo = new ArrayList<>();
		for (String key: produtos.keySet()) {
			if(produtos.get(key).getClass().equals(ProdutoCombo.class))
				produtosCombo.add(produtos.get(key).toString());
		}
		Collections.sort(produtosCombo);
		return produtosCombo;
	}
	
	protected ProdutoSimples ehProdutoSimples(String id) {
		if (this.produtos.containsKey(id) && this.produtos.get(id).getClass().equals(ProdutoSimples.class))
			return (ProdutoSimples) this.produtos.get(id);
		throw new Error("Produto nao eh simples");
	}
	
	protected ProdutoCombo ehProdutoCombo(String id) {
		if (this.produtos.containsKey(id) && this.produtos.get(id).getClass().equals(ProdutoCombo.class))
			return (ProdutoCombo) this.produtos.get(id);
		throw new Error("Produto nao eh combo");
	}
	
	protected void produtosComboValido(String produtos, String id) {
		for (String produto: (produtos.split(", "))) {
			gc.verificadorNaoExiste(produto, "Erro no cadastro de combo: produto nao existe.", this.produtos);
			if (this.produtos.containsKey(produto) && this.produtos.get(produto).getClass().equals(ProdutoCombo.class))
				throw new Error("Erro no cadastro de combo: um combo n�o pode possuir combos na lista de produtos.");
		}
	}
	
	protected String getProdutosComPreco(String produtos) {
		String produtosComPreco = "";
		for (String produto: (produtos.split(", "))) {
			produtosComPreco += this.produtos.get(produto).toString();
		}
		return produtosComPreco;
	}
	
	/**
	 * Metodo que verifica se o fator eh valido
	 * 
	 * @param fator fator a ser analisado
	 * @param saida saida caso o preco nao seja valido
	 */
	protected void verificadorFator(String fator, String saida) {
		double fatorDouble = Double.parseDouble(fator);
		if (1 <= fatorDouble || fatorDouble < 0)
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se o preco eh valido
	 * 
	 * @param preco preco a ser analisado
	 * @param saida saida caso o preco nao seja valido
	 */
	protected void verificadorPreco(String preco, String saida) {
		double precoDouble = Double.parseDouble(preco);
		if (precoDouble < 0)
			throw new Error(saida);
	}
}
