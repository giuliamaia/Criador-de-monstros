package monsterRPG.gui.menu.controller;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.Types;
import monsterRPG.sistema.negocio.ControladorSistema;
public class NovaContaDialogController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private Criatura bicho;
	private ControladorSistema controlador = ControladorSistema.GetInstance();
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
    
    
    @FXML
    public void cancelar() {
    	monsterRPG.fecharNovoMonstroDialog();
    }

    @FXML
    public void submeter() {
    	try{
    		bicho = new Criatura(Integer.parseInt(txVida.getText()),Integer.parseInt(txDefesa.getText()),Double.parseDouble(txNivel.getText()),Integer.parseInt(txForca.getText()),Integer.parseInt(txDestreza.getText()),Integer.parseInt(txConstituicao.getText()),Integer.parseInt(txInteligencia.getText()),Integer.parseInt(txSabedoria.getText()),Integer.parseInt(txCarisma.getText()),txNome.getText(), txDescricao.getText(), escolhaDeTipo.getSelectionModel().getSelectedItem());
    		controlador.adicionarCriatura(bicho);
    		cancelar();
    	}catch (Exception e) {
    		Alert alerta = new Alert(Alert.AlertType.WARNING);
    		alerta.setTitle("Atributo(s) inválido(s)");
    		alerta.setContentText("Seu monstro não pode ser criado com esses parâmetros\nRevise os atributos.");
    		alerta.setHeaderText("MONSTRO INVÁLIDO");
    		alerta.show();
    	}
    }
    @FXML 
    public void initialize(){
    	bicho = null;
    	setarComboBox();
    }

	private void setarComboBox() {
		List<Types> tipos = new ArrayList<Types>();
		tipos.add(Types.Aberracao);
		tipos.add(Types.Besta);
		tipos.add(Types.Celestial);
		tipos.add(Types.Construto);
		tipos.add(Types.Demonio);
		tipos.add(Types.Dragao);
		tipos.add(Types.Demonio);
		tipos.add(Types.Dragao);
		tipos.add(Types.Elemental);
		tipos.add(Types.Fada);
		tipos.add(Types.Gigante);
		tipos.add(Types.Gosma);
		tipos.add(Types.Humanoide);
		tipos.add(Types.Monstruosidade);
		tipos.add(Types.MortoVivo);
		tipos.add(Types.Planta);
		
		escolhaDeTipo.setItems(FXCollections.observableArrayList(tipos));
	}
}
