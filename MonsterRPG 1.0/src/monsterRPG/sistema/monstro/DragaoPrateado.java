package monsterRPG.sistema.monstro;

public class DragaoPrateado extends Monstro{
	public DragaoPrateado(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de frio)", "O drag�o exala uma explos�o gelada de granizo em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Constitui��o de dificuldade 13, tomando 4d8 de dano �cido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (paralisante)", "O drag�o exala um g�s paralisante em um cone de 15 p�s. Cada criatura nessa �rea precisa passar em um teste de resist�ncia de Constitui��o de dificuldade 13, caso contr�rio a criatura � paralisada por 1 minuto. A criatura pode repetir o teste de resist�ncia no final de cada um de seus turnos, acabando com o efeito em um sucesso."));

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