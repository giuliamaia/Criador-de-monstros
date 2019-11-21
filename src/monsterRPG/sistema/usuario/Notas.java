package monsterRPG.sistema.usuario;

public class Notas {
	
	private String titulo;
	private String conteudo;
	
	
	public Notas(String titulo, String conteudo) {
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

}
