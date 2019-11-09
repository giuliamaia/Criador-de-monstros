package monsterRPG.sistema.monstro;

public class DragaoNegro extends Monstro{
	public DragaoNegro(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anfíbio", "O dragão pode respirar ar e água."));
		this.getHabilidades().add(new Habilidades("Sopro elemental", "O dragão exala ácido em uma linha 5x30 pés. Cada criatura nessa linha precisa fazer um teste de resistência de dificuldade 11, tomando 5d8 de dano ácido numa falha, ou metade do dano num sucesso."));
		
	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Visão cega (10 pés)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Ácido");
	}
}