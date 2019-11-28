package monsterRPG.sistema.usuario;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import monsterRPG.sistema.dados.RepositorioNotas;

public class Mesa implements Serializable{
	
	private static final long serialVersionUID = 1564536536L;
	private String nome;
	private String descriçao;
	private List<String> jogadores;
	private List<String> monstros;
	private HashMap<String, String> blocoNotas;
	private RepositorioNotas repositNotas = RepositorioNotas.getInstance();
	
	public Mesa(String nome, String descriçao, List<String> jogadores, List<String> monstros,
			HashMap<String, String> blocoNotas) {
	
		this.nome = nome;
		this.descriçao = descriçao;
		this.jogadores = jogadores;
		this.monstros = monstros;
		this.blocoNotas = blocoNotas;
	}
	public Mesa() {
		this.jogadores = new ArrayList<String>();
		this.monstros = new ArrayList<String>();
		this.blocoNotas = new HashMap<String, String>();
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
	public void adicionarJogador(String jogador) {
		this.jogadores.add(jogador);
	}
	public void removerJogador(String jogador) {
		if (this.jogadores.contains(jogador)) {
			this.jogadores.remove(jogador);
		}
		
	}
	public void editarJogador(String jogadorAntigo, String jogadorNovo) {
		int temp = this.getJogadores().indexOf(jogadorAntigo);
		removerJogador(jogadorAntigo);
		this.jogadores.add(temp, jogadorNovo);
	}
	public List<String> pesquisarJogador(String jogador) {
		List <String> retorno = new ArrayList<String>();
		for (String a:this.jogadores) {
			if (a.contains(jogador)) {
				retorno.add(a);
			}
		}
		return retorno;
	}
	public void adicionarMonstro(String monstro) {
		this.monstros.add(monstro);
	}
	public void editarMonstro(String monstroAntigo, String monstroNovo) {
		int temp = this.getMonstros().indexOf(monstroAntigo);
		removerMonstro(monstroAntigo);
		this.getMonstros().add(temp ,monstroNovo);
	}
	public void removerMonstro(String monstro) {
		if(this.monstros.contains(monstro)) {
			this.jogadores.remove(monstro);
		}
	}
	public void adicionarNota(String titulo, String conteudo) {
		this.blocoNotas.put(titulo, conteudo);
		this.repositNotas.adicionarNota(new Nota(titulo, conteudo));
	}
	public void editarNova(String tituloAntigo, String conteudoAntigo, String conteudoNovo) {
		this.blocoNotas.replace(tituloAntigo, conteudoAntigo, conteudoNovo);
		this.repositNotas.editarNota(new Nota(tituloAntigo, conteudoAntigo), conteudoNovo);
	}
	public void removerNova(String titulo) {
		this.blocoNotas.remove(titulo);
		this.repositNotas.removerNota(titulo);
	}
	@Override
	public String toString() {
		return this.getNome();
	}
}
