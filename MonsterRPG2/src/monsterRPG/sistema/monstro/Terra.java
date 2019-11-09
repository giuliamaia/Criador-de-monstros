package monsterRPG.sistema.monstro;

public class Terra extends Monstro implements Preencher{
	public Terra(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherResistencias();
		this.preencherSentidos();
	}

	public void preencherResistencias() {
		this.getResistencias().add("Espancamento");
		this.getResistencias().add("Perfuração");
		this.getResistencias().add("Corte");
	}
	
	public void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Planador da terra", "O elemental pode escavar a terra e pedras não mágicas. Enquanto isso, o elemental não perturba o material pelo qual ele se move."));
		this.getHabilidades().add(new Habilidades("Monstro de cerco", "O elemental causa dano duplo a objetos e estruturas."));
	}
	
	public void preencherLinguas() {
		this.getLinguas().add("Terran");
	}
	
	public void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Sentido de tremor (60 pés)");//TODO victor isso ta certo?
	}
	
	public void preencherImunidades() {
		this.getImunidades().add("Veneno");
		this.getImunidades().add("Exaustão");
		this.getImunidades().add("Paralisia");
		this.getImunidades().add("Petrificação");
		this.getImunidades().add("Inconsciência");
	}
}
