package monsterRPG.sistema.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Historico;
import monsterRPG.sistema.Types;
import monsterRPG.sistema.dados.RepositorioCriaturas;
import monsterRPG.sistema.dados.RepositorioMesas;

public class ControladorSistema {
	private RepositorioCriaturas repositCriaturas;
	private RepositorioMesas repositMesa;
	private Criatura criaturaAux;
	private String jogadorParaAdd;
	private String jogadorParaEditar;
	private String jogadorAuxiliar;
	
	
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
		repositCriaturas.salvar();
	}
	public String getJogadorParaEditar() {
		return jogadorParaEditar;
	}
	public void setJogadorParaEditar(String jogadorAux) {
		this.jogadorParaEditar = jogadorAux;
		repositCriaturas.salvar();
	}
	public void editarCriatura(Criatura antiga, Criatura nova) throws CriaturaInvalidaException {
		repositCriaturas.editarCriatura(antiga, nova);
		repositCriaturas.salvar();
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
		repositCriaturas.salvar();
	}
	public static ControladorSistema Instancia= new ControladorSistema();
	public static ControladorSistema GetInstance() {
		return Instancia;
	}
	private ControladorSistema() {
		this.repositCriaturas = new RepositorioCriaturas();
		this.repositCriaturas.carregar();
		this.repositMesa = new RepositorioMesas();
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
		repositCriaturas.salvar();
	}
	public void removerCriatura(Criatura c) throws CriaturaInvalidaException {
		repositCriaturas.removerCriatura(c);
		repositCriaturas.salvar();
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
		repositCriaturas.carregar();
	}
	public void salvar() {
		repositCriaturas.salvar();
	}
	public void carregar(String path) {
		repositCriaturas.carregar(path);
	}
	public void salvar(String path) {
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
	
}
