package monsterRPG.sistema.dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import monsterRPG.sistema.Mesa;
import monsterRPG.sistema.MesaInvalidaException;

public class RepositorioMesas implements Serializable {

	private static final long serialVersionUID = 13512341L;
	List<Mesa> mesas = new ArrayList<Mesa>();

	public RepositorioMesas() {
		try {
			carregarMesas();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public List<String> getJogadoresMesa(String mesa) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.mesas.size(); i++) {
			if (this.mesas.get(i).getNome().equals(mesa)) {
				ret = this.mesas.get(i).getJogadores();
			}
		}
		return ret;
	}

	public List<Mesa> pesquisarMesasComNome(String nome) {
		List<Mesa> ret = new ArrayList<Mesa>();
		for (int i = 0; i < this.mesas.size(); i++) {
			if (this.mesas.get(i).getNome().toUpperCase().contains(nome.toUpperCase())) {
				ret.add(this.mesas.get(i));
			}
		}
		return ret;
	}

	public void adicionarMesa(Mesa mesa) throws MesaInvalidaException {
		try {
			this.mesas.add(mesa);
			try {
				salvarMesas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			throw new MesaInvalidaException("Mesa criada não pode ser vazia!");
		}
	}

	public void removerMesa(Mesa mesa) throws MesaInvalidaException {
		try {
			this.mesas.remove(mesa);
			try {
				salvarMesas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			throw new MesaInvalidaException("Deu alguma merda!");
		}
	}

	public void salvarMesas() throws IOException {
		FileOutputStream fos = new FileOutputStream("relogiobranco.bbc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.mesas);
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public void carregarMesas() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("relogiobranco.bbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		this.mesas = (List<Mesa>) ois.readObject();
		ois.close();

	}

	public void editarMesa(Mesa mesa, Mesa mesaNova) throws MesaInvalidaException {
		mesa.setBlocoNotas(mesaNova.getBlocoNotas());
		mesa.setDescriçao(mesaNova.getDescriçao());
		mesa.setJogadores(mesaNova.getJogadores());
		mesa.setMonstros(mesaNova.getMonstros());
		mesa.setNome(mesaNova.getNome());
		try {
			salvarMesas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
