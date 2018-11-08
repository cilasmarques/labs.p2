package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Util {

	private final static String FL = System.lineSeparator();
	private final static Scanner SC = new Scanner(System.in);

	/**
	 * Verifica se a String e valida de acordo com a especificacao
	 * 
	 * @param str
	 *            Infomacao do usuario
	 */
	public static void validaString(String str) {
		if (str == null || str.trim().isEmpty())
			throw new IllegalArgumentException("Informacao vazia ou nula!");
	}

	/**
	 * Verifica se a matricula informada e valida de acordo com a especificacao
	 * 
	 * @param mat
	 *            Informacao do usuario
	 */
	public static void validaMatricula(String mat) {
		
		if (mat == null || mat.trim().isEmpty())
			throw new IllegalArgumentException("Informacao vazia ou nula!");
		else if (Pattern.compile("[a-zA-Z]").matcher(mat).find())
			throw new IllegalArgumentException("Matricula nao pode conter letras!");
		else if (Integer.parseInt(mat) <= 0)
			throw new IllegalArgumentException("Matricula nao pode ser menor ou igual a zero!");
	}

	/**
	 * Pula a quantidade de linhas desejadas para formatacao do texto a ser
	 * exibido
	 * 
	 * @param qtdLinhas
	 *            Integer que indica a quantidade de linhas a ser puladas
	 * @return Quantidade de linhas a ser puladas
	 */
	public static String pulaLinha(int qtdLinhas) {
		String ln = "";
		for (int i = 0; i < qtdLinhas; i++) {
			ln += FL;
		}
		return ln;
	}

	/**
	 * Pula uma linha
	 * 
	 * @return Uma quebra de linha
	 */
	public static String pulaLinha() {
		return FL;
	}

	/**
	 * Imprime uma informacao e recebe um entrada do teclado
	 * 
	 * @param str
	 *            String como entrada
	 * @return String de entrada do teclado
	 */
	public static String input(String str) {
		validaString(str);
		System.out.print(str);
		return SC.nextLine();
	}

	/**
	 * Imprime na formatacao original
	 * 
	 * @param str
	 *            recebe uma String
	 */
	public static void print(String str) {
		System.out.print(str);
	}

	/**
	 * Imprime e depois pula a quantidade delinhas desejadas
	 * 
	 * @param str
	 *            String recebido
	 * @param pulaLinha
	 *            inteir que indica a quantidades de linha a ser pulasdas
	 */
	public static void print(String str, int pulaLinha) {
		System.out.print(str + pulaLinha(pulaLinha));
	}

}
