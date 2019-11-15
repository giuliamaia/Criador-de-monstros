package monsterRPG.gui.menu.controller;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.sistema.Types;
public class NovaContaDialogController {

    @FXML
    private TextField txNome;

    @FXML
    private ComboBox<Types> escolhaDeTipo;

    @FXML
    private TextField txCarisma;

    @FXML
    private TextField txVida;

    @FXML
    private TextField txDefesa;

    @FXML
    private TextField txNivel;

    @FXML
    private TextField txForca;

    @FXML
    private TextField txDestreza;

    @FXML
    private TextField txConstituicao;

    @FXML
    private TextField txInteligencia;

    @FXML
    private TextField txSabedoria;

    @FXML
    private TextArea txDescricao;
}
