package monsterRPG.sistema.dados;

import java.time.LocalDate;

public class Criatura extends Status {
	private String nome;
	private String descrição;
	private Types tipo;
	private LocalDate dataCriacao;
	private boolean favorito;
	//TODO Fotinhaaa
	public Criatura(int vida, int defesa, double nivel, int força, int destreza, int constituição, int inteligência, int sabedoria,
			int carisma, String nome, String descrição, Types tipo) {
		super(vida, defesa, nivel, força, destreza, constituição, inteligência, sabedoria, carisma);
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		this.dataCriacao = LocalDate.now();
		this.favorito = false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public Types getTipo() {
		return this.tipo;
	}
	public void setTipo(Types tipo) {
		this.tipo = tipo;
	}
	public LocalDate getDataCriação() {
		return dataCriacao;
	}
	public void setDataCriação(LocalDate dataCriação) {
		this.dataCriacao = dataCriação;
	}
	public boolean isFavorito() {
		return favorito;
	}
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
}