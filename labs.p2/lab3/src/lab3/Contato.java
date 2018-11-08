package lab3;

/**
 * Responsável por representar um contato
 * 
 * @author cilas
 *
 */

public class Contato {

	private String nome;
	private String sobrenome;
	private String telefone;

	/**
	 * Construtor de Contato
	 * 
	 * @param nome      nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone  telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Mostra o nome do contato
	 * 
	 * @return retorna o nome do contato
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Mostra o sobrenome do contato
	 * 
	 * @return retorna o sobrenome do contato
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}

	/**
	 * @return Retorna o nome, sobrenome e telefone do contato
	 */
	public String toString() {
		return "\n" + this.nome + " " + this.sobrenome + " - " + this.telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
