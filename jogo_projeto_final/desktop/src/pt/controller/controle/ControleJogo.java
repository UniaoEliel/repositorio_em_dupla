package pt.controller.controle;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.controller.comando.Comando;
import pt.controller.comando.IComando;
import pt.controller.montador.IMontador;
import pt.controller.montador.Montador;
import pt.model.ator.IHeroi;
import pt.model.caverna.ICaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;
import pt.view.viewHeroi.IViewHeroi;
import pt.view.viewHeroi.ViewHeroi;
/**
 * Facade do jogo
 * @author ra247057
 *
 */
public class ControleJogo implements IControleJogo {
	
	private static final ControleJogo instance = new ControleJogo();
	
	
	private IComando leitorComandos;
	private IHeroi heroi;
	private IViewCaverna viewCave;
    private IViewHeroi viewHeroi;
    private IMontador montador;
    private ICaverna cave;
    // tamanho da tela
    private int pixelsX = 800, pixelsY = 480;
	
	
	private ControleJogo() {
	}
	
	public static ControleJogo getInstance() {
		return instance;
	}
	
	
	private void criarViewCaverna() {
		viewCave = new ViewCaverna();
		
		viewCave.setPixelsX(pixelsX);
		viewCave.setPixelsY(pixelsY);
		viewCave.setTamCelula(32);
	}
	
	
	private void criarViewHeroi() {
		viewHeroi = new ViewHeroi();
		
		viewHeroi.setPixelsX(pixelsX);
		viewHeroi.setPixelsY(pixelsY);
	}
	
	
	private void iniciarModel() {
		montador = Montador.getInstance();
		cave = montador.criarCaverna();
		heroi = montador.getHeroi();
	}
	
	
	private void conectarComponentes() {
		viewCave.connect(cave);
		viewHeroi.connect(heroi);
		leitorComandos.connect(heroi);
		cave.connect(heroi);
	}

	@Override
	public void iniciarJogo() {
		criarViewCaverna();
		criarViewHeroi();
		iniciarModel();
		leitorComandos = new Comando();
		conectarComponentes();
	}

	@Override
	public void passarRodada() {
		leitorComandos.lerComando();
		cave.passarRodada();
	}

	@Override
	public void plotarJogo(SpriteBatch batch, BitmapFont font) {
		viewCave.plotarCaverna(batch, font);
		viewHeroi.plotarHeroi(batch, font);
	}

	@Override
	public boolean perdeu() {
		return heroi.isVivo();
	}

	@Override
	public boolean ganhou() {
		return heroi.ganhou();
	}
	
	
	public void dispose() {
		viewCave.dispose();
	}

}
