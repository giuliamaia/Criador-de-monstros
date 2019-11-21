package monsterRPG.sistema.dados;

import java.util.ArrayList;
import java.util.List;

import monsterRPG.sistema.usuario.Mesa;
import monsterRPG.sistema.MesaInvalidaException;


public class RepositorioMesas {
	List<Mesa> mesas = new ArrayList<Mesa>();

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	public List<String> getJogadoresMesa(String mesa){
		List<String> ret = new ArrayList<String>();
		for(int i=0; i<this.mesas.size(); i++) {
			if(this.mesas.get(i).getNome().equals(mesa)) {
				ret = this.mesas.get(i).getJogadores();
			}
		}
		return ret;
	}
	public void adicionarMesa(Mesa mesa) throws MesaInvalidaException {
		try {
			this.mesas.add(mesa);
		} catch (NullPointerException e) {
			throw new MesaInvalidaException("Mesa criada não pode ser vazia!");
		}
	}
	
	public void removerMesa(Mesa mesa) throws MesaInvalidaException {
		try {
			this.mesas.remove(mesa);
		} catch (NullPointerException e) {
			throw new MesaInvalidaException("Deu alguma merda!");
		}
	}
	public void editarMesa(Mesa mesa, String novoNome, String novaDescrição) throws MesaInvalidaException {
		int temp = this.mesas.indexOf(mesa);
		Mesa mesaNova = new Mesa(novoNome, novaDescrição, mesa.getBlocoNotas());
		mesaNova.setJogadores(mesa.getJogadores());
		mesaNova.setMonstros(mesa.getMonstros());
		this.removerMesa(mesa);
		this.mesas.add(temp, mesaNova);
	}
	
	
}
