package pt.model.ator;

import pt.model.inventario.IInventario;
import pt.model.inventario.IInventarioProperties;
import pt.model.inventario.IItem;
import pt.model.inventario.Inventario;

public class Heroi extends AtorVivo implements IHeroi {
	private int luz;
	private IInventario inventario;
	private IItem itemSelecionado;
	private boolean vivo;
	private char comandoAtual;
	private boolean ganhou;
	private int numItem;
	


	public Heroi() {
		super();
		tipo = "heroi";
		orientacao = 's';
		luz = 100;
		
		velocidade = 15;
		
		rodadasMover = 5;
		rodadasAtacar = 15;
		
		vidaTotal = 50;
		vidaAtual = 50;
		
		comandoAtual = '*';
		
		defesa = 10;
		ataque = 10;
		inventario = new Inventario();
		inventario.setTamanho(7);
		
		numItem = 1;
		
		vivo = true;
		ganhou = false;
	}


	public void realizarComando(char comando) {
		if (comando == '*')
			comando = '*';
		else if (comando == 'j' && podeAtacar())
			atacarFrente();
		else if ((comando == 'w' ||
				comando == 's' ||
				comando == 'a' ||
				comando == 'd') && podeMover())
			super.mover(comando);
		
		else if (comando == '1')
			setNumItem(1);
		else if (comando == '2')
			setNumItem(2);
		else if (comando == '3')
			setNumItem(3);
		else if (comando == '4')
			setNumItem(4);
		else if (comando == '5')
			setNumItem(5);
		else if (comando == '6')
			setNumItem(6);
		else if (comando == '7')
			setNumItem(7);
		
	}
	
	
	public void passarRodada() {
		super.passarRodada();
		realizarComando(comandoAtual);
		//if (aleatorio.nextInt(5) == 1)
		//movimentoAleatorio();
		
		//receberAtaque(4);
		
		//saiuCelula();
		//luz--;
		//entrouCelula();
		//seMoverEmDirecaoA(0, 0);
		
		//itemSelecionado.passarRodada();
		comandoAtual = '*';
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
	
	
	public void morrer() {
		super.morrer();
		vivo = false;
	}
	
	
	public void setComandoAtual(char comandoAtual) {
		this.comandoAtual = comandoAtual;
	}

	
	public boolean isVivo() {
		return vivo;
	}

	@Override
	public IInventarioProperties getInventario() {
		return inventario;
	}


	@Override
	public boolean ganhou() {
		return ganhou;
	}
	
	
	public int getNumItem() {
		return numItem;
	}
	
	
	public void setNumItem(int numItem) {
		this.numItem = numItem;
		
		//this.itemSelecionado = inventario.getItem(numItem);
		
		//itemSelecionado.equipar();
	}
}
