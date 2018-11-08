package lab3;

/**
 * Menu responsável por atender os comandos do usuário
 * 
 * @author cilas
 *
 */
public class Menu {

	public static void main(String[] args) {

		String entrada = "";

		MenuInterativo interacao = new MenuInterativo();

		while (!entrada.toLowerCase().equals("s")) {
			interacao.menuInicial();
			entrada = interacao.lerComando();

			if (entrada.toLowerCase().equals("c")) {
				interacao.cadastraContato();
			} else if (entrada.toLowerCase().equals("l")) {
				interacao.listarContatos();
			} else if (entrada.toLowerCase().equals("e")) {
				int posicao = interacao.posicaoContato();
				System.out.println(interacao.exibeContato(posicao));
			} else {
				interacao.entradaInvalida(entrada);
			}
		}
	}
}