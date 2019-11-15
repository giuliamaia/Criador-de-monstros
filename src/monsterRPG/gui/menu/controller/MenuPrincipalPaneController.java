package monsterRPG.gui.menu.controller;

import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.negocio.ControladorSistema;

public class MenuPrincipalPaneController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private Criatura criaturaSelecionada;
	@FXML
	private Label labelNomeMonstro;
	@FXML
	private ToggleButton buttonFavorito;
	@FXML
	private Image imagem;
    @FXML
    private TextField barraDePesquisa;
	@FXML
	public void Pesquisar() {
		String pesquisa = "Ordnael";
		List<Criatura> criaturas = controlador.listarPorNome(pesquisa);
		
	}
	public void isBotaoFavoritoPressed() {
		
		try{
			criaturaSelecionada.setFavorito(buttonFavorito.isPressed());
		}catch(NullPointerException e) {
			buttonFavorito.setSelected(false);
			System.out.println("Criatura deve ser valida");
		}
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
		
	}
	public void ordenarPorMortos() {
		//TODO ordenar
	}
	public void ordenarPorFavoritos() {
		//TODO ordenar
	}
	public boolean editCriatura() {
		//TODO adicionar
		return true;
	}
	public boolean removeCriatura() {
		//TODO remover
		return true;
	}
	@FXML
	public boolean addCriatura() {
		monsterRPG.abrirNovoMonstroDialog();
		
		
		
		
		return true;
	}
	public void atualizarLista() {
		//TODO atualizar
	}
	public void inicializar() {
		//TODO inicializar
		
	}
}
