package lab4;

import java.util.Scanner;

/**
 * Classe Gestor
 * 		responsavel porinteragir com Main, redirecionando comandos e
 * 		guardando métodos
 * 
 * @author cilas
 *
 */
public class Gestor {

	private Controler controle = new Controler();
	private Scanner sc = new Scanner(System.in);

	/**
	 * Imprime uma informacao e recebe um entrada do teclado
	 * 
	 * @param str String como entrada
	 * @return String de entrada do teclado
	 */
	public String lerComando(String str) {
		controle.verificaParametro(str);
		System.out.print(str);
		return sc.nextLine();
	}

	/**
	 * Método que mostra as opções do menu inicial
	 *@return retorna o menu inicial
	 */
	public String exibeMenu() {
		return "\n(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Resposta de Aluno\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n" + "\n";
	}

	/**
	 * Método que cadastra aluno a partir de uma entrada do usuario
	 * 
	 * @return retorna se o aluno foi cadastrado ou não
	 */
	public String cadastraAluno() {
		String mat = lerComando("Matricula: ");
		String nome = lerComando("Nome: ");
		String curso = lerComando("Curso: ");
		return controle.cadastraAluno(mat, nome, curso);
	}

	/**
	 * Método que exibe o aluno a partir de uma entrada do usuario
	 * 
	 * @return retorna a representação do aluno, caso exista, ou um aviso de auno
	 *         não cadastrado, caso não exista
	 */
	public String consultaAluno() {
		return controle.consultarAluno(lerComando("Matricula: "));
	}

	/**
	 * Método que cria um novo grupo a partir de uma entrada do usuario
	 * 
	 * @return retorna se o grupo foi ou não criado
	 */
	public String novoGrupo() {
		return controle.cadastraGrupo(lerComando("Grupo: "));
	}

	/**
	 * Método que lê a opção do usuário entre alocar Aluno eimprimir Grupo
	 * 
	 * @return opção "a", aloca um aluno num grupo
	 * @return opção "i", imprime os alunos de um grupo
	 * @return nenhuma das opções, retorna uma string com "opção inválida"
	 */
	public String alocarAluno() {
		String opcao = lerComando("(A)locar Aluno ou (I)mprimir Grupo? ").toLowerCase();

		if (opcao.equals("a"))
			return controle.alocarAluno(lerComando("Matricula: "), lerComando("Grupo: "));
		else if (opcao.equals("i"))
			return controle.imprimeGrupo(lerComando("Grupo: "));
		return "Opcao invalida!\n";
	}

	/**
	 * Método que registra a respota de uma aluno, a partir de uma entrada do
	 * usuario
	 * @return registro de uma resposta
	 */
	public String registraResposta() {
		return controle.registraResposta(lerComando("Matricula: "));
	}
	
	/**
	 * Método que imprime as respostas dos alunos
	 * @return retorna a impressão das respotas
	 */
	public String imprimirRespostas() {
		return controle.toStringRespostas();
	}

}
