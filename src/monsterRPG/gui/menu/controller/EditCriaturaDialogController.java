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

public class EditCriaturaDialogController {
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
		monsterRPG.fecharEditarMonstroDialog();
	}

	@FXML
	public void submeter() {
		try {
			if (escolhaDeTipo.getSelectionModel().getSelectedIndex() == -1) {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Tipo inválido");
				alerta.setContentText("Seu monstro não pode ser criado sem um tipo\nEscolha um tipo válido.");
				alerta.setHeaderText("TIPO INVÁLIDO");
				alerta.show();
			} else {
				bicho = new Criatura(Integer.parseInt(txVida.getText()), Integer.parseInt(txDefesa.getText()),
						Double.parseDouble(txNivel.getText()), Integer.parseInt(txForca.getText()),
						Integer.parseInt(txDestreza.getText()), Integer.parseInt(txConstituicao.getText()),
						Integer.parseInt(txInteligencia.getText()), Integer.parseInt(txSabedoria.getText()),
						Integer.parseInt(txCarisma.getText()), txNome.getText(), txDescricao.getText(),
						escolhaDeTipo.getSelectionModel().getSelectedItem());
				bicho.setDataCriação(controlador.getCriaturaAux().getDataCriação());
				controlador.editarCriatura(controlador.getCriaturaAux(), bicho);
				cancelar();
			}
		} catch (Exception e) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Atributo(s) inválido(s)");
			alerta.setContentText("Seu monstro não pode ser criado com esses parâmetros\nRevise os atributos.");
			alerta.setHeaderText("MONSTRO INVÁLIDO");
			alerta.show();
		}
	}

	@FXML
	public void initialize() {
		bicho = null;
		setarComboBox();
		txCarisma.setText("" + controlador.getCriaturaAux().getCarisma());
		txConstituicao.setText("" + controlador.getCriaturaAux().getConstituicao());
		txDefesa.setText("" + controlador.getCriaturaAux().getDefesa());
		txDestreza.setText("" + controlador.getCriaturaAux().getDestreza());
		txForca.setText("" + controlador.getCriaturaAux().getForca());
		txInteligencia.setText("" + controlador.getCriaturaAux().getInteligencia());
		txNivel.setText("" + controlador.getCriaturaAux().getNivel());
		txNome.setText("" + controlador.getCriaturaAux().getNome());
		txSabedoria.setText("" + controlador.getCriaturaAux().getSabedoria());
		escolhaDeTipo.setValue(controlador.getCriaturaAux().getTipo());
		txVida.setText("" + controlador.getCriaturaAux().getVida());
		txCarisma.setText("" + controlador.getCriaturaAux().getCarisma());
		txDescricao.setText(controlador.getCriaturaAux().getDescrição());
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
}
