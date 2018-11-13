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
	 * Metodo que permite pegar o nome da comida
	 * @return Retorna o nome do produto
	 */
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public int compareTo(Comida o) {
		return this.nome.compareTo(o.nome);
	}
	
}
