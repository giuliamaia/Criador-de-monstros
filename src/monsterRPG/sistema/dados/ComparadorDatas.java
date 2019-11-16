package monsterRPG.sistema.dados;

import java.util.Comparator;

import monsterRPG.sistema.Criatura;

	public class ComparadorDatas implements Comparator<Criatura>{
	public ComparadorDatas() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Criatura c1, Criatura c2) {
		if(c1.getDataCriação().isBefore(c2.getDataCriação())) {
			return -1;
		}
		else if(c1.getDataCriação().isBefore(c2.getDataCriação())) {
			return 1;
		}
		return 0;
	}
}
