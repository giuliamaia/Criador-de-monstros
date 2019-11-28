package monsterRPG.sistema.dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import monsterRPG.sistema.Nota;

public class RepositorioNotas implements Serializable {

	private static final long serialVersionUID = -7818432385271384758L;

	private List<Nota> notas = new ArrayList<Nota>();

	public static RepositorioNotas INSTANCE = null;

	public List<Nota> getNotas() {
		return notas;
	}

	public static RepositorioNotas getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RepositorioNotas();
		}
		return INSTANCE;
	}

	private RepositorioNotas() {
		try {
			carregarNotas();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void salvarNotas() throws IOException {

		FileOutputStream fos = new FileOutputStream("relogionegro.adc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(notas);
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public void carregarNotas() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("relogionegro.adc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		this.notas = (ArrayList<Nota>) ois.readObject();
		ois.close();

	}

	public void adicionarNota(Nota nota) {
		if (nota != null && notaComNome(nota.getTitulo())==null) {
			this.notas.add(nota);
			try {
				salvarNotas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void removerNota(String titulo) {
		if (notaComNome(titulo) != null) {
			this.notas.remove(notaComNome(titulo));
			try {
				salvarNotas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Nota notaComNome(String nome) {
		for (Nota aux : notas) {
			if (aux.getTitulo().contentEquals(nome)) {
				return aux;
			}
		}
		return null;
	}

	public void editarNota(Nota notaVelha, String notaNova) {
		if (notas.contains(notaVelha)) {
			Nota aux = notaVelha;
			aux.setConteudo(notaNova);

			int index = notas.indexOf(notaVelha);

			removerNota(notaVelha.getTitulo());
			notas.add(index, aux);
			try {
				salvarNotas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Nota> pesquisarNota(String titulo) {
		List<Nota> retorno = new ArrayList<Nota>();
		for (Nota aux : this.notas) {
			if (aux.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				retorno.add(aux);
			}
		}
		return retorno;
	}

	public void imprimirNota() {
		for (Nota n : notas) {
			System.out.println(n.getTitulo());
			System.out.println(n.getConteudo());
		}
	}
}
