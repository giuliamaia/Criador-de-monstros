package monsterRPG.gui.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.MesaInvalidaException;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Mesa;
import monsterRPG.sistema.usuario.Nota;

public class EditarMesaDialogController {
	
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private Mesa mesaSelecionada;
	private List<Nota> listaLocalNotas = controlador.getNotas();
	private Mesa auxMesa;
	private String jogadorSelecionado;
	private String monstroSelecionado;
	private Nota notaSelecionada;

    @FXML
    private TextField txDescricao;

    @FXML
    private ListView<String> listJogadores;

    @FXML
    private ListView<String> listMonstros;

    @FXML
    private ListView<Nota> listNotas;

    @FXML
    private ComboBox<String> cbEscolherMonstro;

    @FXML
    private TextField txNomeMesa;

    @FXML
    private TextField txConteudoNota;

    @FXML
    private TextField txNovoJogador;

    @FXML
    void addJogador() {
    	if(txNovoJogador.getText().isEmpty()) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Jogador não pode ser adicionado!");
    		alerta.setHeaderText("Jogadores sem nome não podem ser adicionados.");
    		alerta.setContentText("Coloque um nome no jogador.");
    		alerta.showAndWait();
    	}
    	else {
    		if(!auxMesa.getJogadores().contains(txNovoJogador.getText()))
    		auxMesa.adicionarJogador(txNovoJogador.getText());
    		atualizarListaJogadores();
    	}
    }

    @FXML
    void addMonstro() {
    	if(cbEscolherMonstro.getSelectionModel().getSelectedItem() == null) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Monstro não selecionado!");
    		alerta.setHeaderText("Não pode adicionar um monstro vazio.");
    		alerta.setContentText("Selecione um monstro.");
    		alerta.showAndWait();
    	}
    	else {
    		if(!auxMesa.getMonstros().contains(cbEscolherMonstro.getSelectionModel().getSelectedItem()))
    		auxMesa.adicionarMonstro(cbEscolherMonstro.getSelectionModel().getSelectedItem());
    		atualizarListaMonstro();
    	}
    }

    @FXML
    void addNota() {
    }
    
    @FXML
    void cancelar() {
    	monsterRPG.fecharEditarMesasDialog();
    }

    @FXML
    void confirmar() {
    	auxMesa.setNome(new String(txNomeMesa.getText()));
    	auxMesa.setDescriçao(new String(txDescricao.getText()));
    	try {
			controlador.editarMesa(controlador.getMesaAux(), auxMesa);
		} catch (MesaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	monsterRPG.fecharEditarMesasDialog();
    }

    @FXML
    void removeMonstro() {
    	if(monstroSelecionado != null) {
    		auxMesa.removerMonstro(monstroSelecionado);
    		monstroSelecionado = null;
    		atualizarListaMonstro();
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
    void removeNota() {
    	
    }
    
    @FXML
    void selecionarJogador() {
    	jogadorSelecionado = listJogadores.getSelectionModel().getSelectedItem();
    }
    @FXML
    void selecionarMonstro() {
    	monstroSelecionado = listMonstros.getSelectionModel().getSelectedItem();
    }
    @FXML
    void selecionarNota() {
    	notaSelecionada = listNotas.getSelectionModel().getSelectedItem();
    }
    @FXML
    void removeJogador() {
    	if(jogadorSelecionado != null) {
    		auxMesa.removerJogador(jogadorSelecionado);
    		jogadorSelecionado = null;
    		atualizarListaJogadores();
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
    void setarComboBox() {
    	List<String> r = new ArrayList<String>();
    	for(int i=0; i<controlador.getCriaturas().size(); i++) {
    		r.add(controlador.getCriaturas().get(i).getNome());
    	}
    	cbEscolherMonstro.setItems(FXCollections.observableList(r));
    }
    
    @FXML
    void initialize() {
    	mesaSelecionada = controlador.getMesaAux();
    	auxMesa = (Mesa) mesaSelecionada.clone();
    	txNomeMesa.setText(mesaSelecionada.getNome());
    	txDescricao.setText(mesaSelecionada.getDescriçao());
    	listJogadores.setItems(FXCollections.observableList(mesaSelecionada.getJogadores()));
    	listMonstros.setItems(FXCollections.observableList(mesaSelecionada.getMonstros()));
    	listNotas.setItems(FXCollections.observableList(listaLocalNotas));
    	setarComboBox();
    }
    
    void atualizarListaJogadores() {
    	listJogadores.setItems(FXCollections.observableList(auxMesa.getJogadores()));
    }
    
    void atualizarListaMonstro() {
    	listMonstros.setItems(FXCollections.observableList(auxMesa.getMonstros()));
    }
}
