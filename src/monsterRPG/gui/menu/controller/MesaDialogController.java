package monsterRPG.gui.menu.controller;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Mesa;

public class MesaDialogController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
    @FXML
    private Button buttonRemoverMesa;

    @FXML
    private Button buttonEditMesa;

    @FXML
    private ListView<Mesa> listMesas;

    @FXML
    private TextField tfPesquisarNomeMesa;

    @FXML
    private TextArea taNomeMesa;

    @FXML
    private TextArea taDescricaoMesa;

    @FXML
    private ListView<String> listJogadores;

    @FXML
    private ListView<String> listMonstros;

    @FXML
    private ListView<HashMap<String, String>> listNotas;

    @FXML
    private ComboBox<String> cbOrdenar;

    @FXML
    private Button buttonAddMesa;

    @FXML
    private Button verNotas;

    @FXML
    void Pesquisar() {

    }
    
    @FXML
    void abrirAddMesa() {
    	monsterRPG.abrirCriarMesasDialog();
    }

    @FXML
    void abrirEditMesa() {
    	monsterRPG.abrirEditarMesasDialog();
    }

    @FXML
    void abrirVerNotasDialog() {
    	monsterRPG.abrirNotasDialog();
    }

    @FXML
    void pesquisar() {

    }

    @FXML
    void removeMesa() {

    }
    
    @FXML
    void setarListaMesas() {
    	listMesas.setItems(FXCollections.observableList(controlador.getMesas()));
    }
    void setarListaJogadores() {
    	//listJogadores.setItems(FXCollections.observableList(controlador.getJogadoresMesa(mesa)));
    }
    void setarListaNotas() {
    	
    }
    void setarListaMonstros() {
    	
    }

}
