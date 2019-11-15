package monsterRPG.gui;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import monsterRPG.gui.menu.controller.MenuPrincipalPaneController;
import monsterRPG.sistema.negocio.ControladorSistema;
public class MonsterRPG extends Application{
	private Stage estagio;
	
	private Scene cenaMain;
	private Scene cenaEditar;
	private Scene cenaCriar;
	@Override
	public void start(Stage primaryStage) {
		estagio = primaryStage;
		try {
			
			Parent rootMain = FXMLLoader.load(getClass().getResource("menu/view/MenuPrincipal.fxml"));
			cenaMain = new Scene(rootMain);
			
			Parent rootCriar = FXMLLoader.load(getClass().getResource("menu/view/NovaDialog.fxml"));
			cenaCriar = new Scene(rootCriar);
			
			primaryStage.setTitle("MonsterRPG 1.0");
			primaryStage.setScene(cenaMain);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	@FXML
	public void abrirNovoMonstroDialog() {
		estagio.setScene(cenaCriar);
	}

}
