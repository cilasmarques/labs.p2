package cilas_medeiros_prova1;

import java.time.LocalTime;

public class Vaga {
	
	private LocalTime inicio;
	
	private String setor;
	private int posicao;
	private String placaCarro;
	private boolean status;
	
	public Vaga(String setor, int posicao) {
		this.setor = setor;
		this.posicao = posicao;
		vagaLiberada();
	}
	
	public void vagaOcupada(int horaEntrada, String placa) {
		inicio = LocalTime.now();
		setStatus(false);
		this.placaCarro = placa;
	}
	
	public void vagaLiberada() {
		this.placaCarro = "";
		setStatus(true);
	}
	
	public String getInfo() {
		if (getStatus())
			return "\n" + this.setor + "-" + this.posicao + " Vaga livre";
		return "\n" + this.setor + "-" + this.posicao + " Vaga ocupada";
	}
	
	//false para ocupada e true para liberada
	public boolean getStatus(){
		return this.status;
	}
	
	//false para ocupada e true para liberada
	public boolean setStatus(boolean newStatus) {
		this.placaCarro = "";
		return this.status = newStatus;
	}

	public int getHoras() {
		return inicio.getHour();
	}
	
	public String getPlacaCarro() {
		return this.placaCarro;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (posicao != other.posicao)
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}

	public String toString() {
		return "\n" + this.setor + "-" + this.posicao + " " + this.placaCarro;
	}

	public String getLocalizacao() {
		return "\n" + this.setor + this.posicao;
	}
	
}
