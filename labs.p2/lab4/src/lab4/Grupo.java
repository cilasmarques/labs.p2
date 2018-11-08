package lab4;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Grupo
 * 
 * @author cilas
 *
 */
public class Grupo {

	private String nome;
	private Map<String, Aluno> listaAlunos;

	/**
	 * Construtor do grupo
	 * 
	 * @param nomeGrupo Nome do grupo
	 */
	public Grupo(String nomeGrupo) {
		this.nome = nomeGrupo;
		this.listaAlunos = new HashMap<>();
	}

	/**
	 * Método que adiciona um aluno no grupo
	 * 
	 * @param aluno Aluno que vai ser adicionado
	 * @return retorna uma string dizendo se o aluno foi alocado
	 */
	public String addAluno(Aluno aluno) {
		this.listaAlunos.put(aluno.getMatricula(), aluno);
		return "\nALUNO ALOCADO!";
	}

	/**
	 * Método que retorna o nome do grupo (metodo usado nos testes)
	 * 
	 * @return nome do grupo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que retorna a lista de alunos do grupo
	 * 
	 * @return lista de alunos
	 */
	public Map<String, Aluno> getListaAlunos() {
		return this.listaAlunos;
	}

	/**
	 * Método que mostra uma representação textual da classe
	 * 
	 * @return retorna uma String com os alunos que compõem o grupo
	 */
	public String toString() {
		String grupo = "\nAlunos do grupo " + this.nome + ":";
		for (Aluno aluno : this.listaAlunos.values()) {
			grupo += "\n* " + aluno.toString();
		}
		return grupo;
	}

	/**
	 * Hashcode de grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Equals de grupo, comparando os grupos pelo nome e integrantes
	 */
	@Override
	public boolean equals(Object obj) {
		Grupo other = (Grupo) obj;
		if (listaAlunos == null) {
			if (other.listaAlunos != null)
				return false;
		} else if (!listaAlunos.equals(other.listaAlunos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
