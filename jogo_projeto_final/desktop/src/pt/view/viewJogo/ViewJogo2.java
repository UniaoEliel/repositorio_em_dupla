package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.controller.comando.Comando;
import pt.controller.comando.IComando;
import pt.controller.montador.IMontador;
import pt.controller.montador.Montador;
import pt.model.ator.AtorObjeto;
import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;
import pt.model.ator.IHeroi;
import pt.model.ator.Heroi;
import pt.model.caverna.Caverna;
import pt.model.caverna.ICaverna;
import pt.view.viewCaverna.IPlotarCaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;
import pt.view.viewHeroi.IViewHeroi;
import pt.view.viewHeroi.ViewHeroi;

public class ViewJogo2 extends Game {
	// batch é usado para plotar as coisas na tela
	// devido ao libGDX esse atributo precisa ser public
    public SpriteBatch batch;
    
    // font é usado para plotar textos na tela
    public BitmapFont font;
   
    private IViewCaverna viewCave;
    private IViewHeroi viewHeroi;
    private IComando leitorComandos;
    private IMontador montador;
    
    private int pixelsX = 800, pixelsY = 480;
    
    public ICaverna cave;
	
	public void create() {
		criarViewCaverna();
		criarViewHeroi();

		iniciarJogo();
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		
		this.setScreen(new TelaJogo(this, leitorComandos));
	}
	
	
	private void iniciarJogo() {
		IHeroi heroi;
		montador = Montador.getInstance();
		cave = montador.criarCaverna();
		heroi = montador.getHeroi();
		viewCave.connect(cave);
		viewHeroi.connect(heroi);
		
		leitorComandos = new Comando();
		leitorComandos.connect(heroi);
		
		cave.connect(heroi);
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
	
	
	public IViewCaverna getViewCave() {
		return viewCave;
	}
	
	
	public IViewHeroi getViewHeroi() {
		return viewHeroi;
	}
	
	public void render() {
		super.render();
	}
	
	
	// desloca as coisas
	   public void dispose() {
	      batch.dispose();
	      font.dispose();
	      viewCave.dispose();
	      
	   }
	
}
