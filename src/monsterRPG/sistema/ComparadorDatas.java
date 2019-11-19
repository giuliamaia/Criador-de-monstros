package monsterRPG.sistema;

import java.util.Comparator;

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
