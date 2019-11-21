package monsterRPG.gui.menu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.negocio.ControladorSistema;

public class MesaDialogController {
	ControladorSistema controlador = ControladorSistema.GetInstance();
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
    void Pesquisar() {

    }

    @FXML
    void addMesa() {

    }

    @FXML
    void editMesa() {

    }

    @FXML
    void pesquisar() {

    }

    @FXML
    void removeMesa() {

    }

}
