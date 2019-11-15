package monsterRPG.gui.menu.controller;

import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuPrincipalPaneController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private List<Criatura> listaLocal = controlador.getCriaturas();
    @FXML
    private Font x1;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private ListView<Criatura> lvLista;

    @FXML
    private ImageView fotoDoBicho;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
	private Criatura criaturaSelecionada;
	@FXML
	private Label labelNomeMonstro;
	@FXML
	private ToggleButton buttonFavorito;
	@FXML
	private Image imagem;

	@FXML
	public void Pesquisar() {
		System.out.println(barraDePesquisa.getText());
		listaLocal = controlador.listarPorNome(barraDePesquisa.getText());
		atualizarLista();
	}
	public void isBotaoFavoritoPressed() {
		
		try{
			criaturaSelecionada.setFavorito(buttonFavorito.isPressed());
		}catch(NullPointerException e) {
			buttonFavorito.setSelected(false);
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum monstro para favoritar");
			alerta.setHeaderText("Nenhum monstro selecionado");
			alerta.setTitle("Error 404: Monstro não encontrado");
			alerta.showAndWait();
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
	public void addCriatura() {
		monsterRPG.abrirNovoMonstroDialog();
		listaLocal = controlador.getCriaturas();
		Pesquisar();
	}
	public void atualizarLista() {
		lvLista.setItems(FXCollections.observableList(listaLocal));
	}
	public void initialize() {
		atualizarLista();
		
	}

}
