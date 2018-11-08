package lab4;

/**
 * Classe Aluno
 * 
 * @author cilas
 *
 */
public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Construtor de aluno
	 * 
	 * @param matricula matricula do aluno
	 * @param nome      nome do aluno
	 * @param curso     curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Mostra o curso do aluno
	 * 
	 * @return retorna curso so aluno
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Mostra o nome do aluno
	 * 
	 * @return retorna nome do aluno
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Mostra a matricula do aluno
	 * 
	 * @return retorna a matricula do aluno
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Método que mostra uma representação textual da classe
	 * 
	 * @return retorna uma frase com a matricula,nome e curso de um aluno
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * HashCode de aluno
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método equal de Aluno, leva em consideração apenas a matricula dos alunos
	 */
	@Override
	public boolean equals(Object obj) {
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}