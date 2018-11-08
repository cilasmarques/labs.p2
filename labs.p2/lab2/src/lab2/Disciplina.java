package lab2;

/**
 * Classe Disciplina
 * 
 * @author Cilas Medeiros
 * 
 */

public class Disciplina {

	private double[] notas = new double[4];
	private double media;
	private int horas;
	private String nomeDisciplina;

	/**
	 * Construtor Disciplina
	 * 
	 * @param nomeDisciplina Nome da disciplina
	 * 
	 */

	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;

	}

	/*
	 * Cadastra a quantidade de horas trabalhadas
	 * 
	 * @param horas horas de estudo da disciplina
	 * 
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}

	/*
	 * Cadastras as notas
	 * 
	 * @param nota mostra qual a posição da nota (1º,2ª,3ª,4ª)
	 * 
	 * @param valorNota atribui um valor para a nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/*
	 * Mostra se está aprovado ou não na disciplina (media >= 7.0 está aprovado)
	 * 
	 * @return boolean indicando se a media é maior que 7.0 ou não
	 */
	public boolean aprovado() {
		calculaMedia();
		return this.media >= 7.0;
	}

	/*
	 * @return Retorna uma string contendo o nome da disciplina, as horas, a media e
	 * as notas
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + this.media + " " + arrayNotas(notas);
	}

	/*
	 * Método usado para calcular a média
	 */
	private void calculaMedia() {
		double soma = 0;
		for (double nota : this.notas) {
			soma += nota;
		}
		this.media = soma / notas.length;
	}

	/*
	 * Metodo que transforma o array de notas em string
	 * 
	 * @param notas recebe um array de notas
	 * 
	 * @return retorna uma string com as notas cadastradas
	 */
	private String arrayNotas(double[] notas) {
		String array = "[";
		for (int i = 0; i < (notas.length - 1); i++) {
			array += notas[i] + ", ";
		}
		array += notas[3] + "]";
		return array;
	}
}
