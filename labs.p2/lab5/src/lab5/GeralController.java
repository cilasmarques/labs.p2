package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cilas
 *
 */
public class GeralController {

	public ArrayList<?> makeArray(Map<?, ?> map) {
		ArrayList<Object> arrayDeInfos = new ArrayList<>();
		for (Object key : map.keySet()) {
			arrayDeInfos.add(map.get(key));
		}
		return arrayDeInfos;
	}
	
	public ArrayList<String> arrayInfosToString(ArrayList<?> array) {
		ArrayList<String> arrayDeInfos = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			arrayDeInfos.add(array.get(i).toString());
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que coloca as informações de um array em uma unica string
	 * 
	 * @param array array a ser convertido
	 * @return String com as informações do array
	 */
	public String arrayToString(List<String> array) {
		String saida = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			saida += " | "+ array.get(i);
		}
		return saida;
	}

	/**
	 * Metodo que verifica se um parametro eh nulo ou nao
	 * 
	 * @param parametro parametro a ser analisado
	 * @param saida     mensagem retornada caso o parametro seja invalido
	 */
	public void verificadorParametro(String parametro, String saida) {
		if (parametro == null || parametro.trim().equals(""))
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se uma chave existe em um determinado mapa
	 * 
	 * @param key   chave a ser analisada
	 * @param saida mensagem retornada caso a chave exista
	 * @param mapa  mapa a ser analisado se contem a chave
	 */
	public void verificadorExiste(String key, String saida, Map<?, ?> mapa) {
		if (mapa.containsKey(key))
			throw new Error(saida);
	}

	/**
	 * Metodo que verifica se uma chave nao existe em um determinado mapa
	 * 
	 * @param key   chave a ser analisada
	 * @param saida mensagem retornada caso a nao chave exista
	 * @param mapa  mapa a ser analisado se contem a chave
	 */
	public void verificadorNaoExiste(String key, String saida, Map<?, ?> mapa) {
		if (!mapa.containsKey(key))
			throw new Error(saida);
	}
}
