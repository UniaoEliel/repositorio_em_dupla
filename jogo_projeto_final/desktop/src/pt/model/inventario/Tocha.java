package pt.model.inventario;

public class Tocha extends Item {

	private int luz = 100;
	
	public Tocha() {
		this.nome = "tocha";
	}
	
	
	public void passarRodada() {
		luz = luz--;

	}

	public void entrouCelula() {
		cave.iluminarCelulas(heroi.getX(), heroi.getY(), (this.luz)/10);

	}

	public void saiuCelula() {
		cave.desiluminarCelulas(heroi.getX(), heroi.getY(), (this.luz)/10);

	}
	
	public void usar() {
	}


	public void equipar() {
		
	}


	public void desequipar() {
		
	}

	public String getNome() {
		return this.nome;
	}

}
