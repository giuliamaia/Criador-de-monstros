package monsterRPG.sistema.usuario;

import java.util.List;

public class Mestre {
	private List<Mesa> mesas;

	public Mestre(List<Mesa> mesas) {
		super();
		this.mesas = mesas;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

}
