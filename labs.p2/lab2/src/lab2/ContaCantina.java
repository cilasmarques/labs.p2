package lab2;

/**
 * Classe Conta Cantina
 * 
 * @author Cilas Medeiros
 * 
 */
public class ContaCantina {

	private String nome;
	private int valorCentavos;
	private int quantLanche;
	private int cadastroLanche;

	/**
	 * Construtor Conta Cantina
	 * 
	 * @param nomeDaCantina Nome da cantina
	 * 
	 */

	public ContaCantina(String nomeDaCantina) {
		this.nome = nomeDaCantina;
	}

	/*
	 * Metodo que cadastra os lanches
	 * 
	 * @param qtdItens Representa o numero de unidades adquiridas
	 * 
	 * @param valorCentavos Representa o dinheiro total pago em centavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.cadastroLanche += valorCentavos;
		this.quantLanche += qtdItens;
		this.valorCentavos += valorCentavos;
	}

	/*
	 * Metodo que paga(diminui) um valor da conta
	 * 
	 * @param valorCentavos Representa o dinheiro total pago em centavos
	 * 
	 */
	public void pagaConta(int valorCentavos) {
		this.valorCentavos -= valorCentavos;
	}

	/*
	 * Metodo que apresenta o quanto da conta ainda falta ser pago
	 * 
	 * @return int que representa o valor em centavos que falta ser pago
	 */
	public int getFaltaPagar() {
		return valorCentavos;
	}

	/*
	 * @return Retorna uma string contendo o nome da conta na cantina, a quantidade
	 * de unidades de lanche adquiridas e o valor em centavos total de lanche
	 * cadastrado
	 */
	public String toString() {
		return nome + " " + quantLanche + " " + cadastroLanche;
	}
}
