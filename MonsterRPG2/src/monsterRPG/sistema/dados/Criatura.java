package monsterRPG.sistema.dados;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Criatura extends Status {
	private String nome;
	private String descrição;
	private Types tipo;
	private LocalDate dataCriacao;
	private boolean favorito;
	private List<String> jogadoresQueMataram = new ArrayList<String>();
	private BufferedImage fotinha;
	public Criatura(int vida, int defesa, double nivel, int força, int destreza, int constituição, int inteligência, int sabedoria,
			int carisma, String nome, String descrição, Types tipo, boolean favorito) {
		super(vida, defesa, nivel, força, destreza, constituição, inteligência, sabedoria, carisma);
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		this.dataCriacao = LocalDate.now();
		this.favorito = favorito;
		if (tipo.equals(Types.Besta)) {
			try {
				fotinha = ImageIO.read(new File("monsterRPG/gui/images/images.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
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
}
