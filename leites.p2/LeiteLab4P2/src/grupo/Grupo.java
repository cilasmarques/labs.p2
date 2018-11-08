package grupo;

import java.util.HashMap;
import java.util.Map;

import aluno.Aluno;
import util.Util;

public class Grupo {

	private String tema;
	private Map<String, Aluno> alunos;

	public Grupo(String tema) {
		this.tema = tema;
		this.alunos = new HashMap<>();
	}

	public String addAluno(Aluno aluno) {
		this.alunos.put(aluno.getMatricula(), aluno);
		return "ALUNO ALOCADO!";
	}

	public Aluno removeAluno(String mat) {
		return this.alunos.remove(mat);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		Grupo other = (Grupo) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String grupo = "Grupo: " + getTema() + Util.pulaLinha(2)
				+ String.format("Alunos do grupo %s:", getTema() + Util.pulaLinha());
		for (Aluno aluno : this.alunos.values()) {
			grupo += "* " + aluno.toString() + Util.pulaLinha();
		}
		return grupo.trim();
	}

	public String getTema() {
		return tema;
	}

}
