package monsterRPG.sistema;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Criatura extends Status implements Serializable {
	private static final long serialVersionUID = 7584850659836730004L;
	private String nome;
	private String descrição;
	private Types tipo;
	private LocalDate dataCriacao;
	private boolean favorito;
	private List<String> jogadoresQueMataram = new ArrayList<String>();
	private String UrlDaFotinha;

	public Criatura(int vida, int defesa, double nivel, int força, int destreza, int constituição, int inteligência,
			int sabedoria, int carisma, String nome, String descrição, Types tipo) {
		super(vida, defesa, nivel, força, destreza, constituição, inteligência, sabedoria, carisma);
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		try {
			this.setaFoto();
		} catch (IOException e) {
			System.out.println("Deu merda na fotinha:" + e.getMessage());
		}

	}

	private void setaFoto() throws IOException {
		if (tipo == Types.BESTA) {
			UrlDaFotinha = "images/BESTA.jpg";
		} else if (tipo == Types.ABERRAÇAO) {
			UrlDaFotinha = "images/ABERRAÇAO.jpg";
		} else if (tipo == Types.CELESTIAL) {
			UrlDaFotinha = "images/CELESTIAL.jpg";
		} else if (tipo == Types.CONSTRUTO) {
			UrlDaFotinha = "images/CONSTRUTO.jpg";
		} else if (tipo == Types.DEMONIO) {
			UrlDaFotinha = "images/DEMONIO.jpg";
		} else if (tipo == Types.DRAGAO) {
			UrlDaFotinha = "images/DRAGAO.jpg";
		} else if (tipo == Types.ELEMENTAL) {
			UrlDaFotinha = "images/ELEMENTAL.jpg";
		} else if (tipo == Types.FADA) {
			UrlDaFotinha = "images/FADA.jpg";
		} else if (tipo == Types.GIGANTE) {
			UrlDaFotinha = "images/GIGANTE.png";
		} else if (tipo == Types.GOSMA) {
			UrlDaFotinha = "images/GOSMA.jpg";
		} else if (tipo == Types.HUMANOIDE) {
			UrlDaFotinha = "images/HUMANOIDE.jpeg";
		} else if (tipo == Types.MONSTRUOSIDADE) {
			UrlDaFotinha = "images/MONSTRUOSIDADE.jpg";
		} else if (tipo == Types.MORTOVIVO) {
			UrlDaFotinha = "images/MORTOVIVO.png";
		} else if (tipo == Types.PLANTA) {
			UrlDaFotinha = "images/PLANTA.png";
		} else {
			UrlDaFotinha = "images/amem.jpeg";
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

	public void setDataNow() {
		this.dataCriacao = LocalDate.now();
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

	public void removerMortePeloJogador(String jogador) {
		for (int i = 0; i < this.getJogadoresQueMataram().size(); i++) {
			if (this.jogadoresQueMataram.get(i).contains(jogador)) {
				this.jogadoresQueMataram.remove(i);
			}
		}
	}

	@Override
	public String toString() {
		String retorno = getNome();
		if (jogadoresQueMataram != null && jogadoresQueMataram.size() > 0) {
			retorno.concat("    Mataram:");
			for (int i = 0; i < jogadoresQueMataram.size(); i++) {
				retorno.concat(" " + jogadoresQueMataram.get(i));
			}
		}
		return retorno;
	}

	public void editarMortePeloJogador(String jogadorAntigo, String jogadorNovo) {
		int temp = jogadoresQueMataram.indexOf(jogadorAntigo);
		jogadoresQueMataram.remove(jogadorAntigo);
		jogadoresQueMataram.add(temp, jogadorNovo);

	}

	public List<String> listarJogadoresMortosComNome(String nome) {
		List<String> aux = new ArrayList<String>();
		for (int i = 0; i < jogadoresQueMataram.size(); i++) {
			if (jogadoresQueMataram.get(i).toUpperCase().contains(nome.toUpperCase())) {
				aux.add(jogadoresQueMataram.get(i));
			}

		}
		return aux;
	}
}
