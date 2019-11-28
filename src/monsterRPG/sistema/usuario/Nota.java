package monsterRPG.sistema.usuario;

import java.io.Serializable;

public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String conteudo;

	public Nota(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String toString() {
		return titulo;
	}

}
