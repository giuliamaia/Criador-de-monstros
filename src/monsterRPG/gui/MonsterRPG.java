package monsterRPG.gui;

import java.io.IOException;
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
	private static Stage estagio;
	
	private static Scene cenaMain;
	private static Scene cenaEditar;
	private static Scene cenaCriar;
	private static Stage dialogStageCriar;
	@Override
	public void start(Stage primaryStage) {
		try {
			estagio = primaryStage;
			Parent rootMain = FXMLLoader.load(getClass().getResource("menu/view/MenuPrincipal.fxml"));
			cenaMain = new Scene(rootMain);

			
			primaryStage.setTitle("MonsterRPG 1.0");
			primaryStage.setScene(cenaMain);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Sout america nemesis");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	@FXML
	public void abrirNovoMonstroDialog() {
        AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane)  FXMLLoader.load(getClass().getResource("menu/view/NovaDialog.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dialogStageCriar = new Stage();
        dialogStageCriar.setTitle("Novo Monstro");
        dialogStageCriar.initModality(Modality.WINDOW_MODAL);
        dialogStageCriar.initOwner(estagio);
        cenaCriar = new Scene(conteudoDialog);
        dialogStageCriar.setScene(cenaCriar);

        dialogStageCriar.showAndWait();
	}
	public void fecharNovoMonstroDialog() {
		dialogStageCriar.close();
	}
}
