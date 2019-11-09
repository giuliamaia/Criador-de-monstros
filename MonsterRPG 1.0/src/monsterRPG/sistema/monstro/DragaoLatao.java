package monsterRPG.sistema.monstro;

public class DragaoLatao extends Monstro{
	public DragaoLatao(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de fogo)", "O drag�o exala fogo em uma linha 20x5 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Destreza de dificuldade 11, tomando 4d6 de dano flamejante numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de sono)", "O drag�o exala g�s son�fero em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Constitui��o de dificuldade 11 e passar, ou cai inconsciente por 1 minuto. Esse efeito termina se a criatura tomar dano ou algu�m usar uma a��o pra acord�r-lo."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Vis�o noturna (60 p�s)");
		this.getSentidos().add("Vis�o cega (10 p�s)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Fogo");
	}
}