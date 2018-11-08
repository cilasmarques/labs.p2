package lab3;

import java.util.Scanner;

/**
 * Menu responsável por fazer interações simples com o usuário
 * 
 * @author cilas
 *
 */
public class MenuInterativo {

	Scanner sc = new Scanner(System.in);
	Agenda agenda = new Agenda();
	
	/**
	 * Contrutor do Menu Interativo
	 */
	public MenuInterativo() {

	}

	/**
	 * Método que mostra as opções do menu inicial
	 */
	public void menuInicial() {
		System.out.print(   "\n" + 
							"(C)adastrar Contato\n" + 
							"(L)istar Contatos\n" + 
							"(E)xibir Contato\n" + 
							"(S)air\n" + "\n" + 
							"Opção> ");
	}

	/**
	 * Cadastra o Contato
	 */
	public void cadastraContato() {
		int posicao = lerPosicao();
		String nome = lerNome();
		String sobrenome = lerSobrenome();
		String telefone = lerTelefone();
		agenda.cadastraContato(nome, sobrenome, telefone, posicao);
	}
	
	/**
	 * Método que lê o comando do usuário
	 * 
	 * @return retorna o comando lido
	 */
	public String lerComando() {
		return sc.nextLine();
	}

	/**
	 * Método que lê uma posição inserida pela usuário
	 * 
	 * @return Retorna a posição do contato
	 */
	public int lerPosicao() {
		System.out.print("\n" + "Posição: ");
		int posicao = sc.nextInt();
		sc.nextLine();
		return posicao;
	}

	/**
	 * Método que lê o nome, inserida pela usuário, do contato
	 * 
	 * @return Retorna o nome do contato
	 */
	public String lerNome() {
		System.out.print("Nome: ");
		return sc.nextLine();
	}

	/**
	 * Método que lê o sobrenome, inserida pela usuário, do contato
	 * 
	 * @return Retorna o sobrenome do contato
	 */
	public String lerSobrenome() {
		System.out.print("Sobrenome: ");
		return sc.nextLine();
	}

	/**
	 * Método que lê o telefone, inserida pela usuário, do contato
	 * 
	 * @return Retorna o telefone do contato
	 */
	public String lerTelefone() {
		System.out.print("Telefone: ");
		return sc.nextLine();
	}

	/**
	 * Método indica se o cadastro do contato na agenda realizado
	 * 
	 */
	public void cadastroConcluido() {
		System.out.println("\n" + "CADASTRO REALIZADO!");
	}

	/**
	 * Método que alerta que a posição escolhida é inválida
	 */
	public void posicaoInvalida() {
		System.out.println("\n" + "POSIÇÃO INVÁLIDA!");
	}

	/**
	 * Método que alerta que a opção escolhida é inválida
	 * 
	 * @param entrada comando passado pela usuário no menu
	 */
	public void entradaInvalida(String entrada) {
		if (!entrada.toLowerCase().equals("s")) {
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Método que lê a posição, inserida pela usuário, do contato na agenda
	 * 
	 * @return Retorna a posição do contato
	 */
	public int posicaoContato() {
		System.out.print("Contato> ");
		int contatoPosicao = sc.nextInt();
		sc.nextLine();
		return contatoPosicao;
	}

	public String exibeContato(int posicao) {
		return agenda.exibeContato(posicao);
	}

	public void listarContatos() {
		agenda.listarContatos();
	}

}
