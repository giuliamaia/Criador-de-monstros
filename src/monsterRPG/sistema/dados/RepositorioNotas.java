package monsterRPG.sistema.dados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import monsterRPG.sistema.usuario.Nota;

public class RepositorioNotas {
	
	private List<Nota> notas = new ArrayList<Nota>();

	public List<Nota> getNotas() {
		return notas;
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
		this.notas = (ArrayList<Nota>)ois.readObject();
		ois.close();
	
	}
	
	
	
	

}
