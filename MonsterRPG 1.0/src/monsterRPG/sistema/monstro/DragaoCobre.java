package monsterRPG.sistema.monstro;

public class DragaoCobre extends Monstro{
	public DragaoCobre(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca, int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super(nome, historia, tamanho, vida, defesa, velocidade, forca, destreza, constituiçao, inteligencia, sabedoria, carisma, nivel);
		this.preencherHabilidades();
		this.preencherImunidades();
		this.preencherLinguas();
		this.preencherSentidos();
	}

	
	private void preencherHabilidades() {
		this.getHabilidades().add(new Habilidades("Sopro elemental (de ácido)", "O dragão exala ácido em uma linha 20x5 pés. Cada criatura nessa área precisa fazer um teste de resistência de Destreza de dificuldade 11, tomando 4d8 de dano ácido numa falha, ou metade do dano num sucesso."));
		this.getHabilidades().add(new Habilidades("Sopro elemental (de lentidão)", "O dragão exala gás em um cone de 15 pés. Cada criatura nessa área precisa passar em um teste de resistência de Constituição de dificuldade 12, caso contrário a criatura não pode usar reações, sua velocidade é dividida pela metade, e não pode fazer mais de um ataque no seu turno. Em adição, a criatura pode usar ou ou uma ação ou uma ação bônus no seu turno (mas não ambos). Esse efeito dura por 1 minuto. A criatura pode repetir o teste de resistência no final de cada um de seus turnos, acabando com o efeito nele mesmo com um sucesso."));

	}
	
	private void preencherLinguas() {
		this.getLinguas().add("Draconic");
	}
	
	private void preencherSentidos() {
		this.getSentidos().add("Visão noturna (60 pés)");
		this.getSentidos().add("Visão cega (10 pés)");

	}
	
	private void preencherImunidades() {
		this.getImunidades().add("Ácido");
	}
}
