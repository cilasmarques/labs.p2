package r.c3.refatoramento;

public class RoboPai {

	protected int energia;
	protected String apelido;

	public RoboPai(int energia, String apelido) {
		this.energia = energia;
		this.apelido = apelido;
	}

	@Override
	public String toString() {
		return this.apelido + " : " + this.energia;
	}

}