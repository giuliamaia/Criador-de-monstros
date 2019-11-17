package monsterRPG.gui.menu.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import monsterRPG.gui.MonsterRPG;
import monsterRPG.sistema.Criatura;
import monsterRPG.sistema.CriaturaInvalidaException;
import monsterRPG.sistema.Types;
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
	private List<String> listaLocalDeJogadores;
	private String jogadorSelecionado;
    @FXML
    private Font x1;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private ListView<Criatura> lvLista;
    @FXML
    private TextField tfNivel1;

    @FXML
    private TextField tfNivel2;
    @FXML
    private Button buttonPesquisarPorNivel;

    @FXML
    private ImageView fotoDoBicho;
    @FXML
    private ComboBox<Types> escolhaDeTipo;
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
    private CheckBox checkQuerApenasFavoritos;
    @FXML
    private ListView<String> lvJogadoresQueJáMataram;

    @FXML
    private Button buttonPesquisaJogadorQueMatou;
    
    @FXML
    private TextField labelBarraDePesquisaJogadorQueMatou;
    
    @FXML
    private Button removeJogadorQueMatou;

    @FXML
    private Button editJogadorQueMatou;

    @FXML
    private Button addJogadorQueMatou;
    
    
    @FXML
    void PesquisarPorData() {
    	if(checkBoxDuasDatas.isSelected()) {
    		if (txData2.getValue()!=null && txData1.getValue()!=null) {
    			try {
    				if(txData1.getValue().isBefore(txData2.getValue())||txData1.getValue().isEqual(txData2.getValue())) {
    					listaLocal = controlador.filtrarCriaturasCriadasEntreDuasDatas(txData1.getValue(), txData2.getValue());
    					atualizarLista();
    				}
    				else {
    					LocalDate aux;
    					aux = txData1.getValue();
    					txData1.setValue(txData2.getValue());
    					txData2.setValue(aux);
    					listaLocal = controlador.filtrarCriaturasCriadasEntreDuasDatas(txData2.getValue(), txData1.getValue());
    					atualizarLista();
    				}
    			}catch(Exception e) {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
    				alert.setContentText("Você está usando paramêtros inválidos na sua pesquisa.");
            		alert.setHeaderText("Paramêtros invalidos para pesquisa");
            		alert.setTitle("Error Feijo4d4");
            		alert.showAndWait();
    			}
    		}
    	}
    	else {
    		if(txData1 != null) {
    			listaLocal = controlador.filtrarPorData(txData1.getValue());
        		atualizarLista();
    		}
    	}
    }

    @FXML
    void alterarBarraPesquisaParaData() {
    	//Desabilita outros botões
    	barraDePesquisa.setVisible(false);
    	buttonPesquisaNome.setVisible(false);
    	
    	//ativa esse botão
    	tfNivel1.setVisible(false);
    	tfNivel2.setVisible(false);
    	buttonPesquisarPorNivel.setVisible(false);
    	escolhaDeTipo.setVisible(false);
    	buttonPesquisarPorData.setVisible(true);
    	checkBoxDuasDatas.setVisible(true);
    	txData1.setVisible(true);
    	txData2.setVisible(true);
    	abrirData2();
    	
    }
    @FXML
    private void abrirData2() {
		if(!checkBoxDuasDatas.isSelected()) {
			txData2.setDisable(true);
		}
		else {
			txData2.setDisable(false);
		}
	}

	@FXML
    void alterarBarraPesquisaParaTipo() {
		//Abilita esse botões
		escolhaDeTipo.setVisible(true);
    	
    	
    	//desativa esse botão
		tfNivel1.setVisible(false);
    	tfNivel2.setVisible(false);
    	buttonPesquisarPorNivel.setVisible(false);
    	buttonPesquisarPorData.setVisible(false);
    	txData1.setVisible(false);
    	txData2.setVisible(false);
    	checkBoxDuasDatas.setVisible(false);
    	barraDePesquisa.setVisible(false);
    	buttonPesquisaNome.setVisible(false);
    }
    @FXML
    void alterarBarraPesquisaParaNome() {
    	//Abilita esse botões
    	barraDePesquisa.setVisible(true);
    	buttonPesquisaNome.setVisible(true);
    	
    	//desativa esse botão
    	tfNivel1.setVisible(false);
    	tfNivel2.setVisible(false);
    	buttonPesquisarPorNivel.setVisible(false);
    	buttonPesquisarPorData.setVisible(false);
    	txData1.setVisible(false);
    	txData2.setVisible(false);
    	checkBoxDuasDatas.setVisible(false);
    	escolhaDeTipo.setVisible(false);
    }
    @FXML
    void filtrarListaFavoritos() {
    	listaLocal = controlador.filtrarFavoritos(listaLocal);
    }
    @FXML 
    void crimeOcorre(){
    	
    }
    @FXML
    void filtrarListaNivel() {
    	if(!tfNivel1.getText().isEmpty() && !tfNivel2.getText().isEmpty()) {
    		try {
        		double a = Double.parseDouble(tfNivel1.getText());
        		double b = Double.parseDouble(tfNivel2.getText());
        		if(b<a) {
        			tfNivel1.setText(""+b);
        			tfNivel2.setText(""+a);
        			listaLocal = controlador.filtrarPorNivel(b, a);
        		}
        		else {
        			listaLocal = controlador.filtrarPorNivel(a, b);
        		}
        		atualizarLista();
        	}catch(Exception e) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setContentText("Você está usando paramêtros inválidos na sua pesquisa.");
        		alert.setHeaderText("Paramêtros invalidos para pesquisa");
        		alert.setTitle("Error 4002-8922");
        		alert.showAndWait();
        	}
    	}
    }

    @FXML
    void alteraBarraDePesquisaParaNivel() {
    	//Abilita esse botões
    	tfNivel1.setVisible(true);
    	tfNivel2.setVisible(true);
    	buttonPesquisarPorNivel.setVisible(true);
    	
    	
    	//desativa esse botão
    	barraDePesquisa.setVisible(false);
    	buttonPesquisaNome.setVisible(false);
    	buttonPesquisarPorData.setVisible(false);
    	txData1.setVisible(false);
    	txData2.setVisible(false);
    	checkBoxDuasDatas.setVisible(false);
    	escolhaDeTipo.setVisible(false);
    }
	@FXML
	public void Pesquisar() {
		listaLocal = controlador.filtrarPorNome(barraDePesquisa.getText());
		atualizarLista();
	}
	@FXML
	public void PesquisarPorTipo() {
		listaLocal = controlador.filtrarPorTipo(escolhaDeTipo.getSelectionModel().getSelectedItem());
		atualizarLista();
	}
	public void setaFoto() {
		try{
			fotoDoBicho.setImage(new Image(getClass().getResource(criaturaSelecionada.getUrlDaFotinha()).toExternalForm()));
		}catch(Exception e) {
			fotoDoBicho.setImage(new Image(getClass().getResource("images/DEFAULT.png").toExternalForm()));
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
			setaJogadoresQueMataram();
			setaListaQuemMatou();
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
			setaFoto();
			lvJogadoresQueJáMataram.setItems(null);
			buttonPesquisaJogadorQueMatou.setDisable(true);
			labelBarraDePesquisaJogadorQueMatou.setDisable(true);
			lvJogadoresQueJáMataram.setDisable(true);
			addJogadorQueMatou.setDisable(true);
			editJogadorQueMatou.setDisable(true);
			removeJogadorQueMatou.setDisable(true);
		}
		
	}
	@FXML
	private void setaJogadoresQueMataram() {
		buttonPesquisaJogadorQueMatou.setDisable(false);
		labelBarraDePesquisaJogadorQueMatou.setDisable(false);
		lvJogadoresQueJáMataram.setDisable(false);
		addJogadorQueMatou.setDisable(false);
		editJogadorQueMatou.setDisable(false);
		removeJogadorQueMatou.setDisable(false);
		pesquisaJogadorQueMatou();
		atualizaListaJogadoresQueMataram();
		
	}
	@FXML
	void atualizaListaJogadoresQueMataram() {
		controlador.salvar();
		if(listaLocalDeJogadores!=null){
			lvJogadoresQueJáMataram.setItems(FXCollections.observableList(listaLocalDeJogadores));
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
		controlador.ordenarDatasCrescenteComParametro(listaLocal);
		atualizarLista();
	}
	public void ordenarPorDataDecrescente() {
		controlador.ordenarDatasDecrescenteComParametro(listaLocal);
		atualizarLista();
	}
	public void ordenarPorNomeCrescente() {
		controlador.ordenarNomesPorOrdemAlfabeticaComParametro(listaLocal);
		atualizarLista();
	}
	public void ordenarPorNomeDecrescente() {
		controlador.ordenarNomesPorOrdemAlfabeticaComParametroReverse(listaLocal);
		atualizarLista();
	}
	public void ordenarPorMortos() {
		//TODO ordenar
	}
	public boolean removeCriatura() {
		
		try {
			if (criaturaSelecionada==null) {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setContentText("Você precisa selecionar algum monstro para remover");
				alerta.setHeaderText("Nenhum monstro selecionado");
				alerta.setTitle("Error 404: Monstro não encontrado");
				alerta.showAndWait();
			}
			else {
				Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
				alerta.setContentText("Você deseja confirmar a remoção?");
				alerta.setHeaderText("Confirmação");
				alerta.setTitle("REMOVER MONSTRO");
				alerta.showAndWait();
				if (alerta.getResult() == alerta.getResult().OK) {
					controlador.removerCriatura(criaturaSelecionada);
					listaLocal = controlador.getCriaturas();
					Pesquisar();
					criaturaSelecionada = null;
				}
			}
			
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
    @FXML
    void querApenarFavoritos() {
    	if(checkQuerApenasFavoritos.isSelected()) {
    		atualizarLista();
    	}
    	else {
    		if(!buttonPesquisaNome.isDisabled()) {
    			Pesquisar();
    		}
    		else if(!buttonPesquisarPorData.isDisabled()) {
    			PesquisarPorData();
    		}
    		else if(!buttonPesquisarPorNivel.isDisabled()) {
    			filtrarListaNivel();
    		}
    	}
    }
    @FXML
	public void atualizarLista() {
		if(checkQuerApenasFavoritos.isSelected()) {
			filtrarListaFavoritos();
		}
		lvLista.setItems(FXCollections.observableList(listaLocal));
		selecionaCriatura();
	}
	private void setarComboBox() {
		List<Types> tipos = new ArrayList<Types>();
		tipos.add(Types.ABERRAÇAO);
		tipos.add(Types.BESTA);
		tipos.add(Types.CELESTIAL);
		tipos.add(Types.CONSTRUTO);
		tipos.add(Types.DEMONIO);
		tipos.add(Types.DRAGAO);
		tipos.add(Types.ELEMENTAL);
		tipos.add(Types.FADA);
		tipos.add(Types.GIGANTE);
		tipos.add(Types.GOSMA);
		tipos.add(Types.HUMANOIDE);
		tipos.add(Types.MONSTRUOSIDADE);
		tipos.add(Types.MORTOVIVO);
		tipos.add(Types.PLANTA);
		
		escolhaDeTipo.setItems(FXCollections.observableArrayList(tipos));
	}
	@FXML
	void selecionaJogadorQueMatou() {
		jogadorSelecionado = lvJogadoresQueJáMataram.getSelectionModel().getSelectedItem();
	}
    @FXML
    void pesquisaJogadorQueMatou() {
    	if(labelBarraDePesquisaJogadorQueMatou != null)
    	listaLocalDeJogadores = criaturaSelecionada.listarJogadoresMortosComNome(labelBarraDePesquisaJogadorQueMatou.getText());
    	atualizaListaJogadoresQueMataram();
    }

    @FXML
    void removeJogadorQueMatou() {
		try {
			if (jogadorSelecionado == null) {
    			Alert alerta = new Alert(Alert.AlertType.ERROR);
    			alerta.setContentText("Você precisa selecionar algum jogador para editar");
    			alerta.setHeaderText("Nenhum jogador selecionado");
    			alerta.setTitle("Error 421: Jogador não encontrado");
    			alerta.showAndWait();
    		}
			else {
				criaturaSelecionada.removerMortePeloJogador(jogadorSelecionado);
				jogadorSelecionado = null;
				pesquisaJogadorQueMatou();
				atualizaListaJogadoresQueMataram();
				
			}
			
		}
		catch(Exception e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum jogador para remover");
			alerta.setHeaderText("Nenhum jogador selecionado");
			alerta.setTitle("Error 421: Jogador não encontrado");
			alerta.showAndWait();
		}
    }

    @FXML
    void editJogadorQueMatou() {
    	try {
    		if (jogadorSelecionado == null) {
    			Alert alerta = new Alert(Alert.AlertType.ERROR);
    			alerta.setContentText("Você precisa selecionar algum jogador para editar");
    			alerta.setHeaderText("Nenhum jogador selecionado");
    			alerta.setTitle("Error 421: Jogador não encontrado");
    			alerta.showAndWait();
    		}
    		else {
    			controlador.setJogadorAuxiliar(jogadorSelecionado);
    			monsterRPG.abrirEditarJogadorDialog();
    			if(controlador.getJogadorParaEditar() != null) {
    				criaturaSelecionada.editarMortePeloJogador(jogadorSelecionado, controlador.getJogadorParaEditar());
    			}
    			pesquisaJogadorQueMatou();
            	atualizaListaJogadoresQueMataram();
            	jogadorSelecionado=null;
            	controlador.setJogadorAuxiliar(null);
    		}
        	
    	}
    	catch(Exception e) {
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Você precisa selecionar algum jogador para editar");
			alerta.setHeaderText("Nenhum jogador selecionado");
			alerta.setTitle("Error 421: Jogador não encontrado");
			alerta.showAndWait();
    	}
    }

    @FXML
    void addJogadorQueMatou() {
    	monsterRPG.abrirNovoJogadorDialog();
    	criaturaSelecionada.adicionarMortePeloJogador(controlador.getJogadorParaAdd());
    	pesquisaJogadorQueMatou();
    	atualizaListaJogadoresQueMataram();
    	jogadorSelecionado=null;
    }
	public void initialize() {
		atualizarLista();
		alterarBarraPesquisaParaNome();
		setarComboBox();
		selecionaCriatura();
		jogadorSelecionado = null;
	}
    @FXML
    void carregarArquivoOutro() {
    	controlador.carregar();
    }

    @FXML
    void carregarArquivoPadrão() {
    	//controlador.carregar(path);
    }
    @FXML
    void salvarLista() {
    	controlador.salvar();
    }

    @FXML
    void salvarListaOutro() {
    	//controlador.salvar(path);
    }
	void setaListaQuemMatou() {
		if(criaturaSelecionada != null) {
			listaLocalDeJogadores = criaturaSelecionada.getJogadoresQueMataram();
		}
	}
}
