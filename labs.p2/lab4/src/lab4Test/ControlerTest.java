package lab4Test;

import static org.junit.Assert.*;

import org.junit.Test;

import lab4.Controler;

public class ControlerTest {

	@Test
	public void testCadastraAluno() {
		Controler controle = new Controler();
		String cadastroAluno1 = controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		String cadastroAluno2 = controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		assertEquals(cadastroAluno1, "\nCADASTRO REALIZADO!");
		assertEquals(cadastroAluno2, "\nMATRICULA JA CADASTRADA!");
	}

	@Test
	public void testContemAluno() {
		Controler controle = new Controler();
		controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		assertEquals(controle.consultarAluno("000000000"), "\nAluno não cadastrado.");
		assertEquals(controle.consultarAluno("118110386"),
				"\nAluno: 118110386 - Cilas Marques - Ciencia da computação");
	}

	@Test
	public void testNovoGrupo() {
		Controler controle = new Controler();
		String cadastroGrupo1 = controle.cadastraGrupo("teste");
		String cadastroGrupo2 = controle.cadastraGrupo("teste");
		assertEquals(cadastroGrupo1, "\nCADASTRO REALIZADO!");
		assertEquals(cadastroGrupo2, "\nGRUPO JÁ CADASTRADO!");
	}

	@Test
	public void testAlocarAluno() {
		Controler controle = new Controler();
		controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		controle.cadastraGrupo("teste");
		assertEquals(controle.alocarAluno("118110386", "teste"), "\nALUNO ALOCADO!");
		assertEquals(controle.alocarAluno("000000000", "teste"), "\nAluno não cadastrado.");
		assertEquals(controle.alocarAluno("118110386", "nao existe"), "\nGrupo não cadastrado.");
		assertEquals(controle.alocarAluno("000000000", "nao existe"), "\nAluno não cadastrado.");

	}

	@Test
	public void testImprimeGrupo() {
		Controler controle = new Controler();
		controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		controle.cadastraAluno("118110666", "Exu Caveirinha", "Infernologia");
		controle.cadastraGrupo("teste");
		controle.alocarAluno("118110386", "teste");
		controle.alocarAluno("118110666", "teste");
		controle.imprimeGrupo("teste");
		assertEquals(controle.getGrupos().size(), 1);
		controle.imprimeGrupo("naoExiste");
		assertEquals(controle.getGrupos().size(), 1);
	}

	@Test
	public void testResistraResposta() {
		Controler controle = new Controler();
		controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		assertEquals(controle.registraResposta("118110386"), "\nRESPOSTA REGISTRADA!");
		assertEquals(controle.registraResposta("000000000"), "\nAluno não cadastrado.");
	}

	@Test
	public void testToStringRespostas() {
		Controler controle = new Controler();
		controle.cadastraAluno("118110386", "Cilas Marques", "Ciencia da computação");
		assertEquals(controle.toStringRespostas(), "Alunos:\n");
		controle.registraResposta("118110386");
		assertEquals(controle.toStringRespostas().equals("Alunos:\n"), false);
	}

	@Test
	public void testVerificaParametroVazio() {
		Controler controle = new Controler();
		try {
			controle.verificaParametro("");
		} catch (IllegalArgumentException npe) {
		}
	}

	@Test
	public void testVerificaParametroNulo() {
		Controler controle = new Controler();
		try {
			controle.verificaParametro(null);
		} catch (NullPointerException npe) {
		}
	}
}
