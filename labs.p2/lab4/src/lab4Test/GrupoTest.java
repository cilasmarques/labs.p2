package lab4Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import lab4.Aluno;
import lab4.Grupo;

public class GrupoTest {

	@Test
	public void testAddAluno() {
		Grupo grupo = new Grupo("teste");
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		grupo.addAluno(aluno1);
		assertEquals(grupo.getListaAlunos().size(), 1);
	}

	@Test
	public void testToString() {
		Grupo grupo = new Grupo("teste");
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		grupo.addAluno(aluno1);
		String saida = "\nAlunos do grupo teste:\n" + "* 118110386 - Cilas - Ciencia da computação";
		assertEquals(grupo.toString(), saida);
	}

	@Test
	public void testGetNome() {
		Grupo grupo = new Grupo("teste");
		assertEquals(grupo.getNome(), "teste");
	}

	@Test
	public void testHashCode() {
		Grupo grupo1 = new Grupo("teste");
		Grupo grupo2 = new Grupo("teste2");
		int h1 = grupo1.hashCode();
		int h2 = grupo2.hashCode();
		assertEquals(h1 != h2, true);
		assertEquals(h1 == h1, true);
	}

	@Test
	public void testEqualsObject() {
		Grupo grupo1 = new Grupo("teste");
		Grupo grupo2 = new Grupo("teste2");
		assertEquals(grupo1.equals(grupo1), true);
		assertEquals(grupo1.equals(grupo2), false);
	}

}
