package monsterRPG.sistema.monstro;

public class DragaoPrateado extends Monstro{
	public DragaoPrateado(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de frio)", "O dragão exala uma explosão gelada de granizo em um cone de 15 pés. Cada criatura nessa área precisa fazer um teste de resistência de Constituição de dificuldade 13, tomando 4d8 de dano ácido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (paralisante)", "O dragão exala um gás paralisante em um cone de 15 pés. Cada criatura nessa área precisa passar em um teste de resistência de Constituição de dificuldade 13, caso contrário a criatura é paralisada por 1 minuto. A criatura pode repetir o teste de resistência no final de cada um de seus turnos, acabando com o efeito em um sucesso."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Visão cega (10 pés)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Frio");
	}
}