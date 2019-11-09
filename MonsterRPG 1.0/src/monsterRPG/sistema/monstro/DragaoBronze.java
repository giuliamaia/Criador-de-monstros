package monsterRPG.sistema.monstro;

public class DragaoBronze extends Monstro{
	public DragaoBronze(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anfíbio", "O dragão pode respirar ar e água."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de relâmpago)", "O dragão exala relâmpago em uma linha 40x5 pés. Cada criatura nessa área precisa fazer um teste de resistência de Destreza de dificuldade 12, tomando 3d10 de dano elétrico numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de repulsão)", "O dragão exala energia repulsiva em um cone de 30 pés. Cada criatura nessa área precisa fazer um teste de resistência de Força de dificuldade 12 e passar, caso contrário a criatura é empurrada 30 pés longe do dragão."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Visão cega (10 pés)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Relâmpago");
	}
}