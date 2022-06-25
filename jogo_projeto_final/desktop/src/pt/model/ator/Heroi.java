package pt.model.ator;

import pt.model.caverna.ICaverna;
import pt.model.inventario.IInventario;
import pt.model.inventario.IInventarioProperties;
import pt.model.inventario.IItem;
import pt.model.inventario.Inventario;
import pt.model.inventario.Tocha;

public class Heroi extends AtorVivo implements IHeroi {
	private int luz;
	private IInventario inventario;
	private IItem itemSelecionado;
	private boolean vivo;
	private char comandoAtual;
	private boolean ganhou;
	private int numItem;
	private boolean possuiEspada;
	


	public Heroi() {
		super();
		tipo = "heroi";
		orientacao = 's';
		luz = 100;
		possuiEspada = false;
		
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
		inventario.connect(this);
		
		vivo = true;
		ganhou = false;
	}


	public void realizarComando(char comando) {
		if (comando == '*')
			comando = '*';
		else if (comando == 'j' && podeAtacar())
			atacarFrente();
		else if (comando == 'k')
			interagirFrente();
		else if (comando == 'l')
			usarItem();
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
	
	
	private void interagirFrente() {
		if (orientacao == 'w')
			interagir(x, y+1);
		else if (orientacao == 's')
			interagir(x, y-1);
		else if (orientacao == 'a')
			interagir(x-1, y);
		else
			interagir(x+1, y);
	}
	
	
	private void interagir(int x, int y) {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
				for (IAtor ator : atores) {
					ator.interagir(this);
				}
			
		}
	}
	
	
	private void usarItem() {
		if (itemSelecionado != null) {
			itemSelecionado.usar();
			setNumItem(this.numItem);
		}
	}
	
	public void passarRodada() {
		super.passarRodada();
		realizarComando(comandoAtual);
		
		
		if (itemSelecionado != null)
			itemSelecionado.passarRodada();
		comandoAtual = '*';
	}
	
	public void mover(char direcao) {
		if (itemSelecionado != null)
			itemSelecionado.saiuCelula();
		super.mover(direcao);
		if (itemSelecionado != null)
			itemSelecionado.entrouCelula();
	}

	
	public void entrouCelula() {
		
		if (itemSelecionado != null)
			itemSelecionado.entrouCelula();
	}

	
	public void saiuCelula() {
		
		if (itemSelecionado != null)
		 itemSelecionado.saiuCelula();
	}


	public void connect(IInventario inventario) {
		this.inventario = inventario;
	}
	
	
	public void connect(ICaverna caverna) {
		this.cave = caverna;
		inventario.connect(cave);
		cave.inserirAtor(this, x, y);
		
		inventario.inserirItem(new Tocha());
		setNumItem(1);
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


	
	public boolean ganhou() {
		return ganhou;
	}
	
	
	public int getNumItem() {
		return numItem;
	}
	
	
	public void setNumItem(int numItem) {
		if (itemSelecionado != null) {
			itemSelecionado.desequipar();
		}

		this.numItem = numItem;
		
		this.itemSelecionado = inventario.getItem(numItem);
		
		if (itemSelecionado != null)
			itemSelecionado.equipar();
	}

	
	public String getNomeItemSelecionado() {
		String nome = "nada";
		if (itemSelecionado != null)
			nome = itemSelecionado.getNome();
		
		return nome;
	}

	
	public void setVidaAtual(int novaVida) {
		if (novaVida <= this.vidaTotal ) {
			this.vidaAtual = novaVida;
		}
		else {
			this.vidaAtual = this.vidaTotal;
		}
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public void setAtaque(int novoAtaque) {
		this.ataque = (novoAtaque);
	}
	
	
	public boolean inventarioContem(String item) {
		return true;
	}
	
	
	public void receberItem(IItem item) {
		inventario.inserirItem(item);
	}
	
	public void setpossuiEspada(boolean x) {
		this.possuiEspada = x;
	}

	public String getNomeRepresentacao() {
		String representacao = tipo;
		
		if (possuiEspada) {
			representacao += "_espada";
		}
		if (orientacao != '-')
			representacao += "_" + orientacao;
	
		return representacao;
	}
}


