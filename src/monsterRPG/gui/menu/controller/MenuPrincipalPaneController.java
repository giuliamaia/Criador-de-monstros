package monsterRPG.gui.menu.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.negocio.ControladorSistema;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MenuPrincipalPaneController {
	private MonsterRPG monsterRPG = new MonsterRPG();
	private ControladorSistema controlador = ControladorSistema.GetInstance();
	private List<Criatura> listaLocal = controlador.getCriaturas();
    @FXML
    private Font x1;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private ListView<Criatura> lvLista;

    @FXML
    private ImageView fotoDoBicho;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
	private Criatura criaturaSelecionada;
	@FXML
	private Label labelNomeMonstro;
	@FXML
	private ToggleButton buttonFavorito;
	@FXML
	private Image imagem;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelVida;

    @FXML
    private Label labelDefesa;

    @FXML
    private Label labelNivel;

    @FXML
    private Label labelForca;

    @FXML
    private Label labelDestreza;

    @FXML
    private Label labelConstituicao;

    @FXML
    private Label labelInteligencia;

    @FXML
    private Label labelSabedoria;

    @FXML
    private Label labelCarisma;

    @FXML
    private Label labelDataCriacao;
    
    @FXML
    private Label labelDescrição;
    
    @FXML
    private DatePicker txData1;

    @FXML
    private DatePicker txData2;

    @FXML
    private Button buttonPesquisarPorData;

    @FXML
    private CheckBox checkBoxDuasDatas;
    
    @FXML
    private Button buttonPesquisaNome;
    @FXML
    void PesquisarPorData() {
    	if(checkBoxDuasDatas.isPressed()) {
    		//TODO data entre
    	}
    	else {
    		listaLocal = controlador.filtrarPorData(txData1.getValue());
    		atualizarLista();
    	}
    }

    @FXML
    void alterarBarraPesquisaParaData() {
    	//Desabilita outros botões
    	barraDePesquisa.setVisible(false);
    	buttonPesquisaNome.setVisible(false);
    	
    	//ativa esse botão
    	buttonPesquisarPorData.setVisible(true);
    	checkBoxDuasDatas.setVisible(true);
    	txData1.setVisible(true);
    	txData2.setVisible(true);
    	abrirData2();
    	
    }
    @FXML
    private void abrirData2() {
    	System.out.println(checkBoxDuasDatas.isPressed());
		if(!checkBoxDuasDatas.isSelected()) {
			txData2.setDisable(true);
		}
		else {
			txData2.setDisable(false);
		}
	}

	@FXML
    void alterarBarraPesquisaParaTipo() {
    	
    }
    @FXML
    void alterarBarraPesquisaParaNome() {
    	//Desabilita outros botões
    	barraDePesquisa.setVisible(true);
    	buttonPesquisaNome.setVisible(true);
    	
    	//ativa esse botão
    	buttonPesquisarPorData.setVisible(false);
    	txData1.setVisible(false);
    	txData2.setVisible(false);
    	checkBoxDuasDatas.setVisible(false);
    }
    @FXML
    void filtrarListaFavoritos() {
    	listaLocal = controlador.filtrarFavoritos();
    	atualizarLista();
    }
	@FXML
	public void Pesquisar() {
		listaLocal = controlador.filtrarPorNome(barraDePesquisa.getText());
		atualizarLista();
	}
	public void setaFoto() {
		try{
			
		}catch(Exception e) {
			
		}
		
	}
	public void selecionaCriatura() {
		try{
			criaturaSelecionada = lvLista.getSelectionModel().getSelectedItem();
			labelCarisma.setText("" + criaturaSelecionada.getCarisma());
			labelConstituicao.setText("" + criaturaSelecionada.getConstituicao());
			labelDefesa.setText("" + criaturaSelecionada.getDefesa());
			labelDestreza.setText("" + criaturaSelecionada.getDestreza());
			labelForca.setText("" + criaturaSelecionada.getForca());
			labelInteligencia.setText("" + criaturaSelecionada.getInteligencia());
			labelNivel.setText("" + criaturaSelecionada.getNivel());
			labelNomeMonstro.setText("" + criaturaSelecionada.getNome());
			labelSabedoria.setText("" + criaturaSelecionada.getSabedoria());
			labelTipo.setText("" + criaturaSelecionada.getTipo().toString());
			labelVida.setText("" + criaturaSelecionada.getVida());
			labelCarisma.setText("" + criaturaSelecionada.getCarisma());
			labelDataCriacao.setText(criaturaSelecionada.getDataCriação().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			labelDescrição.setText(criaturaSelecionada.getDescrição());
			if(criaturaSelecionada.isFavorito()) {
				buttonFavorito.setSelected(true);
			}
			else {
				buttonFavorito.setSelected(false);
			}
			setaFoto();
		}catch(Exception e) {		
			labelCarisma.setText("");
			labelConstituicao.setText("");
			labelDefesa.setText("");
			labelDestreza.setText("");
			labelForca.setText("");
			labelInteligencia.setText("");
			labelNivel.setText("");
			labelNomeMonstro.setText("");
			labelSabedoria.setText("");
			labelTipo.setText("");
			labelVida.setText("");
			labelCarisma.setText("");
			labelDataCriacao.setText("");
			labelDescrição.setText("");
			buttonFavorito.setSelected(false);
		}
		
	}
	public void isBotaoFavoritoPressed() {
		
		try{
			criaturaSelecionada.setFavorito(buttonFavorito.isSelected());
		}catch(NullPointerException e) {
			buttonFavorito.setSelected(false);
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum monstro para favoritar");
			alerta.setHeaderText("Nenhum monstro selecionado");
			alerta.setTitle("Error 404: Monstro não encontrado");
			alerta.showAndWait();
		}
	}
	public void ordenarPorDataCrescente() {
		//TODO ordenar
	}
	public void ordenarPorDataDecrescente() {
		//TODO ordenar
	}
	public void ordenarPorNomeCrescente() {
		//TODO ordenar
	}
	public void ordenarPorNomeDecrescente() {
		//TODO ordenar
		
	}
	public void ordenarPorMortos() {
		//TODO ordenar
	}
	public void ordenarPorFavoritos() {
		//TODO ordenar
	}
	public boolean removeCriatura() {
		try {
			if (criaturaSelecionada==null) {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setContentText("Você precisa selecionar algum monstro para editar");
				alerta.setHeaderText("Nenhum monstro selecionado");
				alerta.setTitle("Error 404: Monstro não encontrado");
				alerta.showAndWait();
			}
			controlador.removerCriatura(criaturaSelecionada);
			listaLocal = controlador.getCriaturas();
			Pesquisar();
			criaturaSelecionada = null;
		} catch (CriaturaInvalidaException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum monstro para editar");
			alerta.setHeaderText("Nenhum monstro selecionado");
			alerta.setTitle("Error 404: Monstro não encontrado");
			alerta.showAndWait();
		}
		
		
		return true;
	}
	@FXML
	public void addCriatura() {
		monsterRPG.abrirNovoMonstroDialog();
		listaLocal = controlador.getCriaturas();
		Pesquisar();
		selecionaCriatura();
		criaturaSelecionada = null;
	}
	public void editCriatura() {
		if(criaturaSelecionada == null) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum monstro para editar");
			alerta.setHeaderText("Nenhum monstro selecionado");
			alerta.setTitle("Error 404: Monstro não encontrado");
			alerta.showAndWait();
		}
		else {
			controlador.setCriaturaAux(criaturaSelecionada);
			monsterRPG.abrirEditarMonstroDialog();
			listaLocal = controlador.getCriaturas();
			Pesquisar();
			criaturaSelecionada = null;
			selecionaCriatura();
			controlador.setCriaturaAux(null);
		}
		
	}
	public void atualizarLista() {
		lvLista.setItems(FXCollections.observableList(listaLocal));
		selecionaCriatura();
	}
	public void initialize() {
		atualizarLista();
		alterarBarraPesquisaParaNome();
	}

}
