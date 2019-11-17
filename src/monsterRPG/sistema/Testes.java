package monsterRPG.sistema;

import java.time.LocalDate;


import monsterRPG.sistema.negocio.ControladorSistema;

public class Testes {
	public static void main(String[] args) {
		Criatura primeira = new Criatura(10, 10, 5.5, 10, 10, 40, 0, 0, 0, "Tatu", "Infelizmente vivemos em uma sociedade em que", Types.BESTA);
		Criatura c1 = new Criatura(10, 10, 5.5, 10, 10, 40, 0, 0, 0, "Noé", "Infelizmente vivemos em uma sociedade em que", Types.BESTA);
		Criatura c2 = new Criatura(2,4,5.0,6,7,8,1,3,2, "Fofinho", "lalalalalalala", Types.ABERRAÇAO);
		Criatura c3 = new Criatura(11, 13, 3.5, 0, 1, 4, 3, 2, 1, "Wcorno","ppppppppp", Types.CELESTIAL);
		Criatura c4 = new Criatura(12,4,1.0,3,9,8,0,3,0, "Xuxa", "pararatimbum", Types.ABERRAÇAO);
		Criatura c5 = new Criatura(23, 30, 15.55, 16, 10, 14, 80, 90, 80, "Ordnael", "Nessa bagaça", Types.BESTA);
		Criatura c6 = new Criatura(20,40,5.9,60,70,80,10,30,20, "Kaique", "eu vou eu vou pra casa agr eu vou", Types.ABERRAÇAO);
		
		ControladorSistema controlador = ControladorSistema.GetInstance();
		try {
			controlador.adicionarCriatura(primeira);
			controlador.adicionarCriatura(c1);
			controlador.adicionarCriatura(c2);
			controlador.adicionarCriatura(c3);
			controlador.adicionarCriatura(c4);
			controlador.adicionarCriatura(c5);
			controlador.adicionarCriatura(c6);
		} catch (CriaturaInvalidaException e) {
			// TODO Auto-generated catch block
			System.out.println("DEU MERDA EM ADD CRIATURA!");
		}
		System.out.println("Nome do bicho criado: " + primeira.getNome());
		System.out.println("Nome do bicho criado: " + c1.getNome());
		System.out.println("Nome do bicho criado: " + c2.getNome());
		System.out.println("Nome do bicho criado: " + c3.getNome());
		System.out.println("Nome do bicho criado: " + c4.getNome());
		System.out.println("Nome do bicho criado: " + c5.getNome());
		System.out.println("Nome do bicho criado: " + c6.getNome());
		
		System.out.println("Size do pesquisar por nome: " + controlador.filtrarPorNome("Ordnael").size());
		
System.out.println("Size do pesquisar por nome: " + controlador.filtrarPorNome("Ordnael").size());
		
		c1.adicionarMortePeloJogador("Ordnael");
		c5.adicionarMortePeloJogador("Ordnael");
		c3.adicionarMortePeloJogador("Ordnael");
		c2.adicionarMortePeloJogador("Ordnael");
		
		c1.setDataCriação(LocalDate.of(2003, 6, 13));
		c2.setDataCriação(LocalDate.of(2005, 2, 1));
		c3.setDataCriação(LocalDate.of(2001, 1, 11));
		c4.setDataCriação(LocalDate.of(2000, 3, 1));
		c5.setDataCriação(LocalDate.of(2018, 7, 2));
		c6.setDataCriação(LocalDate.of(2015, 6, 6));
		
		
		c1.adicionarMortePeloJogador("Abigail");
		c1.adicionarMortePeloJogador("Clodovico");
		c1.adicionarMortePeloJogador("Gastrovil");
		c1.adicionarMortePeloJogador("Normas");
		c1.adicionarMortePeloJogador("Bariula");
		c1.adicionarMortePeloJogador("Clovis");
		
		c1.removerMortePeloJogador("Abigail");
		c1.removerMortePeloJogador("Clovis");
		c1.removerMortePeloJogador("Normas");
		c1.removerMortePeloJogador("Abigail");
		
		c1.printarJogadores();
		System.out.println("\nFav: " + controlador.filtrarFavoritos(controlador.getCriaturas()));
		System.out.println("Quem matou: " + controlador.filtrarPorQuemMatou("Ordnael"));
		System.out.println("Nomes em ordem alfabetica: "+ controlador.ordenarNomesDoRepositorioPorOrdemAlfabetica());
		System.out.println("Nomes em ordem alfabetica reverse: " + controlador.ordenarNomesDoRepositorioPorOrdemAlfabeticaReverse());
		System.out.println("Datas crescente: " + controlador.ordenarDatasDoRepositorioCrescente());
		System.out.println("Datas decrescente: " + controlador.ordenarDatasDoRepositorioDecrescente());
		System.out.println("Monstros criados entre 15/1/2001 e 3/12/2015: " + controlador.filtrarCriaturasCriadasEntreDuasDatas(LocalDate.of(2001, 1, 15), LocalDate.of(2015, 12, 3)));
	}
}
