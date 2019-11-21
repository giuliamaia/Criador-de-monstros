package monsterRPG.gui.menu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;

public class MesaDialogController {
	MonsterRPG monsterRPG = new MonsterRPG();
    @FXML
    private Button buttonRemoverMesa;

    @FXML
    private Button buttonEditMesa;

    @FXML
    private ListView<?> listMesas;

    @FXML
    private TextField tfPesquisarNomeMesa;

    @FXML
    private TextArea taNomeMesa;

    @FXML
    private TextArea taDescricaoMesa;

    @FXML
    private ListView<?> listJogadores;

    @FXML
    private ListView<?> listMonstros;

    @FXML
    private ListView<?> listNotas;

    @FXML
    private ComboBox<?> cbOrdenar;

    @FXML
    private Button buttonAddMesa;

    @FXML
    private Button verNotas;

    @FXML
    void Pesquisar() {

    }

    @FXML
    void abrirAddMesa() {
    	monsterRPG.abrirEditarJogadorDialog();
    }

    @FXML
    void abrirEditMesa() {
    	monsterRPG.abrirEditarJogadorDialog();
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

}
