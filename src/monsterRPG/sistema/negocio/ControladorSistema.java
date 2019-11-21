package monsterRPG.sistema.negocio;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.MesaInvalidaException;
import monsterRPG.sistema.Types;
import monsterRPG.sistema.dados.RepositorioCriaturas;
import monsterRPG.sistema.dados.RepositorioMesas;
import monsterRPG.sistema.dados.RepositorioNotas;
import monsterRPG.sistema.usuario.Mesa;
import monsterRPG.sistema.usuario.Nota;

public class ControladorSistema {
	private RepositorioCriaturas repositCriaturas;
	private RepositorioMesas repositMesa;
	private RepositorioNotas repositNotas;
	private Criatura criaturaAux;
	private String jogadorParaAdd;
	private String jogadorParaEditar;
	private String jogadorAuxiliar;
	
	
	public File getFileRepositorioAtual() {
		return this.repositCriaturas.getFileRepositorioAtual();
	}
	public void setFileRepositorioAtual(File fileRepositorioAtual) {
		this.repositCriaturas.setFileRepositorioAtual(fileRepositorioAtual);
	}
	public List<Mesa> pesquisarMesasComNome(String nome) {
		return repositMesa.pesquisarMesasComNome(nome);
	}
	public List<Mesa> getMesas() {
		return repositMesa.getMesas();
	}
	public String getJogadorAuxiliar() {
		return jogadorAuxiliar;
	}
	public void setJogadorAuxiliar(String jogadorAuxiliar) {
		this.jogadorAuxiliar = jogadorAuxiliar;
	}
	public String getJogadorParaAdd() {
		return jogadorParaAdd;
	}
	public void setJogadorParaAdd(String jogadorAux) {
		this.jogadorParaAdd = jogadorAux;
		
	}
	public String getJogadorParaEditar() {
		return jogadorParaEditar;
	}
	public void setJogadorParaEditar(String jogadorAux) {
		this.jogadorParaEditar = jogadorAux;
		if (getFileRepositorioAtual() == null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
		
	}
	public void editarCriatura(Criatura antiga, Criatura nova) throws CriaturaInvalidaException {
		repositCriaturas.editarCriatura(antiga, nova);
		if (getFileRepositorioAtual()==null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public Criatura getCriaturaAux() {
		return criaturaAux;
	}
	public void setCriaturaAux(Criatura criaturaAux) {
		this.criaturaAux = criaturaAux;
	}
	public List<Criatura> getCriaturas() {
		return repositCriaturas.getCriaturas();
	}
	public void setCriaturas(List<Criatura> criaturas) {
		repositCriaturas.setCriaturas(criaturas);
		if (getFileRepositorioAtual() == null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public static ControladorSistema Instancia= new ControladorSistema();
	public static ControladorSistema GetInstance() {
		return Instancia;
	}
	private ControladorSistema() {
		this.repositCriaturas = new RepositorioCriaturas();
		carregar();
		this.repositMesa = new RepositorioMesas();
		this.repositNotas = new RepositorioNotas();
		try {
			this.repositNotas.carregarNotas();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<String> getJogadoresMesa(String mesa) {
		return repositMesa.getJogadoresMesa(mesa);
	}
	public List<String> pegarCriaturasAdicionadasHistorico() {
		return repositCriaturas.pegarCriaturasAdicionadasHistorico();
	}
	public List<String> pegarCriaturasRemovidasHistorico() {
		return repositCriaturas.pegarCriaturasRemovidasHistorico();
	}
	public List<String> pegarCriaturasEditadasHistorico() {
		return repositCriaturas.pegarCriaturasEditadasHistorico();
	}
	public void adicionarCriatura(Criatura c) throws CriaturaInvalidaException {
		repositCriaturas.adicionarCriatura(c);
		if (getFileRepositorioAtual() == null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public void removerCriatura(Criatura c) throws CriaturaInvalidaException {
		repositCriaturas.removerCriatura(c);
		if (getFileRepositorioAtual() == null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public List<Criatura> filtrarPorNome(String nome) {
		return repositCriaturas.filtrarPorNome(nome);
	}
	public List<Criatura> filtrarPorTipo(Types tipo) {
		return repositCriaturas.filtrarPorTipo(tipo);
	}
	public List<Criatura> filtrarPorNivel(double menor, double maior) {
		return repositCriaturas.filtrarPorNivel(menor, maior);
	}
	public List<Criatura> filtrarFavoritos(List<Criatura> aux){
		return repositCriaturas.filtrarFavoritos(aux);
	}
	public List<Criatura> filtrarPorQuemMatou(String j){
		return repositCriaturas.filtrarPorQuemMatou(j);
	}
	public void carregar() {
		if (getFileRepositorioAtual() == null)repositCriaturas.carregar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public void adicionarMesa(Mesa mesa) throws MesaInvalidaException {
		repositMesa.adicionarMesa(mesa);
	}
	public void removerMesa(Mesa mesa) throws MesaInvalidaException {
		repositMesa.removerMesa(mesa);
	}
	public void editarMesa(Mesa mesa, Mesa nova) throws MesaInvalidaException {
		repositMesa.editarMesa(mesa, nova);
	}
	public void salvar() {
		if (getFileRepositorioAtual() == null)repositCriaturas.salvar();
		else repositCriaturas.salvar(getFileRepositorioAtual());
	}
	public void carregar(File path) {
		repositCriaturas.carregar(path);
	}
	public void salvar(File path) {
		repositCriaturas.salvar(path);
	}
	public List<Criatura> filtrarPorData(LocalDate j){
		return repositCriaturas.filtrarPorData(j);
	}
	public List<Criatura> ordenarNomesDoRepositorioPorOrdemAlfabetica(){
		return repositCriaturas.ordenarNomesDoRepositorioPorOrdemAlfabetica();
	}
	public List<Criatura> ordenarNomesPorOrdemAlfabeticaComParametro(List<Criatura> listaCriaturas){
		return repositCriaturas.ordenarNomesPorOrdemAlfabeticaComParametro(listaCriaturas);
	}
	public List<Criatura> ordenarNomesDoRepositorioPorOrdemAlfabeticaReverse(){
		return repositCriaturas.ordenarNomesDoRepositorioPorOrdemAlfabeticaReverse();
	}
	public List<Criatura> ordenarNomesPorOrdemAlfabeticaComParametroReverse(List<Criatura> listaCriaturas){
		return repositCriaturas.ordenarNomesPorOrdemAlfabeticaComParametroReverse(listaCriaturas);
	}
	public List<Criatura> ordenarDatasDoRepositorioCrescente(){
		return repositCriaturas.ordenarDatasCrescenteDoRepositorio();
	}
	public List<Criatura> ordenarDatasCrescenteComParametro(List<Criatura> listaCriaturas){
		return repositCriaturas.ordenarDatasCrescenteComParametro(listaCriaturas);
	}
	public List<Criatura> ordenarDatasDoRepositorioDecrescente(){
		return repositCriaturas.ordenarDatasDecrescenteDoRepositorio();
	}
	public List<Criatura> ordenarDatasDecrescenteComParametro(List<Criatura> listaCriaturas){
		return repositCriaturas.ordenarDatasDecrescenteComParametro(listaCriaturas);
	}
	public Criatura procurarPorCriaturaPorUmNome(String nomeCriatura){
		return repositCriaturas.procurarPorCriaturaPorUmNome(nomeCriatura);
	}
	public List<Criatura> filtrarCriaturasCriadasEntreDuasDatas(LocalDate inicio, LocalDate fim){
		return repositCriaturas.filtrarCriaturasCriadasEntreDuasDatas(inicio, fim);
	}
	public void salvarTodosArquivosHistorico() {
		repositCriaturas.salvarTodosArquivosHistorico();
	}
	public void carregarTodosArquivosHistorico() {
		repositCriaturas.carregarTodosArquivosHistorico();
	}
	public List<Nota> getNotas() {
		return repositNotas.getNotas();
	}
	public void salvarNotas() {
		try {
			this.repositNotas.salvarNotas();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void carregarNotas() {
		try {
			this.repositNotas.carregarNotas();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
