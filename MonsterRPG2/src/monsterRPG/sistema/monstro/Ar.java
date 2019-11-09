package monsterRPG.sistema.monstro;

public class Ar extends Monstro implements Preencher{
	public Ar(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherResistencias();
		this.preencherSentidos();
	}

	public void preencherResistencias() {
		this.getResistencias().add("Raio");
		this.getResistencias().add("Trovão");
		this.getResistencias().add("Espancamento");
		this.getResistencias().add("Corte");
		this.getResistencias().add("Perfuração");
	}
	
	public void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Forma de ar", "O elemental pode entrar no espaço de uma criatura hostil e ficar lá. Ele pode se mover por um espaço tão apertado quanto uma polegada."));
		
	}
	
	public void preencherLinguas() {
		this.getLinguas().add("Auran");
	}
	
	public void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
	}
	
	public void preencherImunidades() {
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
