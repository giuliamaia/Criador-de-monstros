package monsterRPG.sistema.dados;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RepositorioCriaturas {
	ArrayList<Criatura> criaturas;
	
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
	
	public List<Criatura> filtrarPorNome(String nome) {
		List<Criatura> ret = new ArrayList<Criatura>();
		
		if(nome == null) return null;
		
		for(Criatura c : this.criaturas) {
			if(c.getNome().equals(nome)) {
				ret.add(c);
			}
		}
		return ret;
	}
	//FALTA FAZER
	public List<Criatura> ordenarNomePorOrdemAlfabetica(){
		List<Criatura> ret = new ArrayList<Criatura>();
		for(int i=0; i<this.criaturas.size(); i++) {
			
		}
		return ret;
		
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
	//FALTA FAZER
	public List<Criatura> ordenarPorNivel(){
		List<Criatura> ret = new ArrayList<Criatura>();
		for(int i=0; i<this.criaturas.size(); i++) {
			
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
				System.out.println("add na lista de favoritos");
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
	//ainda vou testar
	public List<Criatura> OrdenarPorDataCrescente(){
		List<Criatura> ret = new ArrayList<Criatura>();
		LocalDate comp = LocalDate.of(1950, 1, 1);
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).getDataCriação().isAfter(comp)) {
				ret.add(this.criaturas.get(i));
				comp = this.criaturas.get(i).getDataCriação();
			}
		}
		return ret;
	}
	//ainda vou testar
	public List<Criatura> OrdenarPorDataDecrescente(){
		List<Criatura> ret = new ArrayList<Criatura>();
		LocalDate comp = LocalDate.now();
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).getDataCriação().equals(comp)) {
				ret.add(this.criaturas.get(i));
			}
			else if(this.criaturas.get(i).getDataCriação().isBefore(comp)) {
				ret.add(this.criaturas.get(i));
				comp = this.criaturas.get(i).getDataCriação();
			}
		}
		return ret;
	}
	
	
	
	
	
	
	
	
}