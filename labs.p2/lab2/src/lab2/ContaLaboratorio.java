package lab2;

/**
 * Classe Conta Laboratório
 * 
 * @author Cilas Medeiros
 * 
 */

public class ContaLaboratorio {

	private String nome;
	private int espacoDisponivel;
	private int cota;

	/**
	 * Construtor Conta Labolatório
	 * 
	 * @param nomeLabolatorio Nome do labolatório
	 * @param cota            maximo de espaco disponivel
	 * 
	 */

	public ContaLaboratorio(String nomeLaboratorio) {
		this.nome = nomeLaboratorio;
		this.cota = 2000;
	}

	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nome = nomeLaboratorio;
		this.cota = cota;
	}

	/*
	 * Metodo que atualiza espaço total, consumindo espaço
	 * 
	 * @param mbytes representa a quantidade de MB consumidos
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoDisponivel += mbytes;
	}

	/*
	 * Metodo que atualiza o espaço total, liberando espaço
	 * 
	 * @param mbytes representa a quantidade de MB liberados
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoDisponivel -= mbytes;
	}

	/*
	 * Metodo que apresenta se a cota (limite de espaço) foi atingida
	 * 
	 * @return Retorna um booleando que presenta se a cota foi atingida (True) ou
	 * não (False)
	 */
	public boolean atingiuCota() {
		return this.espacoDisponivel >= this.cota;

	}
	
	/*
	 * @return Retorna uma string contendo o nome da conta do labolatorio, o espaço
	 * disponivel e a cota(limite de espaço)
	 */
	public String toString() {
		return this.nome + " " + this.espacoDisponivel + "/" + this.cota;
	}

}