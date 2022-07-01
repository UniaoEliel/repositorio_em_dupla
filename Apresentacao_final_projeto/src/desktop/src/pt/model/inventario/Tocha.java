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
		if (luz == 0)
			inventario.removerItem(this);
		entrouCelula();
	}
	
	
	public void passarRodada(int x, int y) {
		saiuCelula(x, y);
		luz--;
		if (luz <= 0) {
			cave.desiluminarCelulas(x, y, 1);
			cave.removerAtor("itemchao", x, y);
		}
			
		entrouCelula(x, y);
	}
	
	
	public void entrouCelula(int x, int y) {
		cave.iluminarCelulas(x, y, this.luz/50);
	}
	
	public void saiuCelula(int x, int y) {
		cave.desiluminarCelulas(x, y, this.luz/50);
	}

	public void entrouCelula() {
		entrouCelula(heroi.getX(), heroi.getY());

	}

	public void saiuCelula() {
		saiuCelula(heroi.getX(), heroi.getY());

	}

	public String getNome() {
		return this.nome;
	}
	

}
