package monsterRPG.sistema;

public abstract class Status {
	private int vida;
	private int defesa;
	private double nivel;
	private int forca;
	private int destreza;
	private int constituicao;
	private int inteligencia;
	private int sabedoria;
	private int carisma;
	public Status(int vida, int defesa, double nivel, int forca, int destreza, int constituicao, int inteligencia,
			int sabedoria, int carisma) {

		this.vida = vida;
		this.defesa = defesa;
		this.nivel = nivel;
		this.forca = forca;
		this.destreza = destreza;
		this.constituicao = constituicao;
		this.inteligencia = inteligencia;
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
	public void setNivel(double nivel) {
		this.nivel = nivel;
	}
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	public int getConstituicao() {
		return constituicao;
	}
	public void setConstituicao(int constituicao) {
		this.constituicao = constituicao;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
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
