package aluno;

import util.Util;

public class Aluno {

	private String matricula, nome, curso;

	public Aluno(String matricula, String nome, String curso) {
		Util.validaMatricula(matricula);
		Util.validaString(nome);
		Util.validaString(curso);

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s", getMatricula(), getNome(), getCurso());
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}

}
