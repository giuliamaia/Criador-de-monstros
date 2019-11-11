package monsterRPG.sistema.dados;

import java.util.ArrayList;
import java.util.List;


public class RepositorioCriaturas {
	List<Criatura> criaturas;
	
	public RepositorioCriaturas() {
		this.criaturas = new ArrayList<Criatura>();
	}
	
	public void adicionarCriatura(Criatura c) throws CriaturaInvalidaException {
		try {
			this.criaturas.add(c);
		} catch (NullPointerException e) {
			throw new CriaturaInvalidaException("Criatura criada não pode ser vazia. SEU ANIMAL!");
		}
	}
	public void removerCriatura(Criatura c) throws CriaturaInvalidaException {
		try {
			this.criaturas.remove(c);
		} catch (NullPointerException e) {
			throw new CriaturaInvalidaException("Rapaz, n sei oq tu fez, mas fudeu!");
		}
	}
	
	public List<Criatura> listarPorNome(String nome) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		if(nome == null) return null;
		
		for(Criatura c : this.criaturas) {
			if(c.getNome().equals(nome)) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	public List<Criatura> listarPorTipo(Types tipo) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		for(Criatura c : this.criaturas) {
			if(c.getTipo().equals(tipo)) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	public List<Criatura> listarPorNivel(double menor, double maior) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		for(Criatura c : this.criaturas) {
			double nivel = c.getNivel();
			if(menor <= nivel && nivel <= maior) {
				ret.add(c);
			}
		}
		return ret;
	}
}