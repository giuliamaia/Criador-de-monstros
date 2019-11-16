package monsterRPG.sistema.dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Types;


public class RepositorioCriaturas {
	List<Criatura> criaturas;
	
	public RepositorioCriaturas() {
		this.criaturas = new ArrayList<Criatura>();
	}
	public void editarCriatura(Criatura antiga, Criatura nova) throws CriaturaInvalidaException{
		int i = getIndex(antiga);
		removerCriatura(antiga);
		this.criaturas.add(i, nova);
	}
	private int getIndex(Criatura c) throws CriaturaInvalidaException{
		int retorno = -1;
		for (int i = 0; i < this.criaturas.size() && retorno==-1; i++) {
			if (criaturas.get(i).getNome().contentEquals(c.getNome())) {
				retorno = i;
			}
		}
		if(retorno == -1) {
			throw new CriaturaInvalidaException("Criatura não existe") ;
		}
		else {
			return retorno;
		}
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
	
	public List<Criatura> filtrarPorNome(String nome) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		if(nome == null) return null;
		
		for(Criatura c : this.criaturas) {
			if(c.getNome().contains(nome)) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	public List<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public List<Criatura> filtrarPorTipo(Types tipo) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		for(Criatura c : this.criaturas) {
			if(c.getTipo().equals(tipo)) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	public List<Criatura> filtrarPorNivel(double menor, double maior) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		for(Criatura c : this.criaturas) {
			double nivel = c.getNivel();
			if(menor <= nivel && nivel <= maior) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	public List<Criatura> filtrarPorQuemMatou(String nomeJogador){
		List<Criatura> ret = new ArrayList<Criatura>();
		
		for(int i=0; i<this.criaturas.size(); i++) {
			for(int j=0; j<this.criaturas.get(i).getJogadoresQueMataram().size(); j++) {
				if(this.criaturas.get(i).getJogadoresQueMataram().get(j).equals(nomeJogador)) {
					ret.add(this.criaturas.get(i));
					System.out.println("Adicionou na lista de quem matou");
				}
			}
		}
		return ret;
	}
	
	public List<Criatura> filtrarFavoritos(){
		List<Criatura> ret = new ArrayList<Criatura>();
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).isFavorito()) {
				ret.add(this.criaturas.get(i));
				System.out.println("add na lista de favoritos;"+this.criaturas.get(i).getNome());
			}
		}
		return ret;
	}
	
	public List<Criatura> filtrarPorData(LocalDate data){
		List<Criatura> ret = new ArrayList<Criatura>();
	
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).getDataCriação().isEqual(data)) {
				ret.add(this.criaturas.get(i));
			}
		}
		return ret;
	}
	

	
	
	
	
	
}