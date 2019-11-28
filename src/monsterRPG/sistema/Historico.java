package monsterRPG.sistema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Historico {
	private List<String> adicionadas = new ArrayList<String>();
	private List<String> removidas = new ArrayList<String>();
	private List<String> editadas = new ArrayList<String>();

	public Historico() {

	}

	public Historico(List<String> adicionadas, List<String> removidas, List<String> editadas) {
		this.adicionadas = adicionadas;
		this.removidas = removidas;
		this.editadas = editadas;
	}

	public List<String> getAdicionadas() {
		return adicionadas;
	}

	public void setAdicionadas(List<String> adicionadas) {
		this.adicionadas = adicionadas;
	}

	public List<String> getRemovidas() {
		return removidas;
	}

	public void setRemovidas(List<String> removidas) {
		this.removidas = removidas;
	}

	public List<String> getEditadas() {
		return editadas;
	}

	public void setEditadas(List<String> editadas) {
		this.editadas = editadas;
	}

	@SuppressWarnings("unchecked")
	public void carregarArquivoHistoricoAdicionadas() {
		try {
			FileInputStream f = new FileInputStream("HistoricoMonstrosAdd.galonegro");
			ObjectInputStream o = new ObjectInputStream(f);
			this.setAdicionadas((List<String>) o.readObject());
			o.close();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	@SuppressWarnings("unchecked")
	public void carregarArquivoHistoricoEditadas() {
		try {

			FileInputStream f = new FileInputStream("HistoricoMonstrosEdit.galonegro");
			ObjectInputStream o = new ObjectInputStream(f);
			this.setEditadas((List<String>) o.readObject());
			o.close();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	@SuppressWarnings("unchecked")
	public void carregarArquivoHistoricoRemovidas() {
		try {
			FileInputStream f = new FileInputStream("HistoricoMonstrosRem.galonegro");
			ObjectInputStream o = new ObjectInputStream(f);
			this.setRemovidas((List<String>) o.readObject());
			o.close();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	public void salvarArquivoHistoricoRemovidas() {
		try {

			FileOutputStream f = new FileOutputStream("HistoricoMonstrosRem.galonegro");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(getRemovidas());
			o.close();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	public void salvarArquivoHistoricoAdicionadas() {
		try {
			FileOutputStream f = new FileOutputStream("HistoricoMonstrosAdd.galonegro");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(getAdicionadas());
			o.close();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	public void salvarArquivoHistoricoEditadas() {
		try {

			FileOutputStream f = new FileOutputStream("HistoricoMonstrosEdit.galonegro");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(getEditadas());
			o.close();
		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}

	public void adicionarNoHistoricoAdicionadas(Criatura c) {
		if (c != null) {

			String galonegro = c.getNome() + " - " + LocalDate.now().toString();
			this.getAdicionadas().add(galonegro);
		}

	}

	public void adicionarNoHistoricoRemovidas(Criatura c) {
		if (c != null) {

			String galonegro = c.getNome() + " - " + LocalDate.now().toString();
			this.getRemovidas().add(galonegro);
		}

	}

	public void adicionarNoHistoricoEditadas(Criatura c) {
		if (c != null) {

			String galonegro = c.getNome() + " - " + LocalDate.now().toString();
			this.getEditadas().add(galonegro);
		}

	}

	public List<String> pegarCriaturasAdicionadasHistorico() {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.getAdicionadas().size(); i++) {
			try {
				ret.add(this.getAdicionadas().get(i));
			} catch (NullPointerException e) {
				System.out.println("aaaa");
			}
		}
		return ret;
	}

	public List<String> pegarCriaturasRemovidasHistorico() {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.getRemovidas().size(); i++) {
			try {
				ret.add(this.getRemovidas().get(i));
			} catch (NullPointerException e) {
				System.out.println("aaaa");
			}
		}
		return ret;
	}

	public List<String> pegarCriaturasEditadasHistorico() {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.getEditadas().size(); i++) {
			try {
				ret.add(this.getEditadas().get(i));
			} catch (NullPointerException e) {
				System.out.println("aaaa");
			}
		}
		return ret;
	}

	public void salvarTodosArquivosHistorico() {
		this.salvarArquivoHistoricoAdicionadas();
		this.salvarArquivoHistoricoEditadas();
		this.salvarArquivoHistoricoRemovidas();
	}

	public void carregarTodosArquivosHistorico() {
		this.carregarArquivoHistoricoAdicionadas();
		this.carregarArquivoHistoricoEditadas();
		this.carregarArquivoHistoricoRemovidas();
	}

}
