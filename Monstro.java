package sistema;

import java.util.List;

public abstract class Monstro {
	private String nome; // nome
	private String historia; // historia
	private String tamanho;
	private String tipo; 

	private int hp; //Hit Points (Vida)
	private int ac; //Armor Class (defesa)
	private int spd; //Velocidade
 
	private int forc; //Força
	private int dex; //Destreza
	private int con; //Constituição
	private int inte; //Inteligência
	private int wis; //Sabedoria
	private int cha; //Carisma

	private float cr;//Challenge Rating (nivel)
	private List<String> resistencias;
	private List<String> imunidades;
	private List<String> sentidos;
	private List<String> linguas;
	private List<String> habilidades;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getForc() {
		return forc;
	}
	public void setForc(int forc) {
		this.forc = forc;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getInte() {
		return inte;
	}
	public void setInte(int inte) {
		this.inte = inte;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public float getCr() {
		return cr;
	}
	public void setCr(float cr) {
		this.cr = cr;
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
	public List<String> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}

	
}
