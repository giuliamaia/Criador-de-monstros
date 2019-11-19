package monsterRPG.gui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class MonsterRPG extends Application{
	private static Stage estagio;
	
	private static Scene cenaMain;
	private static Scene cenaEditar;
	private static Scene cenaCriar;
	private static Stage dialogStageCriar;
	private static Stage dialogStageEditar;
	private static Scene cenaEditarJogador;
	private static Scene cenaCriarJogador;
	private static Stage dialogStageCriarJogador;
	private static Stage dialogStageEditarJogador;
	@Override
	public void start(Stage primaryStage) {
		try {
			estagio = primaryStage;
			Parent rootMain = FXMLLoader.load(getClass().getResource("menu/view/MenuPrincipal.fxml"));
			cenaMain = new Scene(rootMain);
			
			
			primaryStage.setTitle("MonsterRPG 1.0");
			primaryStage.setScene(cenaMain);
			primaryStage.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	@FXML
	public void abrirNovoJogadorDialog() {
        AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane)  FXMLLoader.load(getClass().getResource("menu/view/NovoJogadorDialog.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dialogStageCriarJogador = new Stage();
        dialogStageCriarJogador.setTitle("Novo Jogador");
        dialogStageCriarJogador.initModality(Modality.WINDOW_MODAL);
        dialogStageCriarJogador.initOwner(estagio);
        cenaCriarJogador = new Scene(conteudoDialog);
        dialogStageCriarJogador.setScene(cenaCriarJogador);
        dialogStageCriarJogador.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
        dialogStageCriarJogador.showAndWait();
	}
	@FXML
	public void abrirEditarJogadorDialog() {
        AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane)  FXMLLoader.load(getClass().getResource("menu/view/EditJogadorDialog.fxml"));

			dialogStageEditarJogador = new Stage();
	        dialogStageEditarJogador.setTitle("Editar Monstro");
	        dialogStageEditarJogador.initModality(Modality.WINDOW_MODAL);
	        dialogStageEditarJogador.initOwner(estagio);
	        cenaEditarJogador = new Scene(conteudoDialog);
	        dialogStageEditarJogador.setScene(cenaEditarJogador);
	        dialogStageEditarJogador.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
	        dialogStageEditarJogador.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
        dialogStageCriar.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
        dialogStageCriar.showAndWait();
	}
	@FXML
	public void abrirEditarMonstroDialog() {
        AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane)  FXMLLoader.load(getClass().getResource("menu/view/EditDialog.fxml"));

			dialogStageEditar = new Stage();
	        dialogStageEditar.setTitle("Editar Monstro");
	        dialogStageEditar.initModality(Modality.WINDOW_MODAL);
	        dialogStageEditar.initOwner(estagio);
	        cenaEditar = new Scene(conteudoDialog);
	        dialogStageEditar.setScene(cenaEditar);
	        dialogStageEditar.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
	        dialogStageEditar.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void fecharNovoMonstroDialog() {
		dialogStageCriar.close();
	}
	public void fecharNovoJogadorDialog() {
		dialogStageCriarJogador.close();
	}
	public void fecharEditarMonstroDialog() {
		dialogStageEditar.close();
	}
	public void fecharEditarJogadorMonstroDialog() {
		dialogStageEditarJogador.close();
	}
}
