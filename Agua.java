package sistema;


public class Agua extends Monstro {
	
	public Agua(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherResistencias();
		this.preencherSentidos();
	}

	private void preencherResistencias() {
		this.getResistencias().add("Ácido");
		this.getResistencias().add("Corte");
		this.getResistencias().add("Perfuração");
		this.getResistencias().add("Impacto");
	}
	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Forma aquática", "O elemental pode entrar no espaço de uma criatura hostil e ficar lá. Ele pode se mover por um espaço tão apertado quanto uma polegada."));
		this.getHabilidades().add(new Habilidades("Congelar", "Se o elemental tomar dano de frio, ele congela parcialmente. Sua velocidade é reduzida em 20 pés até o próximo turno."));
	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Aquan");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
	}
	
	private void preencherImunidades() {
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
