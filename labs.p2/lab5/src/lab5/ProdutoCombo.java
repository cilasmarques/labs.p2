package lab5;

public class ProdutoCombo extends Comida implements Produto, Promocao {

	private String fator;
	private String produtos;

	public ProdutoCombo(String nomeProduto, String descricao, String fator, String produtos) {
		super(nomeProduto, descricao);
		this.fator = fator;
		this.produtos = produtos;
	}
	
	public void setProdutos(String produtos2) {
		this.produtos = produtos2;
	}

	public void setFator(String novoFator) {
		this.fator = novoFator;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + getPrecoComPromo().replace(".", ",");
	}

	@Override
	public String getPrecoComPromo() {
		double preco = getPreco(produtos);
		double fator = Double.parseDouble(this.fator);
		return String.format("%.2f", aplicaPromo(preco, fator));
	}
	
	@Override
	public double aplicaPromo(double preco, double fator) {
		return preco - (preco * fator);
	}

	private double getPreco(String produtos) {
		double preco = 0.0;
		for (String palavra : produtos.split(" ")) {
			if (palavra.contains("R$"))
				preco += Double.valueOf(palavra.substring(2, 6).replace(",", "."));
		}
		return preco;
	}

}
