package pt.model.inventario;


public class PocaoVida extends Item {

	
	
	public PocaoVida() {
		this.nome = "pocaovida";
	}
	
	
	public void equipar() {
		
	}

	
	public void desequipar() {
	}
	
	public void usar() {
		heroi.setVidaAtual(heroi.getVidaAtual() + 10);
		this.desequipar();
		inventario.removerItem(this);
		cave.inserirNoLog("Heroi usou pocao e recuperou 10 de vida");
	}



	public String getNome() {
		return this.nome;
	}

		
}


