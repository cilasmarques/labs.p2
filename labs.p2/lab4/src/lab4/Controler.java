package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe controle
 * 
 * @author cilas
 *
 */
public class Controler {

	private List<Aluno> respostas;
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;

	/**
	 * Construtor de controle
	 */
	public Controler() {
		this.respostas = new ArrayList<>();
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
	}

	/**
	 * Método que cadastra um aluno
	 * 
	 * @param matricula matricula do aluno
	 * @param nome      nome do aluno
	 * @param curso     curso do aluno
	 * @return String dizendo se o cadastro foi ou não realizado (caso já exista)
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		verificaParametro(matricula);
		verificaParametro(nome);
		verificaParametro(curso);
		if (!alunos.containsKey(matricula)) {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
			return "\nCADASTRO REALIZADO!";
		}
		return "\nMATRICULA JA CADASTRADA!";
	}

	/**
	 * Método que consulta um aluno
	 * 
	 * @param matricula matricula do aluno
	 * @return retorna o toString do aluno, caso exista (Se não existir, retorna
	 *         "Aluno não cadastrado.")
	 */
	public String consultarAluno(String matricula) {
		if (alunos.containsKey(matricula))
			return "\nAluno: " + alunos.get(matricula).toString();
		return "\nAluno não cadastrado.";
	}

	/**
	 * Método que cadastra um grupo
	 * 
	 * @param nome nome do grupo
	 * @return retorna uma string dizendo se o grupo foi cadastrado ou não (caso já
	 *         exista)
	 */
	public String cadastraGrupo(String nome) {
		verificaParametro(nome);

		if (!contemGrupo(nome)) {
			grupos.put(nome, new Grupo(nome));
			return "\nCADASTRO REALIZADO!";
		}
		return "\nGRUPO JÁ CADASTRADO!";
	}

	/**
	 * Método que verifica se um grupo já existe ou não
	 * 
	 * @param nome nome do Grupo
	 * @return retorna um boolean, representando se o grupo existe ou não
	 */
	private boolean contemGrupo(String nome) {
		for (String correntGrupo : this.grupos.keySet())
			if (correntGrupo.equals(nome))
				return true;
		return false;
	}

	/**
	 * Método que aloca um aluno em um grupo
	 * 
	 * @param matricula matricula do aluno
	 * @param nomeGrupo nome do grupo a ser inserido
	 * @return retorna uma String dizendo se o aluno foi alocado ou não O aluno não
	 *         é alocado caso o grupo ou o aluno não existam
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		verificaParametro(matricula);
		verificaParametro(nomeGrupo);
		if (alunos.containsKey(matricula) && grupos.containsKey(nomeGrupo))
			return grupos.get(nomeGrupo).addAluno(alunos.get(matricula));
		else if (!alunos.containsKey(matricula))
			return "\nAluno não cadastrado.";
		return "\nGrupo não cadastrado.";
	}

	/**
	 * Método que imprime os integrantes de um grupo
	 * 
	 * @param nomeGrupo nome do grupo a ser analisado
	 * @return retorna uma string com os integrantes, ou com a mensagem "Grupo não
	 *         cadastrado."
	 */
	public String imprimeGrupo(String nomegrupo) {
		if (contemGrupo(nomegrupo))
			return encontraGrupo(nomegrupo);
		return "\nGrupo não cadastrado.";
	}

	/**
	 * Método que vertifica se um grupo existe
	 * 
	 * @param grupo grupo a ser verificado
	 * @return retorna o grupo
	 */
	private String encontraGrupo(String grupo) {
		for (String correntGrupo : this.grupos.keySet()) {
			if (correntGrupo.equals(grupo))
				return grupos.get(correntGrupo).toString();
		}
		return "";
	}

	/**
	 * Método que registra uma resposta de um aluno
	 * 
	 * @param matricula matricula do aluno
	 * @return retorna uma string dizendo se a resposta foi registrada ou não
	 */
	public String registraResposta(String matricula) {
		verificaParametro(matricula);
		if (alunos.containsKey(matricula)) {
			respostas.add(alunos.get(matricula));
			return "\nRESPOSTA REGISTRADA!";
		}
		return "\nAluno não cadastrado.";
	}

	/**
	 * Método que mostra a representação textual das respostas
	 * 
	 * @return retorna os alunos que responderam
	 */
	public String toStringRespostas() {
		String saida = "Alunos:\n";
		if (respostas.size() > 0) {
			for (int i = 1; i <= respostas.size(); i++)
				saida += i + ". " + respostas.get(i - 1) + "\n";
		}
		return saida;
	}

	/**
	 * Método que verifica se algum parametro não pe nulo ou vazio
	 * 
	 * @param parametro parametro que se quer analisar
	 * @throws IllegalArgumentException(vazio) caso parametro seja vazio
	 *                                         NullPointerExeption(nulo) caso
	 *                                         parametro seja nulo
	 */
	public void verificaParametro(String parametro) {
		if (parametro == null)
			throw new NullPointerException("\nEntrada Inválida");
		else if (parametro.trim().equals(""))
			throw new IllegalArgumentException("\nEntrada Inválida");
	}

	/**
	 * Método que retorna o mapa de grupos (metodo usado nos testes)
	 * 
	 * @return todos os grupos criados
	 */
	public Map<String, Grupo> getGrupos() {
		return this.grupos;
	}

}
