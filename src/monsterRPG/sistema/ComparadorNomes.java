package monsterRPG.sistema;

import java.util.Comparator;

public class ComparadorNomes implements Comparator<Criatura> {

	public ComparadorNomes() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Criatura c1, Criatura c2) {
		return c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase());
	}
}
