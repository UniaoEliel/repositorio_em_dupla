package pt.model.inventario;

public class Tocha extends Item {

	private int luz;
	
	public Tocha() {
		this.nome = "tocha";
		luz = 500;
	}
	
	
	public void passarRodada() {
		saiuCelula();
		luz--;
		entrouCelula();
	}

	public void entrouCelula() {
		cave.iluminarCelulas(heroi.getX(), heroi.getY(), (this.luz)/50);

	}

	public void saiuCelula() {
		cave.desiluminarCelulas(heroi.getX(), heroi.getY(), (this.luz)/50);

	}

	public String getNome() {
		return this.nome;
	}
	

}
