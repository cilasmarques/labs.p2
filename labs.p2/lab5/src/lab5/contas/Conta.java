package lab5.contas;

import java.util.ArrayList;

import lab5.produtos.Comida;

/**
 * 
 * @author cilas
 *
 */
public class Conta {

	private ArrayList<String> compras = new ArrayList<>();
	private double debito;

	/**
	 * Metodo que adiciona uma compra
	 * 
	 * @param data    data da compra
	 * @param produto produto comprado
	 * @return id do produto comprado
	 */
	public String adicionaCompra(String data, Comida produto) {
		this.debito += produto.getPreco();
		this.compras.add(produto.getNome() + " - " + data.replace("/", "-"));
		return produto.getId();
	}

	/**
	 * Metodo que permite pegar o debito
	 * 
	 * @return Retorna o debito
	 */
	public String getDebito() {
		return String.format("%.2f", this.debito).replace(",", ".");
	}

	/**
	 * Meotod que permite pegar os produtos
	 * 
	 * @return Retorna o array de compras com os produtos
	 */
	public ArrayList<String> getProdutos() {
		return this.compras;
	}

	/**
	 * Metodo que permite realizar o pagamento, zerando todas as dividas
	 */
	public void realizaPagamento() {
		this.compras = new ArrayList<>();
		this.debito = 0;
	}

	@Override
	public String toString() {
		return sortedArrayToString(compras);
	}

	/**
	 * Metodo que transforma o Array no toString
	 * 
	 * @param arrayCompras
	 * @return
	 */
	private String sortedArrayToString(ArrayList<String> arrayCompras) {
		String saida = "";
		for (int i = 0; i < arrayCompras.size(); i++) {
			saida += " | " + arrayCompras.get(i);
		}
		return saida;
	}

}
