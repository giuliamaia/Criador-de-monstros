package monsterRPG.sistema.monstro;

public class DragaoDourado extends Monstro{
	public DragaoDourado(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anfíbio", "O dragão pode respirar ar e água."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de fogo)", "O dragão exala ácido em um cone de 15 pés. Cada criatura nessa área precisa fazer um teste de resistência de Destreza de dificuldade 13, tomando 4d10 de dano ácido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de enfraquecimento)", "O dragão exala gás em um cone de 15 pés. Cada criatura nessa área precisa fazer um teste de resistência de Força de dificuldade 13 e passar, caso contrário a criatura tem desvantagem em rolagens de ataques baseados em Força, testes de Força e testes de resistência de Força por 1 minuto. A criatura pode repetir o teste de resistência no final de cada um de seus turnos, acabando com o efeito em um sucesso."));

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