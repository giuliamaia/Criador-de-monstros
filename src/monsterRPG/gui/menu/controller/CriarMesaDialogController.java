package monsterRPG.gui.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Mesa;

public class CriarMesaDialogController {
	private Mesa mesaAux = new Mesa();
	private String jogadorSelecionado;
	private String monstroSelecionado;
	private String notaSelecionada;
	private ControladorSistema controlador = ControladorSistema.GetInstance();
    @FXML
    private TextField txNomeJogador;

    @FXML
    private TextField txDescricao;

    @FXML
    private ListView<String> listJogadoresAdicionados;

    @FXML
    private ListView<String> ListMonstrosAdicionados;

    @FXML
    private ListView<String> listNotasAdicionadas;

    @FXML
    private ComboBox<String> cbEscolhaMonstro;

    @FXML
    private TextField txNomeNota;

    @FXML
    private TextField txNomeMesa;

    @FXML
    private TextField txConteudoNota;

    @FXML
    void addCriatura() {
    	if(cbEscolhaMonstro.getSelectionModel().getSelectedItem().isEmpty()) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Monstro não selecionado!");
    		alerta.setHeaderText("Não pode adicionar");
    		alerta.setContentText("Coloque um nome no jogador.");
    		alerta.showAndWait();
    	}
    	else {
    		mesaAux.adicionarMonstro(cbEscolhaMonstro.getSelectionModel().getSelectedItem());
    		atualizarListaMonstro();
    	}
    }
    void atualizarListaMonstro() {
    	ListMonstrosAdicionados.setItems(FXCollections.observableList(mesaAux.getMonstros()));
    }
    @FXML
    void setarComboBox() {
    	List<String> r = new ArrayList<String>();
    	for(int i=0; i<controlador.getCriaturas().size(); i++) {
    		r.add(controlador.getCriaturas().get(i).getNome());
    	}
    	cbEscolhaMonstro.setItems(FXCollections.observableList(r));
    }
    
    @FXML
    void addJogador() {
    	if(txNomeJogador.getText().isEmpty()) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Jogador não pode ser adicionado!");
    		alerta.setHeaderText("Jogadores sem nome não podem ser adicionados.");
    		alerta.setContentText("Coloque um nome no jogador.");
    		alerta.showAndWait();
    	}
    	else {
    		mesaAux.adicionarJogador(txNomeJogador.getText());
    		atualizarListaJogadores();
    	}
    }
    
    void atualizarListaJogadores() {
    	listJogadoresAdicionados.setItems(FXCollections.observableList(mesaAux.getJogadores()));
    }
    
    @FXML
    void addNota() {
    	if(txNomeNota.getText().isEmpty()) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Nota não pode ser adicionada!");
    		alerta.setHeaderText("Notas sem título não podem ser adicionadas.");
    		alerta.setContentText("Coloque um título na nota.");
    		alerta.showAndWait();
    	}
    	else {
    		mesaAux.adicionarNota(txNomeNota.getText(), txConteudoNota.getText());
    		atualizarListaNotas();
    	}
    }
    
    void atualizarListaNotas() {
    	List<String> lista = new ArrayList<String>(mesaAux.getBlocoNotas().keySet());
    	listNotasAdicionadas.setItems(FXCollections.observableList(lista));
    }
  
    void  initialize() {
    	mesaAux = new Mesa();
    	setarComboBox();
    }
    @FXML
    void selecionarJogador() {
    	jogadorSelecionado = listJogadoresAdicionados.getSelectionModel().getSelectedItem();
    }
    @FXML
    void selecionarMonstro() {
    	monstroSelecionado = ListMonstrosAdicionados.getSelectionModel().getSelectedItem();
    }
    @FXML
    void selecionarNota() {
    	notaSelecionada = listNotasAdicionadas.getSelectionModel().getSelectedItem();
    }
}
