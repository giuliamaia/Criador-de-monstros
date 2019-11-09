package monsterRPG.sistema.monstro;

public class Undead extends Monstro {
	public Undead(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
	}
	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Fortitude dos Mortos-Vivos", "Se algum dano reduz a vida de um morto-vivo a 0, este deve fazer um Saving Throw de Constituição DC 5 + Dano Recebido, a menos que o dano tenha sido Radiante ou de um acerto Crítico. Caso passe, o morto-vivo permanece com 1 HP"));
	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Veneno");
	}
}

