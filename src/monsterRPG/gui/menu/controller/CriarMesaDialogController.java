package monsterRPG.gui.menu.controller;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import monsterRPG.sistema.Criatura;

public class CriarMesaDialogController {

    @FXML
    private TextField txNomeJogador;

    @FXML
    private TextField txDescricao;

    @FXML
    private ListView<String> listJogadoresAdicionados;

    @FXML
    private ListView<Criatura> ListMonstrosAdicionados;

    @FXML
    private ListView<HashMap<String, String>> listNotasAdicionadas;

    @FXML
    private ComboBox<Criatura> cbEscolhaMonstro;

    @FXML
    private TextField txNomeNota;

    @FXML
    private TextField txNomeMesa;

    @FXML
    private TextField txConteudoNota;

    @FXML
    void addCriatura() {

    }

    @FXML
    void addJogador() {

    }

    @FXML
    void addNota() {
    	if(txNomeNota.getText().isEmpty()) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Nota não pode ser adicionada!");
    		alerta.setHeaderText("Notas sem título não podem ser adicionadas.");
    		alerta.setContentText("Coloque um título na nota.");
    		alerta.showAndWait();
    	}
    	else {
    		
    	}
    }

}
