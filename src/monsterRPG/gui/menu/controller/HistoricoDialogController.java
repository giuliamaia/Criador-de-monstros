package monsterRPG.gui.menu.controller;

import java.util.List;

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
		textAreaCriados.setText(formatHistorico(controlador.pegarCriaturasAdicionadasHistorico()));
		textAreaEditados.setText(formatHistorico(controlador.pegarCriaturasEditadasHistorico()));
		textAreaRemovidos.setText(formatHistorico(controlador.pegarCriaturasRemovidasHistorico()));
	}

	private String formatHistorico(List<String> lista) {
		String ret = "";

		for (String criatura : lista) {
			ret += criatura + "\n";
		}

		return ret;
	}

}
