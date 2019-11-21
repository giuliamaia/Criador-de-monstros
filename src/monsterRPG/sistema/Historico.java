package monsterRPG.sistema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Historico {
	private List<Criatura> adicionadas = new ArrayList<Criatura>();
	private List<Criatura> removidas = new ArrayList<Criatura>();
	private List<Criatura> editadas = new ArrayList<Criatura>();
	
	public Historico() {
		
	}

	public Historico(List<Criatura> adicionadas, List<Criatura> removidas, List<Criatura> editadas) {
		this.adicionadas = adicionadas;
		this.removidas = removidas;
		this.editadas = editadas;
	}
	
	
	public List<Criatura> getAdicionadas() {
		return adicionadas;
	}

	public void setAdicionadas(List<Criatura> adicionadas) {
		this.adicionadas = adicionadas;
	}

	public List<Criatura> getRemovidas() {
		return removidas;
	}

	public void setRemovidas(List<Criatura> removidas) {
		this.removidas = removidas;
	}

	public List<Criatura> getEditadas() {
		return editadas;
	}

	public void setEditadas(List<Criatura> editadas) {
		this.editadas = editadas;
	}

	
	@SuppressWarnings("unchecked")
	public void carregarArquivoHistoricoAdicionadas() {
		try {
			FileInputStream f = new FileInputStream("HistoricoMonstrosAdd.galonegro");
			ObjectInputStream o = new ObjectInputStream(f);
			this.setAdicionadas((List<Criatura>)o.readObject());
			o.close();
			
		}catch(Exception e) {
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
			this.setEditadas((List<Criatura>)o.readObject());
			o.close();
			
		}catch(Exception e) {
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
			this.setRemovidas((List<Criatura>)o.readObject());
			o.close();

		}catch(Exception e) {
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
			
		}catch(Exception e) {
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

		}catch(Exception e) {
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
		}catch(Exception e) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Arquivo não encontrado!");
			alerta.setHeaderText("Não foi possível encontrar seu arquivo.");
			alerta.setContentText("Um novo arquivo foi criado automaticamente.");
			alerta.showAndWait();
		}
	}
	public void adicionarNoHistoricoAdicionadas(Criatura c) {
		if(c != null) {
			this.getAdicionadas().add(c);
		}
		
	}
	public void adicionarNoHistoricoRemovidas(Criatura c) {
		if(c != null) {
			this.getRemovidas().add(c);
		}
		
	}
	public void adicionarNoHistoricoEditadas(Criatura c) {
		if(c != null) {
			this.getEditadas().add(c);
		}
		
	}
	public List<String> pegarCriaturasAdicionadasHistorico() {
		List<String> ret = new ArrayList<String>();
		for(int i=0; i<this.getAdicionadas().size(); i++) {
			try {
				ret.add(this.getAdicionadas().get(i).getNome());
			}catch(NullPointerException e) {
				System.out.println("aaaa");
			}
		}
		return ret;
	}
	public List<String> pegarCriaturasRemovidasHistorico() {
		List<String> ret = new ArrayList<String>();
		for(int i=0; i<this.getRemovidas().size(); i++) {
			try {
				ret.add(this.getRemovidas().get(i).getNome());
			}catch(NullPointerException e) {
				System.out.println("aaaa");
			}
		}
		return ret;
	}
	public List<String> pegarCriaturasEditadasHistorico() {
		List<String> ret = new ArrayList<String>();
		for(int i=0; i<this.getEditadas().size(); i++) {
			try {
				ret.add(this.getEditadas().get(i).getNome());
			}catch(NullPointerException e) {
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
