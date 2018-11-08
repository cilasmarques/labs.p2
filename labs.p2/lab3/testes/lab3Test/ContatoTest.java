package lab3Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import lab3.Agenda;
import lab3.Contato;

class ContatoTest {
	
	Agenda agenda;
	Contato contato1;
	
	@Before 
	void inicializaTeste() {
		agenda = new Agenda(); 
		contato1 =  new Contato("Matheus","gaudencio", "2930232");
	}
	
	@Test
	void testCadastro() {
	 	Assert.assertEquals(agenda.cadastraContato("Matheus","gaudencio", "2930232",1), true);
	 	Assert.assertEquals(contato1.equals(agenda.getLista()[0]), true);
	
	}
	
	@Test
	void testCadastrofalha() {
	 	Assert.assertEquals(agenda.cadastraContato("Matheus","gaudencio", "2930232", 9999999), true);
	 	Contato contato =  new Contato("Matheus","gaudencio", "2930232");
	 	Assert.assertEquals(contato.equals(agenda.getLista()[0]), true);
	}

	@Test
	void testCadastroSemSobrenome() {
	 	Assert.assertEquals(agenda.cadastraContato("Matheus", "", "2930232", 99), true);
	}

	
}

