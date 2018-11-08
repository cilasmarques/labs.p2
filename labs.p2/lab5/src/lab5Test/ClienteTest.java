package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Cliente;

class ClienteTest {

	@Test
	void testHashCode() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		Cliente cliente2 = new Cliente("66666666612", "Cilas", "cilas@meuemail.com", "Terra");
		int h1 = cliente1.hashCode();
		int h2 = cliente2.hashCode();
		assertEquals(h1 != h2, true);
		assertEquals(h1 == h1, true);
	}
	
	@Test
	void testSetNome() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente1.setNome("Unliked");
		assertEquals(cliente1.toString(), "Unliked - Terra - cilas@meuemail.com");

	}

	@Test
	void testSetLocalizacao() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente1.setLocalizacao("Marte");
		assertEquals(cliente1.toString(), "Cilas - Marte - cilas@meuemail.com");
	}

	@Test
	void testSetEmail() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		cliente1.setEmail("unliked@meuemail.com");
		assertEquals(cliente1.toString(), "Cilas - Terra - unliked@meuemail.com");
	}

	@Test
	void testToString() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		assertEquals(cliente1.toString(), "Cilas - Terra - cilas@meuemail.com");
	}

	@Test
	void testEqualsObject() {
		Cliente cliente1 = new Cliente("66666666613", "Cilas", "cilas@meuemail.com", "Terra");
		Cliente cliente2 = new Cliente("66666666612", "Cilas", "cilas@meuemail.com", "Terra");
		Cliente cliente3 = new Cliente("66666666613", "Unliked", "Unliked@meuemail.com", "Terra");
		assertEquals(cliente1.equals(cliente2), false);
		assertEquals(cliente1.equals(cliente3), true);
	}

}
