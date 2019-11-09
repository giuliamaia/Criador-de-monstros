package monsterRPG.sistema.monstro;

public class DragaoVerde extends Monstro{
	public DragaoVerde(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anf�bio", "O drag�o pode respirar ar e �gua."));
		this.getHabilidades().add(new Habilidades("Sopro elemental", "O drag�o exala g�s venenoso em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de dificuldade 11, tomando 6d6 de dano �cido numa falha, ou metade do dano num sucesso."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Vis�o noturna (60 p�s)");
		this.getSentidos().add("Vis�o cega (10 p�s)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Veneno");
	}
}