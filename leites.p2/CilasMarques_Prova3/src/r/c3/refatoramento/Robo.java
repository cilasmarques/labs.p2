package r.c3.refatoramento;

public class Robo extends RoboPai implements RoboIf {

	private String tipoDeArma;
	private int[] municoes;
	
	public Robo(int energia, String apelido) {
		super(energia, apelido);
		this.municoes = new int[] {100, 10, 30};
	}

	public void armar(String string) {
		this.tipoDeArma = string;
	}
	
	public String atirar() {
		if (this.energia == 0) {
			return "...";
		}
		this.energia -= 1;
		return atirarDeVerdade();
	}

	private String atirarDeVerdade() {
		boolean armaEhTipoTiro = ehTipoTiro();
		if (armaEhTipoTiro) {
			if (this.municoes[0] == 0) {
				return "";
			} else {
				this.municoes[0] -= 1;
				return "PEW PEW PEW";
			}
		} else if ("BAZOOKA".equals(this.tipoDeArma)) {
			if (this.municoes[1] == 0) {
				return "";
			} else {
				this.municoes[1] -= 1;
				return "BOOOM";
			}
		} else if ("SNIPER".equals(this.tipoDeArma)) {
			if (this.municoes[2] == 0) {
				return "";
			} else {
				this.municoes[2] -= 1;
				return "PPPPPFFT";
			}
		}
		throw new IllegalArgumentException("Arma invalida");
	}

	private boolean ehTipoTiro() {
		boolean armaEhTipoTiro = this.tipoDeArma == null || "TIRO".equals(this.tipoDeArma);
		return armaEhTipoTiro;
	}
	
}
