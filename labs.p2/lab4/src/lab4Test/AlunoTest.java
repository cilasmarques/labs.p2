package lab4Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab4.Aluno;

class AlunoTest {

	@Test
	public void testAluno() {
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		Aluno aluno2 = new Aluno("118110666", "Exu Caveirinha", "Infernologia");
		assertEquals(aluno1.equals(aluno2), false);
	}

	@Test
	public void testGetCurso() {
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		assertEquals(aluno1.getCurso(), "Ciencia da computação");
	}

	@Test
	public void testGetNome() {
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		assertEquals(aluno1.getNome(), "Cilas");
	}

	@Test
	public void testGetMatricula() {
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		assertEquals(aluno1.getMatricula(), "118110386");
	}

	@Test
	public void testToString() {
		Aluno aluno1 = new Aluno("118110386", "Cilas", "Ciencia da computação");
		assertEquals(aluno1.toString(), "118110386 - Cilas - Ciencia da computação");
	}

	@Test
	public void testEqualsObject() {
		Aluno aluno1 = new Aluno("118110386", "Cilas Medeiros", "Ciencia da computação");
		Aluno aluno2 = new Aluno("118110666", "Exu Caveirinha", "Infernologia");
		Aluno aluno3 = new Aluno("118110386", "Cilas Marques", "Ciencia da computação");
		assertEquals(aluno1.equals(aluno2), false);
		assertEquals(aluno1.equals(aluno3), true);
	}

	@Test
	public void testHashCode() {
		Aluno aluno1 = new Aluno("118110386", "Cilas Medeiros", "Ciencia da computação");
		Aluno aluno2 = new Aluno("118110666", "Exu Caveirinha", "Infernologia");
		int h1 = aluno1.hashCode();
		int h2 = aluno2.hashCode();
		assertEquals(h1 != h2, true);
		assertEquals(h1 == h1, true);
	}
}
