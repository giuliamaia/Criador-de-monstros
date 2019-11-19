package monsterRPG.sistema;

import java.util.List;

public class Historico {
	List<Criatura> adicionadas;
	List<Criatura> removidas;
	public Historico(List<Criatura> adicionadas, List<Criatura> removidas) {
		this.adicionadas = adicionadas;
		this.removidas = removidas;
	}
	public Historico() {
		
	}
	public List<Criatura> getAdicionadas() {
		return adicionadas;
	}
	public void setAdicionadas(List<Criatura> adicionadas) {
		this.adicionadas = adicionadas;
	}
	public List<Criatura> getRemovidas() {
		return removidas;
	}
	public void setRemovidas(List<Criatura> removidas) {
		this.removidas = removidas;
	}
	@Override
	public String toString() {
		return "Historico [adicionadas=" + adicionadas + ", removidas=" + removidas + "]";
	}
	
	
}
