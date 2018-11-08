package main;

import controler.Controler;
import util.Util;

public class Menu {

	private Controler controle;

	public Menu() {
		this.controle = new Controler();
	}

	private final String opcaoMenu = "(C)adastrar Aluno" + Util.pulaLinha()
									+ "(E)xibir Aluno" + Util.pulaLinha()
									+ "(N)ovo Grupo" + Util.pulaLinha()
									+ "(A)locar Aluno no Grupo e Imprimir Grupos" + Util.pulaLinha()
									+ "(R)egistrar Resposta de Aluno" + Util.pulaLinha()
									+ "(I)mprimir Alunos que Responderam" + Util.pulaLinha()
									+ "(O)ra, vamos fechar o programa!" + Util.pulaLinha(2)
									+ "Opção>";

	private void menu() {
		String opcao = "";
		do {
			opcao = Util.input(opcaoMenu).toLowerCase();

			String imprimir = "Programa fechado!";
//			try{
			switch (opcao) {
			case "c":
				imprimir = cadastro();
				break;
			case "e":
				imprimir = consultaAluno();
				break;
			case "n":
				imprimir = novoGrupo();
				break;
			case "a":
				imprimir = alocarAluno();
				break;
			case "r":
				imprimir = resistraResposta();
				break;
			case "i":
				imprimir = alunosResponderam();
				break;
			case "o":
				//Opcao que finaliza o programa
				break;
			default:
				imprimir = "Opcao invalida!";
				break;
			}
//			}catch (IllegalArgumentException e){
//				imprimir = e.getMessage() + Util.pulaLinha(2);
//			}
			
			Util.print(imprimir + Util.pulaLinha(2));
		
		} while (!opcao.equals("o"));
	}

	private String cadastro() {
		String mat = Util.input("Matricula: ");
		String nome = Util.input("Nome: ");
		String curso = Util.input("Curso: ");

		return controle.cadastraAluno(mat, nome, curso);
	}

	private String consultaAluno() {
		return controle.contemAluno(Util.input("Matricula: "));
	}

	private String novoGrupo() {
		return controle.novoGrupo(Util.input("Grupo: "));
	}

	private String alocarAluno() {
		String opcao = Util.input("(A)locar Aluno ou (I)mprimir Grupo? ").toLowerCase();
		String saida = "Opcao invalida!" + Util.pulaLinha(2);
		
		if (opcao.equals("a"))
			saida = controle.alocarAluno(Util.input("Matricula: "), Util.input("Grupo: "));
		else if (opcao.equals("i"))
			saida = controle.imprimirGrupo(Util.input("Grupo: "));
		return saida;
	}

	private String resistraResposta() {
		return controle.resistraResposta(Util.input("Matricula: "));
	}

	private String alunosResponderam() {
		return controle.toStringAlunosQueResponderam();
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menu();
	}
}
