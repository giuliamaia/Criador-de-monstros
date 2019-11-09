package monsterRPG.sistema.monstro;

// de olhos azuis

public class DragaoBranco extends Monstro{
	public DragaoBranco(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental", "O drag�o exala uma explos�o gelada de granizo em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de dificuldade 12, tomando 5d8 de dano gelado numa falha, ou metade do dano num sucesso."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Vis�o noturna (60 p�s)");
		this.getSentidos().add("Vis�o cega (10 p�s)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Frio");
	}
}