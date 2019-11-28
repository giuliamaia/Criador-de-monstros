package monsterRPG.gui.menu.controller;

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
    private ComboBox<String> cbOrdenar;

    @FXML
    private Button buttonAddMesa;

    @FXML
    private Button verNotas;

    @FXML
    void abrirAddMesa() {
    	monsterRPG.abrirCriarMesasDialog();
    	pesquisar();
    	atualizarListaDeMesas();
    }
    @FXML
    void atualizarListaDeMesas() {
    	listMesas.setItems(FXCollections.observableList(listaLocalDeMesas));
    }
    @FXML
    void abrirEditMesa() {
    	monsterRPG.abrirEditarMesasDialog();
    	atualizarListaDeMesas();
    	pesquisar();
    	
    }

    @FXML
    void abrirVerNotasDialog() {
    	monsterRPG.abrirNotasDialog();
    	atualizarListaDeMesas();
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
				atualizarListaDeMesas();
				pesquisar();
				zerarAtributos();
			} catch (MesaInvalidaException e) {
				System.out.println("Error");
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
    	if(listMesas.getSelectionModel().getSelectedItem()!=null) {
    		mesaSelecionada = listMesas.getSelectionModel().getSelectedItem();
        	resetarListaLocal();
        	setarListaJogadores();
        	setarListaMonstros();
        	setarDescrição();
        	setarNomeDaMesa();
        	pesquisar();
    	}
    	
    }
    void zerarAtributos() {
    	taDescricaoMesa.setText("");
    	taNomeMesa.setText("");
    	listJogadores.setItems(FXCollections.emptyObservableList());
    	listMesas.setItems(FXCollections.emptyObservableList());
    	listMonstros.setItems(FXCollections.emptyObservableList());
    }
    void resetarListaLocal() {
    	listaLocalDeMesas = controlador.getMesas();
    }
    
    @FXML
    void initialize() {
    	resetarListaLocal();
    	pesquisar();
    }
}
