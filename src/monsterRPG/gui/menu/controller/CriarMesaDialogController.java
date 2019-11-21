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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.MesaInvalidaException;
import monsterRPG.sistema.negocio.ControladorSistema;
import monsterRPG.sistema.usuario.Mesa;

public class CriarMesaDialogController {
	private Mesa mesaAux = new Mesa();
	private MonsterRPG monsterRPG = new MonsterRPG();
	private String jogadorSelecionado;
	private String monstroSelecionado;
	private String notaSelecionada;
	private ControladorSistema controlador = ControladorSistema.GetInstance();
    @FXML
    private TextField txNomeJogador;

    @FXML
    private TextArea txDescricao;

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
    private TextArea txConteudoNota;

    @FXML
    void addCriatura() {
    	if(cbEscolhaMonstro.getSelectionModel().getSelectedItem() == null) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Monstro não selecionado!");
    		alerta.setHeaderText("Não pode adicionar um monstro vazio.");
    		alerta.setContentText("Selecione um monstro.");
    		alerta.showAndWait();
    	}
    	else {
    		if(!mesaAux.getMonstros().contains(cbEscolhaMonstro.getSelectionModel().getSelectedItem()))
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
    		if(!mesaAux.getJogadores().contains(txNomeJogador.getText()))
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
    		if(mesaAux.getBlocoNotas().get(txNomeNota.getText()) == null)
    		mesaAux.adicionarNota(txNomeNota.getText(), txConteudoNota.getText());
    		atualizarListaNotas();
    	}
    }
    
    void atualizarListaNotas() {
    	List<String> lista = new ArrayList<String>(mesaAux.getBlocoNotas().keySet());
    	listNotasAdicionadas.setItems(FXCollections.observableList(lista));
    }
    @FXML
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
    @FXML
    void removerJogador() {
    	if(jogadorSelecionado != null) {
    		mesaAux.removerJogador(jogadorSelecionado);
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
    void removerMonstro() {
    	if(monstroSelecionado != null) {
    		mesaAux.removerMonstro(monstroSelecionado);
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
    void removerNota() {
    	if(notaSelecionada != null) {
    		mesaAux.removerNova(notaSelecionada);
    		notaSelecionada = null;
    		atualizarListaNotas();
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
    void salvarMesa() {
    	if(!txNomeMesa.getText().isEmpty()) {
    		try {
    			mesaAux.setNome(txNomeMesa.getText());
    			mesaAux.setDescriçao(txDescricao.getText());
				controlador.adicionarMesa(mesaAux);
				monsterRPG.fecharCriarMesasDialog();
			} catch (MesaInvalidaException e) {
				Alert alerta = new Alert(AlertType.ERROR);
	    		alerta.setTitle("Mesa sem nome");
	    		alerta.setHeaderText("Mesa precisa de um nome");
	    		alerta.setContentText("Escolha um nome para sua mesa");
	    		alerta.showAndWait();
			}
    	}
    }
}
