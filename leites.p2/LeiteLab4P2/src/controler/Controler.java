package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aluno.Aluno;
import grupo.Grupo;
import util.Util;

public class Controler {

	private List<Aluno> alunosResponderam;
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;

	public Controler() {
		this.alunosResponderam = new ArrayList<>();
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
	}

	public String cadastraAluno(String mat, String nome, String curso) {
		String saida = "MATRICULA JA CADASTRADA!";

		if (!alunos.containsKey(mat)) {
			alunos.put(mat, new Aluno(mat, nome, curso));
			saida = "CADASTRO REALIZADO!";
		}
		return saida;
	}

	public String contemAluno(String mat) {
		String saida = "Aluno não cadastrado.";

		if (alunos.containsKey(mat))
			saida = "Aluno: " + alunos.get(mat).toString();
		return saida;
	}

	public String novoGrupo(String nome) {
		Util.validaString(nome);
		String saida = "GRUPO JÁ CADASTRADO!";

		if (!contemGrupo(nome)) {
			grupos.put(nome, new Grupo(nome));
			saida = "CADASTRO REALIZADO!";
		}
		return saida;
	}

	private boolean contemGrupo(String nome) {
		boolean guarda = false;

		for (String str : this.grupos.keySet())
			if (str.equalsIgnoreCase(nome))
				guarda = true;
		return guarda;
	}

	public String alocarAluno(String mat, String nomeGrupo) {
		Util.validaMatricula(mat);
		Util.validaString(nomeGrupo);
		String saida = "";

		if (alunos.containsKey(mat) && grupos.containsKey(nomeGrupo))
			saida = grupos.get(nomeGrupo).addAluno(alunos.get(mat));
		else
			saida = erroAlocacao(mat, nomeGrupo);

		return saida;
	}

	private String erroAlocacao(String mat, String nomeGrupo) {
		String saida = "Aluno não cadastrado.";

		if (grupos.containsKey(nomeGrupo))
			saida = "Grupo não cadastrado.";
		return saida;
	}

	public String imprimirGrupo(String nomegrupo) {
		String saida = "Grupo não cadastrado.";

		if (contemGrupo(nomegrupo))
			saida = getGrupoIgnoreCase(nomegrupo);
		return saida;
	}

	private String getGrupoIgnoreCase(String nome) {
		String saida = "";

		for (String str : this.grupos.keySet())
			if (str.equalsIgnoreCase(nome))
				saida = grupos.get(str).toString();
		return saida;
	}

	public String resistraResposta(String mat) {
		Util.validaMatricula(mat);
		String saida = "Aluno não cadastrado.";

		if (alunos.containsKey(mat)) {
			alunosResponderam.add(alunos.get(mat));
			saida = "ALUNO REGISTRADO!";
		}
		return saida;
	}

	public String toStringAlunosQueResponderam() {
		String saida = "Alunos:" + Util.pulaLinha();
		for (int i = 1; i <= alunosResponderam.size(); i++)
			saida += i + ". " + alunosResponderam.get(i - 1) + Util.pulaLinha();
		return saida.trim();
	}

}
