package monsterRPG.gui.menu.controller;

public class MenuPrincipalPaneController {
	private boolean favorito = false;
	
	public void Pesquisar() {
		System.out.println("Funciona para K+1");
		//TODO Pesquisar
	}
	public boolean isBotaoFavoritoPressed() {
		favorito = !favorito;
		System.out.println(favorito);
		return favorito;
	}
	public void ordenarPorDataCrescente() {
		//TODO ordenar
	}
	public void ordenarPorDataDecrescente() {
		//TODO ordenar
	}
	public void ordenarPorNomeCrescente() {
		//TODO ordenar
	}
	public void ordenarPorNomeDecrescente() {
		//TODO ordenar
		System.out.println("Decesce");
	}
	public void ordenarPorMortos() {
		//TODO ordenar
	}
	public void ordenarPorFavoritos() {
		//TODO ordenar
	}
	public boolean addCriatura() {
		//TODO adicionar
		return true;
	}
	public boolean removeCriatura() {
		//TODO remover
		return true;
	}
	public boolean editCriatura() {
		//TODO editar
		return true;
	}
	public void atualizarLista() {
		//TODO atualizar
	}
}
