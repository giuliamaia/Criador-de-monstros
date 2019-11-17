package monsterRPG.gui.menu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.negocio.ControladorSistema;

public class EditJogadorDialogController {
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private MonsterRPG monsterRPG = new MonsterRPG();
    @FXML
    private TextField tfNomeJogador;

    @FXML
    void cancelar() {
    	monsterRPG.fecharEditarJogadorMonstroDialog();
    }

    @FXML
    void submeter() {
    	if (tfNomeJogador.getText().isEmpty()) {
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa digitar algum nome");
			alerta.setHeaderText("Nenhum nome selecionado");
			alerta.setTitle("Error 403: Nome não encontrado");
			alerta.showAndWait();
    	}
    	else {
    		controlador.setJogadorParaEditar(tfNomeJogador.getText());
    		cancelar();
    	}
    }
    
    void initialize() {
    	
    }
}
