package pt.model.inventario;


public class Espada extends Item {
	private int ataqueEspada = 15;
	public Espada() {
		this.nome = "espada";
		}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void equipar() {
		heroi.setAtaque(heroi.getAtaque() + this.ataqueEspada);
		heroi.setpossuiEspada(true);
		
	}

	@Override
	public void desequipar() {
		heroi.setAtaque(heroi.getAtaque() - this.ataqueEspada);
		heroi.setpossuiEspada(false);
	}
	
	
}
