package monsterRPG.sistema.monstro;

public class DragaoBronze extends Monstro{
	public DragaoBronze(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Anf�bio", "O drag�o pode respirar ar e �gua."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de rel�mpago)", "O drag�o exala rel�mpago em uma linha 40x5 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Destreza de dificuldade 12, tomando 3d10 de dano el�trico numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de repuls�o)", "O drag�o exala energia repulsiva em um cone de 30 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de For�a de dificuldade 12 e passar, caso contr�rio a criatura � empurrada 30 p�s longe do drag�o."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Vis�o noturna (60 p�s)");
		this.getSentidos().add("Vis�o cega (10 p�s)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Rel�mpago");
	}
}