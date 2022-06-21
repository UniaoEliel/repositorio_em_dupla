package pt.model.ator;

import pt.model.inventario.IInventario;
import pt.model.inventario.IInventarioProperties;
import pt.model.inventario.IItem;
import pt.model.inventario.Inventario;

public class Heroi extends AtorVivo implements IHeroi {
	private int luz;
	private IInventario inventario;
	private IItem itemSelecionado;

	public Heroi() {
		super();
		tipo = "heroi";
		orientacao = 's';
		luz = 100;
		
		velocidade = 10;
		
		vidaTotal = 50;
		vidaAtual = 40;
		
		defesa = 10;
		
		inventario = new Inventario();
	}


	public void realizarComando(char comando) {
		super.mover(comando);
	}
	
	
	public void passarRodada() {
		//if (aleatorio.nextInt(5) == 1)
		//movimentoAleatorio();
		
		//receberAtaque(4);
		
		//saiuCelula();
		//luz--;
		//entrouCelula();
		//seMoverEmDirecaoA(0, 0);
		
		//itemSelecionado.passarRodada();
	}

	
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, luz / 10);
		
		//itemSelecionado.entrouCelula();
	}
	
	public void saiuCelula() {
		cave.desiluminarCelulas(x, y, luz / 10);
		
		//itemSelecionado.saiuCelula();
	}


	public void connect(IInventario inventario) {
		this.inventario = inventario;
	}


	@Override
	public IInventarioProperties getInventario() {
		return inventario;
	}
}
