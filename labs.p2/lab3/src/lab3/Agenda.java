package lab3;

import java.util.Arrays;

/**
 * Responsável por armazenar o array de contatos e manipular o array de
 * contatos.
 * 
 * @author cilas
 *
 */

public class Agenda {

	private Contato[] listaContato = new Contato[100];

	/**
	 * Contrutor de agenda
	 */
	public Agenda() {

	}

	/**
	 * 
	 * Cria o contato e insere-o na agenda
	 *
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @param posicao posicao do contato na agenda
	 * 
	 * @return boolean (true/false) indica se o cadastro foi bem sucedido ou nao
	 */
	public boolean cadastraContato(String nome, String sobrenome, String telefone, int posicao) {
		if ((0 < posicao) && (posicao <= 100)) {
			Contato contato = new Contato(nome, sobrenome, telefone);
			this.listaContato[posicao - 1] = contato;
			System.out.println("\n" + "CADASTRO REALIZADO!");
			return true;
		} else {
			System.out.println("\n" + "POSIÇÃO INVÁLIDA!");
			return false;
		}
	}

	/**
	 * Metodo que mostra o contato
	 * 
	 * @param posicao posição do contato na agenda
	 * @return retorna as caracteristicas de um contato especifico de uma posição
	 *         (Retorna "posição invalida" caso nao tenha na posição passada na
	 *         agenda)
	 */
	public String exibeContato(int posicao) {
		if (!(listaContato[posicao - 1] == null)) {
			return listaContato[posicao - 1].toString();
		} else {
			return "POSIÇÃO INVÁLIDA!";
		}
	}

	/**
	 * Mostra toda a lista com os contatos
	 */
	public void listarContatos() {
		int i = 0;
		while (i < 100) {
			if (!(listaContato[i] == null))
				System.out.println((i + 1) + " - " + listaContato[i].getNome() + " " + listaContato[i].getSobrenome());
			i += 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(listaContato, other.listaContato))
			return false;
		return true;
	}

	public Contato[] getLista() {
		return this.listaContato;
	}

}
