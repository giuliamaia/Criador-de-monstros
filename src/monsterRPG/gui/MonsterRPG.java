package monsterRPG.gui;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MonsterRPG extends Application {
	private static Stage estagio;
	private static Scene cenaMain;
	private static Scene cenaEditar;
	private static Scene cenaCriar;
	private static Scene cenaMesas;
	private static Scene cenaEditarJogador;
	private static Scene cenaCriarJogador;
	private static Scene cenaHistorico;
	private static Scene cenaCriarMesas;
	private static Scene cenaVerNotas;
	private static Scene cenaEditarMesas;
	private static Stage dialogStageCriar;
	private static Stage dialogStageEditar;
	private static Stage dialogStageCriarJogador;
	private static Stage dialogStageEditarJogador;
	private static Stage dialogStageHistorico;
	private static Stage dialogStageMesas;
	private static Stage dialogStageCriarMesas;
	private static Stage dialogStageEditarMesas;
	private static Stage dialogStageVerNotas;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public File abrirEscolhaDeDiretorio(boolean isSave, File caminho) throws IOException {

		FileChooser fc = new FileChooser();

		fc.getExtensionFilters().add(new ExtensionFilter("Arquivos HoNeFo", "*.hnf"));
		File file = null;

		if (isSave) {
			fc.setTitle("Salvar como...");
			if (caminho != null) {
				fc.setInitialDirectory(caminho.getParentFile());
				fc.setInitialFileName(caminho.getName());
			}

			file = fc.showSaveDialog(estagio);
		} else {
			fc.setTitle("Abrir...");
			if (caminho != null) {
				fc.setInitialDirectory(caminho.getParentFile());
			}
			file = fc.showOpenDialog(estagio);
		}
		return file;

	}

	@FXML
	public void abrirNovoJogadorDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/NovoJogadorDialog.fxml"));
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
		dialogStageCriarJogador.getIcons()
				.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
		dialogStageCriarJogador.showAndWait();
	}

	@FXML
	public void abrirEditarJogadorDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/EditJogadorDialog.fxml"));

			dialogStageEditarJogador = new Stage();
			dialogStageEditarJogador.setTitle("Editar Monstro");
			dialogStageEditarJogador.initModality(Modality.WINDOW_MODAL);
			dialogStageEditarJogador.initOwner(estagio);
			cenaEditarJogador = new Scene(conteudoDialog);
			dialogStageEditarJogador.setScene(cenaEditarJogador);
			dialogStageEditarJogador.getIcons()
					.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageEditarJogador.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void abrirNovoMonstroDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/NovaDialog.fxml"));
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
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/EditDialog.fxml"));

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

	@FXML
	public void abrirHistoricoDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/HistoricoDialog.fxml"));
			dialogStageHistorico = new Stage();
			dialogStageHistorico.setTitle("Histórico");
			dialogStageHistorico.initModality(Modality.WINDOW_MODAL);
			dialogStageHistorico.initOwner(estagio);
			cenaHistorico = new Scene(conteudoDialog);
			dialogStageHistorico.setScene(cenaHistorico);
			dialogStageHistorico.getIcons()
					.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageHistorico.showAndWait();
		} catch (IOException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Localização não encontrada");
			alerta.setHeaderText("Arquivo do histórico não foi encontrado");
			alerta.setContentText("Não foi possivel encontrar o arquivo do histórico.");
			alerta.showAndWait();
		}
	}

	public void abrirMesasDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/MesaDialog.fxml"));
			dialogStageMesas = new Stage();
			dialogStageMesas.setTitle("Mesas");
			dialogStageMesas.initModality(Modality.WINDOW_MODAL);
			dialogStageMesas.initOwner(estagio);
			cenaMesas = new Scene(conteudoDialog);
			dialogStageMesas.setScene(cenaMesas);
			dialogStageMesas.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageMesas.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirCriarMesasDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/CriarMesaDialog.fxml"));
			dialogStageCriarMesas = new Stage();
			dialogStageCriarMesas.setTitle("Criar Mesas");
			dialogStageCriarMesas.initModality(Modality.WINDOW_MODAL);
			dialogStageCriarMesas.initOwner(dialogStageMesas);
			cenaCriarMesas = new Scene(conteudoDialog);
			dialogStageCriarMesas.setScene(cenaCriarMesas);
			dialogStageCriarMesas.getIcons()
					.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageCriarMesas.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirEditarMesasDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/EditarMesaDialog.fxml"));
			dialogStageEditarMesas = new Stage();
			dialogStageEditarMesas.setTitle("Editar Mesas");
			dialogStageEditarMesas.initModality(Modality.WINDOW_MODAL);
			dialogStageEditarMesas.initOwner(dialogStageMesas);
			cenaEditarMesas = new Scene(conteudoDialog);
			dialogStageEditarMesas.setScene(cenaEditarMesas);
			dialogStageEditarMesas.getIcons()
					.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageEditarMesas.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirNotasDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(getClass().getResource("menu/view/NotasDialog.fxml"));
			dialogStageVerNotas = new Stage();
			dialogStageVerNotas.setTitle("Ver Notas");
			dialogStageVerNotas.initModality(Modality.WINDOW_MODAL);
			dialogStageVerNotas.initOwner(dialogStageMesas);
			cenaVerNotas = new Scene(conteudoDialog);
			dialogStageVerNotas.setScene(cenaVerNotas);
			dialogStageVerNotas.getIcons()
					.add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			dialogStageVerNotas.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fecharCriarMesasDialog() {
		dialogStageCriarMesas.close();
	}

	public void fecharEditarMesasDialog() {
		dialogStageEditarMesas.close();
	}

	public void fecharVerNotasDialog() {
		dialogStageVerNotas.close();
	}

	public void fecharMesasDialog() {
		dialogStageMesas.close();
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
