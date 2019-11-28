package monsterRPG.gui.menu.controller;

import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Nota;

public class NotasDialogController {
	MonsterRPG monsterRPG = new MonsterRPG();
    ControladorSistema controlador = ControladorSistema.GetInstance();
    private List<Nota> listaLocalNotas = controlador.getNotas();
    private Nota notaSelecionada = null;
	private HashMap<String, String> notaSelecionada2;
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
    	System.out.println("boa noite meu consagrado e tocar a musiquinha tananantanana");
    	atualizarLista();
    }
    
    @FXML
    public void selecionarNota() {
    	notaSelecionada = listNotas.getSelectionModel().getSelectedItem();
    	if(notaSelecionada != null) {
        	txConteudoNota.setText(notaSelecionada.getConteudo());
        	txTituloNota.setText(notaSelecionada.getTitulo());
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
    }
    

}
