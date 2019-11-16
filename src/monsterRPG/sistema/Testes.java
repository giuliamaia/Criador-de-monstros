package monsterRPG.sistema;

import java.time.LocalDate;

import monsterRPG.sistema.dados.RepositorioCriaturas;
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
		
		RepositorioCriaturas repo = new RepositorioCriaturas();
		
		/*try {
			repo.adicionarCriatura(primeira);
			repo.adicionarCriatura(c1);
			repo.adicionarCriatura(c2);
			repo.adicionarCriatura(c3);
			repo.adicionarCriatura(c4);
			repo.adicionarCriatura(c5);
			repo.adicionarCriatura(c6);
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		repo.load();
		System.out.println(repo.getCriaturas());
		//repo.save();
	}
}
