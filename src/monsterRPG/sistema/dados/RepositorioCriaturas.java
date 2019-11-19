package monsterRPG.sistema.dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.*;

import monsterRPG.sistema.ComparadorNomes;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Historico;
import monsterRPG.sistema.Types;


public class RepositorioCriaturas {
	private List<Criatura> criaturas;
	private Historico historico;
	
	public RepositorioCriaturas() {
		this.criaturas = new ArrayList<Criatura>();
		historico = new Historico();
		historico.carregarTodosArquivosHistorico();
	}
	
	public List<String> pegarCriaturasAdicionadasHistorico() {
		return historico.pegarCriaturasAdicionadasHistorico();
	}

	public List<String> pegarCriaturasRemovidasHistorico() {
		return historico.pegarCriaturasRemovidasHistorico();
	}

	public List<String> pegarCriaturasEditadasHistorico() {
		return historico.pegarCriaturasEditadasHistorico();
	}

	public List<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public void editarCriatura(Criatura antiga, Criatura nova) throws CriaturaInvalidaException{
		nova.setFavorito(antiga.isFavorito());
		int i = getIndex(antiga);
		removerCriatura(antiga);
		this.criaturas.add(i, nova);
		historico.adicionarNoHistoricoEditadas(nova);
		historico.salvarArquivoHistoricoEditadas();
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
			historico.adicionarNoHistoricoAdicionadas(c);
			historico.salvarArquivoHistoricoAdicionadas();
		} catch (NullPointerException e) {
			throw new CriaturaInvalidaException("Criatura criada não pode ser vazia. SEU ANIMAL!");
		}
	}
	
	public void removerCriatura(Criatura c) throws CriaturaInvalidaException {
		try {
			this.criaturas.remove(c);
			historico.adicionarNoHistoricoRemovidas(c);
			historico.carregarArquivoHistoricoRemovidas();
		} catch (NullPointerException e) {
			throw new CriaturaInvalidaException("Rapaz, n sei oq tu fez, mas fudeu!");
		}
	}
	
	public List<Criatura> filtrarPorNome(String nome) {
		nome = nome.toUpperCase();
		List<Criatura> ret = new ArrayList<Criatura>();
		
		if(nome == null) return null;
		
		for(Criatura c : this.criaturas) {
			if(c.getNome().toUpperCase().contains(nome)) {
				ret.add(c);
			}
		}
		return ret;
	}
	
	

	public void salvarTodosArquivosHistorico() {
		historico.salvarTodosArquivosHistorico();
	}

	public void carregarTodosArquivosHistorico() {
		historico.carregarTodosArquivosHistorico();
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
				}
			}
		}
		return ret;
	}
	
	public List<Criatura> filtrarFavoritos(List<Criatura> aux){
		List<Criatura> ret = new ArrayList<Criatura>();
		for(int i=0; i<aux.size(); i++) {
			if(aux.get(i).isFavorito()) {
				ret.add(aux.get(i));
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
	
	public List<Criatura> filtrarCriaturasCriadasEntreDuasDatas(LocalDate inicio, LocalDate fim){
		List<Criatura> ret = new ArrayList<Criatura>();
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).getDataCriação().isAfter(inicio)&&this.criaturas.get(i).getDataCriação().isBefore(fim)) {
				ret.add(this.criaturas.get(i));
			}
		}
		return ret;
	}
	
	public List<Criatura> ordenarNomesDoRepositorioPorOrdemAlfabetica(){
		Collections.sort(this.criaturas, new ComparadorNomes());
		return this.criaturas;
	}
	
	public List<Criatura> ordenarNomesPorOrdemAlfabeticaComParametro(List<Criatura> listaCriaturas){
		Collections.sort(listaCriaturas, new ComparadorNomes());
		return listaCriaturas;
	}

	public List<Criatura> ordenarNomesDoRepositorioPorOrdemAlfabeticaReverse(){
		List<Criatura> ret = this.ordenarNomesDoRepositorioPorOrdemAlfabetica();
		Collections.reverse(ret);
		return ret;
	}
	
	public List<Criatura> ordenarNomesPorOrdemAlfabeticaComParametroReverse(List<Criatura> listaCriaturas){
		List<Criatura> ret = ordenarNomesPorOrdemAlfabeticaComParametro(listaCriaturas);
		Collections.reverse(ret);
		return ret;
	}
	
	public List<Criatura> ordenarDatasCrescenteDoRepositorio(){
		Collections.sort(this.criaturas, new ComparadorDatas());
		return this.criaturas;
	}
	
	public List<Criatura> ordenarDatasCrescenteComParametro(List<Criatura> listaCriaturas){
		Collections.sort(listaCriaturas, new ComparadorDatas());
		return listaCriaturas;
	}
	
	public List<Criatura> ordenarDatasDecrescenteDoRepositorio(){
		Collections.sort(this.criaturas, new ComparadorDatas().reversed());
		return this.criaturas;
	}
	
	public List<Criatura> ordenarDatasDecrescenteComParametro(List<Criatura> listaCriaturas){
		Collections.sort(listaCriaturas, new ComparadorDatas().reversed());
		return listaCriaturas;
	}
	
	public Criatura procurarPorCriaturaPorUmNome(String nomeCriatura){
		for(int i=0; i<this.criaturas.size(); i++) {
			if(this.criaturas.get(i).getNome().contains(nomeCriatura)) {
				return this.criaturas.get(i);
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void carregar() {
		try {
			FileInputStream fis = new FileInputStream("RepoCriaturas.hnf");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.criaturas = (List<Criatura>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Criando novo arquivo");
			alert.setHeaderText("Novo arquivo de repositório criados!");
			alert.setContentText("Como não foi possível encontrar um arquivo existente na sua máquina, um novo foi criado.");
			alert.showAndWait();
		}
	}
	
	
	public void salvar() {
		try {
			FileOutputStream fos = new FileOutputStream("RepoCriaturas.hnf");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.criaturas);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void carregar(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.criaturas = (List<Criatura>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.criaturas);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}