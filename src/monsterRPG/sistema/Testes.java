package monsterRPG.sistema;

import monsterRPG.sistema.dados.RepositorioCriaturas;
import monsterRPG.sistema.negocio.ControladorSistema;

public class Testes {
	public static void main(String[] args) {
		Criatura primeira = new Criatura(10, 10, 5.5, 10, 10, 40, 0, 0, 0, "Ordnael", "Infelizmente vivemos em uma sociedade em que", Types.Besta, true);
		ControladorSistema controlador = ControladorSistema.GetInstance();
		try {
			controlador.adicionarCriatura(primeira);
		} catch (CriaturaInvalidaException e) {
			// TODO Auto-generated catch block
			System.out.println("DEU MERDA!");
		}
		System.out.println("Nome do bicho criado: " + primeira.getNome());
		System.out.println("Size do pesquisar por nome: " + controlador.listarPorNome("Ordnael").size());
	}
}
