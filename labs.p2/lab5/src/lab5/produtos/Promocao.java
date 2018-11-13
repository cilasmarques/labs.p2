package lab5.produtos;

public interface Promocao {

	/**
	 * Metodo que prega o preco com a promocao
	 * @return
	 */
	String getPrecoComPromo();
	
	/**
	 * Metodo que aplica a promocap
	 * @param preco preco do produto
	 * @param fator fator de desconto
	 * @return
	 */
	double aplicaPromo(double preco, double fator);
}
