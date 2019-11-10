package monsterRPG.sistema.dados;

public abstract class Status {
	private int vida;
	private int defesa;
	private double nivel;
	private int força;
	private int destreza;
	private int constituição;
	private int inteligência;
	private int sabedoria;
	private int carisma;
	
	public Status(int vida, int defesa, double nivel, int força, int destreza, int constituição, int inteligência, int sabedoria,
			int carisma) {
		this.vida = vida;
		this.defesa = defesa;
		this.nivel = nivel;
		this.força = força;
		this.destreza = destreza;
		this.constituição = constituição;
		this.inteligência = inteligência;
		this.sabedoria = sabedoria;
		this.carisma = carisma;
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public double getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getForça() {
		return força;
	}
	public void setForça(int força) {
		this.força = força;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	public int getConstituição() {
		return constituição;
	}
	public void setConstituição(int constituição) {
		this.constituição = constituição;
	}
	public int getInteligência() {
		return inteligência;
	}
	public void setInteligência(int inteligência) {
		this.inteligência = inteligência;
	}
	public int getSabedoria() {
		return sabedoria;
	}
	public void setSabedoria(int sabedoria) {
		this.sabedoria = sabedoria;
	}
	public int getCarisma() {
		return carisma;
	}
	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}
}
