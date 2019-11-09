package monsterRPG.sistema.monstro;

public class DragaoCobre extends Monstro{
	public DragaoCobre(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constitui�ao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constitui�ao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de �cido)", "O drag�o exala �cido em uma linha 20x5 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Destreza de dificuldade 11, tomando 4d8 de dano �cido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de lentid�o)", "O drag�o exala g�s em um cone de 15 p�s. Cada criatura nessa �rea precisa fazer um teste de resist�ncia de Constitui��o de dificuldade 12 e passar, caso contr�rio a criatura n�o pode usar rea��es, sua velocidade � dividida pela metade, e n�o pode fazer mais de um ataque no seu turno. Em adi��o, a criatura pode usar ou ou uma a��o ou uma a��o b�nus no seu turno (mas n�o ambos). Esse efeito dura por 1 minuto. A criatura pode repetir o teste de resist�ncia no final de cada um de seus turnos, acabando com o efeito nele mesmo com um sucesso."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Vis�o noturna (60 p�s)");
		this.getSentidos().add("Vis�o cega (10 p�s)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("�cido");
	}
}