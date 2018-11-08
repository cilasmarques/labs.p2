package lab2;

/**
 * Classe Saude
 * 
 * @author Cilas Medeiros
 * 
 */

public class Saude {

	private String saudemental;
	private String saudefisica;

	/**
	 * Construtor Saude Define a saude mental e fisica
	 * 
	 */

	public Saude() {
		this.saudemental = "boa";
		this.saudefisica = "boa";
	}

	/**
	 * Define Saude Mental Define/altera a saude mental
	 * 
	 * @param valor Atualiza a saude mental
	 */
	public void defineSaudeMental(String valor) {
		this.saudemental = valor;
	}

	/**
	 * Define Saude Fisica Define/altera a saude fisica
	 * 
	 * @param valor Atualiza a saude fisica
	 */
	public void defineSaudeFisica(String valor) {
		this.saudefisica = valor;
	}

	/**
	 * Status Geral Mostra como está a saude geral
	 * 
	 * @return Retorna uma string representando a saude geral (boa,ok,fraca)
	 */
	public String getStatusGeral() {
		if (this.saudemental.equals("boa") && this.saudefisica.equals("boa")) {
			return "boa";
		} else if (this.saudemental.equals("boa") && this.saudefisica.equals("fraca")) {
			return "ok";
		} else if (this.saudemental.equals("fraca") && this.saudefisica.equals("boa")) {
			return "ok";
		} else {
			return "fraca";
		}
	}
}
