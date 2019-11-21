package monsterRPG.gui.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.MesaInvalidaException;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Mesa;

public class MesaDialogController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private Mesa mesaSelecionada;
	private List<Mesa> listaLocalDeMesas;
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
    private ListView<String> listNotas;

    @FXML
    private ComboBox<String> cbOrdenar;

    @FXML
    private Button buttonAddMesa;

    @FXML
    private Button verNotas;

    @FXML
    void abrirAddMesa() {
    	monsterRPG.abrirCriarMesasDialog();
    	atualizarListaDeMesas();
    }
    @FXML
    void atualizarListaDeMesas() {
    	listMesas.setItems(FXCollections.observableList(listaLocalDeMesas));
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
    	listaLocalDeMesas = controlador.pesquisarMesasComNome(tfPesquisarNomeMesa.getText());
    	atualizarListaDeMesas();
    }

    @FXML
    void removeMesa() {
    	if(listMesas.getSelectionModel().getSelectedItem()!=null) {
    		try {
				controlador.removerMesa(listMesas.getSelectionModel().getSelectedItem());
			} catch (MesaInvalidaException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Remover não é válido");
    		alerta.setHeaderText("Selecione um item para remover");
    		alerta.setContentText("Não foi selecionado nenhum item para remover");
    		alerta.showAndWait();
    	}
    }
    
    @FXML
    void setarListaMesas() {
    	listMesas.setItems(FXCollections.observableList(listaLocalDeMesas));
    }
    void setarListaJogadores() {
    	listJogadores.setItems(FXCollections.observableList(mesaSelecionada.getJogadores()));
    }
    void setarListaNotas() {
    	List<String> aux = new ArrayList<String>(mesaSelecionada.getBlocoNotas().keySet());
    	listNotas.setItems(FXCollections.observableList(aux));
    }
    void setarListaMonstros() {
    	listMonstros.setItems(FXCollections.observableList(mesaSelecionada.getMonstros()));
    }
    void setarNomeDaMesa() {
    	taNomeMesa.setText(mesaSelecionada.getNome());
    }
    void setarDescrição() {
    	taDescricaoMesa.setText(mesaSelecionada.getDescriçao());
    }
    @FXML
    void selecionarMesa() {
    	if(listMesas.getSelectionModel().getSelectedItem()!=null)
    	mesaSelecionada = listMesas.getSelectionModel().getSelectedItem();
    	resetarListaLocal();
    	setarListaJogadores();
    	setarListaMonstros();
    	setarListaNotas();
    	setarDescrição();
    	setarNomeDaMesa();
    	pesquisar();
    }
    void resetarListaLocal() {
    	listaLocalDeMesas = controlador.getMesas();
    }
    
    @FXML
    void initialize() {
    	resetarListaLocal();
    }
}
