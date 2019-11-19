package monsterRPG.gui.menu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import monsterRPG.sistema.negocio.ControladorSistema;

public class HistoricoDialogController {
	ControladorSistema controlador = ControladorSistema.GetInstance();
	
    @FXML
    private TextArea textAreaCriados;

    @FXML
    private TextArea textAreaEditados;

    @FXML
    private TextArea textAreaRemovidos;
    
    @FXML
    void initialize() {
    	textAreaCriados.setText("ADICIONADOS");
    	textAreaEditados.setText("EDITADOS");
    	textAreaRemovidos.setText("REMOVIDOS");
    }

}
