public abstract class Monstro {
	private String nome; // nome
	private String historia; // historia
	private String tamanho;
	private String tipo; 

	private int hp; //Hit Points (Vida)
	private int ac; //Armor Class (defesa)
	private int spd; //Velocidade
 
	private int for; //Força
	private int dex; //Destreza
	private int con; //Constituição
	private int int; //Inteligência
	private int wis; //Sabedoria
	private int cha; //Carisma

	private float cr;//Challenge Rating (nivel)
	private List<String> resistencias;
	private List<String> imunidades;
	private List<String> sentidos;
	private List<String> linguas;
	private List<String> habilidades;

	//TODO: Getters e Setters
}