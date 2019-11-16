package monsterRPG.sistema.negocio;

import java.time.LocalDate;
import java.util.List;

import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Types;
import monsterRPG.sistema.dados.RepositorioCriaturas;
import monsterRPG.sistema.dados.RepositorioMesas;

public class ControladorSistema {
	private RepositorioCriaturas repositCriaturas;
	private RepositorioMesas repositMesa;
	
	public List<Criatura> getCriaturas() {
		return repositCriaturas.getCriaturas();
	}
	public void setCriaturas(List<Criatura> criaturas) {
		repositCriaturas.setCriaturas(criaturas);
	}
	public static ControladorSistema Instancia= new ControladorSistema();
	public static ControladorSistema GetInstance() {
		return Instancia;
	}
	private ControladorSistema() {
		this.repositCriaturas = new RepositorioCriaturas();
		this.repositMesa = new RepositorioMesas();
	}
	public void adicionarCriatura(Criatura c) throws CriaturaInvalidaException {
		repositCriaturas.adicionarCriatura(c);
	}
	public void removerCriatura(Criatura c) throws CriaturaInvalidaException {
		repositCriaturas.removerCriatura(c);
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
	public List<Criatura> filtrarFavoritos(){
		return repositCriaturas.filtrarFavoritos();
	}
	public List<Criatura> filtrarPorQuemMatou(String j){
		return repositCriaturas.filtrarPorQuemMatou(j);
	}
	public List<Criatura> filtrarPorData(LocalDate j){
		return repositCriaturas.filtrarPorData(j);
	}
	
	
}
