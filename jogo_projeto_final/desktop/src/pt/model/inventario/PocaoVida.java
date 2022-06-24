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
	}



	public String getNome() {
		return this.nome;
	}

		
}


