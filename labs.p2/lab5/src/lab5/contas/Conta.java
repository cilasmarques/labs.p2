package lab5.contas;

import java.util.ArrayList;

import lab5.produtos.Comida;

public class Conta {

	private ArrayList<String> compras = new ArrayList<>();
	private double debito;
	
	public String adicionaCompra(String data, Comida produto) {
		this.debito += produto.getPreco();
		this.compras.add(produto.getNome() + " - " + data.replace("/", "-"));
		return produto.getId();
	}
	
	public String getDebito() {
		return String.format("%.2f", this.debito).replace(",", ".");
	}	

	public String toString() {
		return sortedArrayToString(compras);
	}
	
	private String sortedArrayToString(ArrayList<String> arrayCompras) {
		String saida = "";
		for (int i = 0; i < arrayCompras.size(); i++) {
			saida += " | " + arrayCompras.get(i);
		}
		return saida;
	}
	
	public ArrayList<String> getProdutos() {
		return this.compras;
	}
	
}
