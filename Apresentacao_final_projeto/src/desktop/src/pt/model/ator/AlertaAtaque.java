package pt.model.ator;

public class AlertaAtaque extends AtorAtaque {
	private AtorAtaque ataque;
	
	public AlertaAtaque() {
		super();
		tipo = "alertaataque";
	}

	
	public void setAtaque(AtorAtaque objAtaque) {
		this.ataque = objAtaque;
	}
	
	
	public void saiuCelula() {
		ataque.setX(x);
		ataque.setY(y);
		ataque.setAutor(autor);
		ataque.connect(cave);
	}
}
