package monsterRPG.sistema.monstro;

public class DragaoLatao extends Monstro{
	public DragaoLatao(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de fogo)", "O dragão exala fogo em uma linha 20x5 pés. Cada criatura nessa área precisa fazer um teste de resistência de Destreza de dificuldade 11, tomando 4d6 de dano flamejante numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de sono)", "O dragão exala gás sonífero em um cone de 15 pés. Cada criatura nessa área precisa passar em um teste de resistência de Constituição de dificuldade 11, caso contrário cai inconsciente por 1 minuto. Esse efeito termina se a criatura tomar dano ou alguém usar uma ação pra acordár-lo."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Visão cega (10 pés)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Fogo");
	}
}
