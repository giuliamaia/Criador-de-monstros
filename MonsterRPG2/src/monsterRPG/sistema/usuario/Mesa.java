package monsterRPG.sistema.usuario;

import java.util.HashMap;
import java.util.List;

public class Mesa {
	private String nome;
	private String descriçao;
	private List<String> jogadores;
	private List<String> monstros;
	HashMap<String, String> blocoNotas = new HashMap<String, String>();
	public Mesa(String nome, String descriçao, List<String> jogadores, List<String> monstros,
			HashMap<String, String> blocoNotas) {

		this.nome = nome;
		this.descriçao = descriçao;
		this.jogadores = jogadores;
		this.monstros = monstros;
		this.blocoNotas = blocoNotas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescriçao() {
		return descriçao;
	}
	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	public List<String> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<String> jogadores) {
		this.jogadores = jogadores;
	}
	public List<String> getMonstros() {
		return monstros;
	}
	public void setMonstros(List<String> monstros) {
		this.monstros = monstros;
	}
	public HashMap<String, String> getBlocoNotas() {
		return blocoNotas;
	}
	public void setBlocoNotas(HashMap<String, String> blocoNotas) {
		this.blocoNotas = blocoNotas;
	}
	
	
}
