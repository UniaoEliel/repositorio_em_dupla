package pt.model.ator;

public class Lava extends AtorObjeto {
	public Lava() {
		this.tipo = "lava";
		this.solido = true;
	}
	
	@Override
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, 2);
	}
}
