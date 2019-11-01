package sistema;

import java.util.List;

public abstract class Monstro {
	private String nome; 
	private String historia; 
	private String tamanho; 
	private int vida; 
	private int defesa; 
	private int velocidade; 
	private int forca; 
	private int destreza; 
	private int constituiçao; 
	private int inteligencia; 
	private int sabedoria; 
	private int carisma;
	private double nivel; 
	private List<String> resistencias;
	private List<String> imunidades; 
	private List<String> sentidos; 
	private List<String> linguas; 
	private List<Habilidades> habilidades; 
	
	
	
	public Monstro(String nome, String historia, String tamanho, int vida, int defesa, int velocidade, int forca,
			int destreza, int constituiçao, int inteligencia, int sabedoria, int carisma, double nivel) {
		super();
		this.nome = nome;
		this.historia = historia;
		this.tamanho = tamanho;
		this.vida = vida;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.forca = forca;
		this.destreza = destreza;
		this.constituiçao = constituiçao;
		this.inteligencia = inteligencia;
		this.sabedoria = sabedoria;
		this.carisma = carisma;
		this.nivel = nivel;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
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
	public int getConstituiçao() {
		return constituiçao;
	}
	public void setConstituiçao(int constituiçao) {
		this.constituiçao = constituiçao;
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
	public double getNivel() {
		return nivel;
	}
	public void setNivel(double nivel) {
		this.nivel = nivel;
	}
	public List<String> getResistencias() {
		return resistencias;
	}
	public void setResistencias(List<String> resistencias) {
		this.resistencias = resistencias;
	}
	public List<String> getImunidades() {
		return imunidades;
	}
	public void setImunidades(List<String> imunidades) {
		this.imunidades = imunidades;
	}
	public List<String> getSentidos() {
		return sentidos;
	}
	public void setSentidos(List<String> sentidos) {
		this.sentidos = sentidos;
	}
	public List<String> getLinguas() {
		return linguas;
	}
	public void setLinguas(List<String> linguas) {
		this.linguas = linguas;
	}
	public List<Habilidades> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}
	
}
