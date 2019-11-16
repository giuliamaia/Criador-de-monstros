package monsterRPG.sistema;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Criatura extends Status implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7104709096986882562L;
	private String nome;
	private String descrição;
	private Types tipo;
	private LocalDate dataCriacao;
	private boolean favorito;
	private List<String> jogadoresQueMataram = new ArrayList<String>();
	private String UrlDaFotinha;
	public Criatura(int vida, int defesa, double nivel, int força, int destreza, int constituição, int inteligência, int sabedoria,
			int carisma, String nome, String descrição, Types tipo) {
		super(vida, defesa, nivel, força, destreza, constituição, inteligência, sabedoria, carisma);
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		this.dataCriacao = LocalDate.now();
		try {
			this.setaFoto();
			return;
		}
		catch(IOException e) {
			System.out.println("Deu merda");
		}
		
	}
	private void setaFoto() throws IOException {
		if(tipo == Types.BESTA) {
			UrlDaFotinha = "/MonsterRPG/src/monsterRPG/gui/images/images.png";
		}
		else {
			UrlDaFotinha = "/MonsterRPG/src/monsterRPG/gui/images/1 zv9W7fMl12F1EYUuMR7q6A.jpeg";
		}
	}

	public String getUrlDaFotinha() {
		return UrlDaFotinha;
	}
	public void setUrlDaFotinha(String urlDaFotinha) {
		UrlDaFotinha = urlDaFotinha;
	}
	public List<String> getJogadoresQueMataram() {
		return jogadoresQueMataram;
	}
	public void setJogadoresQueMataram(List<String> jogadoresQueMataram) {
		this.jogadoresQueMataram = jogadoresQueMataram;
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
	public void adicionarMortePeloJogador(String jogador) {
		this.jogadoresQueMataram.add(jogador);
	}
	
	@Override
	public String toString() {
		String retorno = getNome();
		if(jogadoresQueMataram != null && jogadoresQueMataram.size() > 0) {
			retorno.concat("    Mataram:");
			for (int i = 0; i < jogadoresQueMataram.size(); i++) {
				retorno.concat(" " + jogadoresQueMataram.get(i));
			}
		}
		return retorno;
	}
	
}
