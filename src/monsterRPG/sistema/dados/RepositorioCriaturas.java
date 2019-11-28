package monsterRPG.sistema.dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.*;

import monsterRPG.sistema.ComparadorDatas;
import monsterRPG.sistema.ComparadorNomes;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Historico;
import monsterRPG.sistema.Types;


public class RepositorioCriaturas {
	private List<Criatura> criaturas;
	private Historico historico;
	private File fileRepositorioAtual = null;
	
	public File getFileRepositorioAtual() {
		return fileRepositorioAtual;
	}

	public void setFileRepositorioAtual(File fileRepositorioAtual) {
		this.fileRepositorioAtual = fileRepositorioAtual;
	}

	public RepositorioCriaturas() {
		this.criaturas = new ArrayList<Criatura>();
		historico = new Historico();
		historico.carregarTodosArquivosHistorico();
		if(tentaCarregarFileAntigo()) {
			carregar(fileRepositorioAtual);
		}
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
		antiga.setNome(nova.getNome());
		antiga.setDescrição(nova.getDescrição());
		antiga.setTipo(nova.getTipo());
		antiga.setFavorito(nova.isFavorito());
		antiga.setJogadoresQueMataram(nova.getJogadoresQueMataram());
		antiga.setUrlDaFotinha(nova.getUrlDaFotinha());
		antiga.setVida(nova.getVida());
		antiga.setDefesa(nova.getDefesa());
		antiga.setForca(nova.getForca());
		antiga.setDestreza(nova.getDestreza());
		antiga.setConstituicao(nova.getConstituicao());
		antiga.setSabedoria(nova.getSabedoria());
		antiga.setInteligencia(nova.getInteligencia());
		antiga.setCarisma(nova.getCarisma());
		
		historico.adicionarNoHistoricoEditadas(nova);
		historico.salvarArquivoHistoricoEditadas();
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
			historico.salvarArquivoHistoricoRemovidas();
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
			salvarFileAntigo();
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
			salvarFileAntigo();
			FileOutputStream fos = new FileOutputStream("RepoCriaturas.hnf");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.criaturas);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void carregar(File path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.criaturas = (List<Criatura>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(File path) {
		try {
			salvarFileAntigo();
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.criaturas);
			carregar(path);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean tentaCarregarFileAntigo() {
		try {
			carregarFileAntigo();
		} catch (IOException e) {
			return false;
		}
		if (this.fileRepositorioAtual != null && fileRepositorioAtual.exists() && fileRepositorioAtual.canRead()) {
			salvarFileAntigo();
			return true;
		}
		else {
			fileRepositorioAtual = null;
			return false;
		}
	}
	private void carregarFileAntigo() throws IOException {
		 
		try {
			FileInputStream fis = new FileInputStream("SalvadorPath.galonegro");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.fileRepositorioAtual = (File) ois.readObject();
			ois.close();
			
		} catch(Exception e) {
			salvarFileAntigo();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Criando novo arquivo");
			alert.setHeaderText("Foi criado um novo arquivo para o funcionamento normal do programa");
			alert.setContentText("Como não foi possível encontrar um arquivo necessario na sua máquina, um novo foi criado.");
			alert.showAndWait();
		}

	}
	
	public void salvarFileAntigo() {
		try {
			FileOutputStream fos = new FileOutputStream("SalvadorPath.galonegro");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.fileRepositorioAtual);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}