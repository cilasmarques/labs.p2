package lab5.contas;

import java.util.ArrayList;

public class Conta {

	private ArrayList<String> compras = new ArrayList<>();
	
	public String adicionaCompra(String data, String nomeProd, String descrProd) {
		String id = nomeProd + " " + data;
		this.compras.add(id);
		return id;
	}
	
	public String getDebito() {
		return "ok";
	}	
	
}
