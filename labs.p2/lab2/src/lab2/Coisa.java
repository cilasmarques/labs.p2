package lab2;

/**
 * Classe Coisa
 * 
 * @author Matheus Gaudêncio
 * 
 */

public class Coisa {
	public static void main(String[] args) {

		ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");

		contaLCC2.consomeEspaco(1999);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.consomeEspaco(2);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.liberaEspaco(1);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.liberaEspaco(1);

		System.out.println(contaLCC2.atingiuCota());

		System.out.println(contaLCC2.toString());

		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");

		prog2.cadastraHoras(4);

		prog2.cadastraNota(1, 5.0);

		prog2.cadastraNota(2, 6.0);

		prog2.cadastraNota(3, 7.0);

		System.out.println(prog2.aprovado());

		prog2.cadastraNota(4, 10.0);

		System.out.println(prog2.aprovado());

		System.out.println(prog2.toString());

		ContaCantina cantinaSeuMatias = new ContaCantina("Seu Matias");

		cantinaSeuMatias.cadastraLanche(2, 500);

		cantinaSeuMatias.cadastraLanche(1, 500);

		cantinaSeuMatias.pagaConta(200);

		System.out.println(cantinaSeuMatias.getFaltaPagar());

		System.out.println(cantinaSeuMatias.toString());

		Saude saude = new Saude();

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("boa");

		saude.defineSaudeFisica("boa");

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("fraca");

		saude.defineSaudeFisica("fraca");

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("boa");

		saude.defineSaudeFisica("fraca");

		System.out.println(saude.getStatusGeral());

	}

}
