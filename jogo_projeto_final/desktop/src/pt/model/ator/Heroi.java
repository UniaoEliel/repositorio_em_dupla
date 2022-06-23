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

	


	public Heroi() {
		super();
		tipo = "heroi";
		orientacao = 's';
		luz = 100;
		
		velocidade = 15;
		
		rodadasMover = 5;
		rodadasAtacar = 15;
		
		vidaTotal = 50;
		vidaAtual = 50000;
		
		comandoAtual = '*';
		
		defesa = 10;
		ataque = 10;
		inventario = new Inventario();
		
		vivo = true;
		ganhou = false;
	}


	public void realizarComando(char comando) {
		if (comando == '*')
			comando = '*';
		else if (comando == 'p' && podeAtacar())
			atacarFrente();
		else if (podeMover())
			super.mover(comando);

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
}
