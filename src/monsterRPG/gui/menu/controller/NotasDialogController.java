package monsterRPG.gui.menu.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Nota;
import monsterRPG.sistema.negocio.ControladorSistema;

public class NotasDialogController {
	MonsterRPG monsterRPG = new MonsterRPG();
	ControladorSistema controlador = ControladorSistema.GetInstance();
	private List<Nota> listaLocalNotas = controlador.getNotas();
	private Nota notaSelecionada = null;

	@FXML
	private ListView<Nota> listNotas;

	@FXML
	private TextField procurarNomeNota;

	@FXML
	private TextArea txConteudoNota;

	@FXML
	private TextArea txTituloNota;

	@FXML
	void Pesquisar() {
		listaLocalNotas = controlador.pesquisarNota(procurarNomeNota.getText());
		atualizarLista();
	}

	@FXML
	public void selecionarNota() {
		notaSelecionada = listNotas.getSelectionModel().getSelectedItem();
		if (notaSelecionada != null) {
			txConteudoNota.setText(notaSelecionada.getConteudo());
			txTituloNota.setText(notaSelecionada.getTitulo());
			atualizarLista();
		} else {
			txConteudoNota.setText("");
			txTituloNota.setText("");
			atualizarLista();
		}
	}

	@FXML
	public void atualizarLista() {
		listNotas.setItems(FXCollections.observableList(listaLocalNotas));
	}

	@FXML
	public void initialize() {
		controlador.carregarNotas();
		atualizarLista();
		Pesquisar();
	}

	@FXML
	void removeNota() {
		if (notaSelecionada != null) {
			controlador.removerNota(notaSelecionada.getTitulo());
			atualizarLista();
			Pesquisar();
			txConteudoNota.setText("");
			txTituloNota.setText("");
			atualizarLista();
		}
	}

}
