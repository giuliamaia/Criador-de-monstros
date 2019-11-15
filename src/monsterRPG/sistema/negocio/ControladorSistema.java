package monsterRPG.sistema.negocio;

import java.util.List;

import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Types;
import monsterRPG.sistema.dados.RepositorioCriaturas;
import monsterRPG.sistema.dados.RepositorioMesas;

public class ControladorSistema {
	private RepositorioCriaturas repositCriaturas;
	private RepositorioMesas repositMesa;
	private Criatura criaturaSelecionada;
	public Criatura getCriaturaSelecionada() {
		return criaturaSelecionada;
	}
	public void setCriaturaSelecionada(Criatura criaturaSelecionada) {
		this.criaturaSelecionada = criaturaSelecionada;
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
	public List<Criatura> listarPorNome(String nome) {
		return repositCriaturas.listarPorNome(nome);
	}
	public List<Criatura> listarPorTipo(Types tipo) {
		return repositCriaturas.listarPorTipo(tipo);
	}
	public List<Criatura> listarPorNivel(double menor, double maior) {
		return repositCriaturas.listarPorNivel(menor, maior);
	}
	
}
