package lab5.produtos;

public interface Promocao {

	String getPrecoComPromo();
	
	double aplicaPromo(double preco, double fator);
}
