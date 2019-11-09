package monsterRPG.sistema.monstro;

public class DragaoDourado extends Monstro{
	public DragaoDourado(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anf�bio", "O drag�o pode respirar ar e �gua."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de fogo)", "O drag�o exala �cido em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Destreza de dificuldade 13, tomando 4d10 de dano �cido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de enfraquecimento)", "O drag�o exala g�s em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de For�a de dificuldade 13 e passar, caso contr�rio a criatura tem desvantagem em rolagens de ataques baseados em For�a, testes de For�a e testes de resist�ncia de For�a por 1 minuto. A criatura pode repetir o teste de resist�ncia no final de cada um de seus turnos, acabando com o efeito em um sucesso."));

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