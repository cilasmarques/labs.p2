package r.c3.refatoramento;

public class ArmaConfiguracao {

	private String nomeRobo;
	private String arma;

	public ArmaConfiguracao(String nomeRobo, String arma) {
		this.nomeRobo = nomeRobo;
		this.arma = arma;
		if (arma == null) {
			this.arma = "TIRO";
		}
	}

	public String getNomeRobo() {
		return nomeRobo;
	}

	public String getArma() {
		return arma;
	}
	
}
