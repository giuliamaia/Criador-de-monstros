package monsterRPG.sistema.monstro;

public class Fogo extends Monstro{
	public Fogo(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherResistencias();
		this.preencherSentidos();
	}

	private void preencherResistencias() {
		this.getResistencias().add("Espancamento");
		this.getResistencias().add("Perfuração");
		this.getResistencias().add("Corte");
	}
	
	private void preencherHabilidades() {
		// TODO:preenche victor
		this.getHabilidades().add(new Habilidades("Forma de fogo", "O elemental pode se mover por espaços tão apertados quanto 1 polegada. Uma criatura que toque o elemental ou o atinja com com um golpe corpo a corpo enquanto dentro de 5 pés toma 1d10 de dano de fogo. Além disso, o elemental pode entrar no espaço de uma criatura hostil e parar lá. A primeira vez que entra no espaço de uma criatura em um turno aquela criatura toma 1d10 de dano de fogo e entra em combustão. Até que alguém use uma ação para apagar as chamas a criatura toma 1d10 de dano de fogo no começo de cada turno."));
		this.getHabilidades().add(new Habilidades("Iluminação", "O elemental lança luz brihante em um raio de 30 pés. E luz fraca em um adicional de 30 pés."));
		this.getHabilidades().add(new Habilidades("Suceptibilidade à água", "A cada 5 pés que o elemental se move na água ou a cada galão de água derramada recebe 1 dano de frio."));
	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Ignan");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Fogo");
		this.getImunidades().add("Veneno");
		this.getImunidades().add("Exaustão");
		this.getImunidades().add("Agarrão");
		this.getImunidades().add("Paralisia");
		this.getImunidades().add("Petrificação");
		this.getImunidades().add("Derrubada");
		this.getImunidades().add("Restrição");
		this.getImunidades().add("Inconsciência");
	}
}

