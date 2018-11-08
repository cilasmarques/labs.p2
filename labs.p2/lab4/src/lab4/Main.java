package lab4;

/**
 * Menu responsável por atender os comandos do usuário
 * 
 * @author cilas
 *
 */
public class Main {

	public static void main(String[] args) {

		Gestor interacao = new Gestor();
		String entrada = "";

		while (!entrada.toUpperCase().equals("O")) {
			String menu = interacao.exibeMenu();
			entrada = interacao.lerComando(menu).toUpperCase();

			switch (entrada) {
			case "C":
				System.out.println(interacao.cadastraAluno());
				break;
			case "E":
				System.out.println(interacao.consultaAluno());
				break;
			case "N":
				System.out.println(interacao.novoGrupo());
				break;
			case "A":
				System.out.println(interacao.alocarAluno());
				break;
			case "R":
				System.out.println(interacao.registraResposta());
				break;
			case "I":
				System.out.println(interacao.imprimirRespostas());
				break;
			case "O":
				System.out.println("Até mais =D");
				break;
			default:
				System.out.println("Opcao invalida!\n");
				break;
			}
		}
	}
}
