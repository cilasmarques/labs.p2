package lab5.produtos;

/**
 * Classe Produto
 * 
 * @author cilas
 *
 */
public class ProdutoSimples extends Comida {

	private String preco;

	public ProdutoSimples(String nomeProduto, String descricao, String preco) {
		super(nomeProduto, descricao);
		this.preco = preco;
	}

	/**
	 * Metodo que permite mudar o preco
	 * 
	 * @param preco novo preco do produto
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}

	/**
	 * Metodo que permite pegar o preco do produto simples
	 * 
	 * @return retorna o preco do produto simples
	 */
	public double getPreco() {
		return Double.parseDouble(this.preco);
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco.replace(".", ",");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		ProdutoSimples other = (ProdutoSimples) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
