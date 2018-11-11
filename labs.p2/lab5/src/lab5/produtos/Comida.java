package lab5.produtos;

public abstract class Comida implements Produto, Comparable<Comida>{
	
	protected String nome;
	protected String descricao;

	public Comida(String nomeProduto, String descricao) {
		this.nome = nomeProduto;
		this.descricao = descricao;
	}

	/**
	 * Metodo que retorna o ID do produto
	 * 
	 * @return String com ID
	 */
	public String getId() {
		return this.nome + " - " + this.descricao;
	}
	
	/**
	 * Metodo que permite mudar a descricao
	 * 
	 * @param descricao do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int compareTo(Comida o) {
		return this.nome.compareTo(o.nome);
	}
	
}
