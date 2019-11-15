package monsterRPG.sistema.dados;

import java.time.LocalDate;

public class Testes {
	public static void main(String[] args) {
		Criatura c1 = new Criatura(10, 10, 5.5, 10, 10, 40, 0, 0, 0, "Ordnael", "Infelizmente vivemos em uma sociedade em que", Types.BESTA, true);
		Criatura c2 = new Criatura(2,4,5.0,6,7,8,1,3,2, "Fofinho", "lalalalalalala", Types.ABERRAÇAO, false);
		Criatura c3 = new Criatura(11, 13, 3.5, 0, 1, 4, 3, 2, 1, "Corno","ppppppppp", Types.CELESTIAL, true);
		Criatura c4 = new Criatura(12,4,1.0,3,9,8,0,3,0, "Fofuxo", "pararatimbum", Types.ABERRAÇAO, false);
		Criatura c5 = new Criatura(23, 30, 15.55, 16, 10, 14, 80, 90, 80, "Ordem", "Nessa bagaça", Types.BESTA, true);
		Criatura c6 = new Criatura(20,40,5.9,60,70,80,10,30,20, "Kaique", "eu vou eu vou pra casa agr eu vou", Types.ABERRAÇAO, false);
		
		RepositorioCriaturas reposit = new RepositorioCriaturas();
		try {
			reposit.adicionarCriatura(c1);
			reposit.adicionarCriatura(c2);
			reposit.adicionarCriatura(c3);
			reposit.adicionarCriatura(c4);
			reposit.adicionarCriatura(c5);
			reposit.adicionarCriatura(c6);
		} catch (CriaturaInvalidaException e) {
			// TODO Auto-generated catch block
			System.out.println("DEU MERDA EM ADD CRIATURA!");
		}
		
		System.out.println("Nome do bicho criado: " + c1.getNome());
		System.out.println("Nome do bicho criado: " + c2.getNome());
		System.out.println("Nome do bicho criado: " + c3.getNome());
		System.out.println("Nome do bicho criado: " + c4.getNome());
		System.out.println("Nome do bicho criado: " + c5.getNome());
		System.out.println("Nome do bicho criado: " + c6.getNome());
		
		System.out.println("Size do pesquisar por nome: " + reposit.filtrarPorNome("Ordnael").size());
		
		c1.adicionarMortePeloJogador("Ordnael");
		c5.adicionarMortePeloJogador("Ordnael");
		c3.adicionarMortePeloJogador("Ordnael");
		c2.adicionarMortePeloJogador("Ordnael");
		
		System.out.println(reposit.filtrarFavoritos());
		System.out.println(reposit.filtrarPorQuemMatou("Ordnael"));
		
		System.out.println(c1.getDataCriação());
		System.out.println(c2.getDataCriação());
		System.out.println(c3.getDataCriação());
		System.out.println(c4.getDataCriação());
		System.out.println(c5.getDataCriação());
		System.out.println(c6.getDataCriação());
		
		c1.setDataCriação(LocalDate.of(2019,3,15));
		c2.setDataCriação(LocalDate.of(2019,4,1));
		c3.setDataCriação(LocalDate.of(2019,5,25));
		c4.setDataCriação(LocalDate.of(2019,6,5));
		System.out.println("Ordem Crescente de datas:");
		System.out.println(reposit.OrdenarPorDataCrescente());
		System.out.println("Decrescente:");
		System.out.println(reposit.OrdenarPorDataDecrescente());
	}
}
