package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

public class ViewJogo2 extends Game {
	// batch é usado para plotar as coisas na tela
	// devido ao libGDX esse atributo precisa ser public
    public SpriteBatch batch;
   
    private IViewCaverna viewCave;
    private IComando leitorComandos;
    private IMontador montador;
    
    public ICaverna cave;
	
	public void create() {
		criarViewCaverna();

		iniciarJogo();
		batch = new SpriteBatch();
		
		this.setScreen(new TelaJogo(this, leitorComandos));
	}
	
	
	private void iniciarJogo() {
		IHeroi heroi;
		montador = Montador.getInstance();
		cave = montador.criarCaverna();
		heroi = montador.getHeroi();
		viewCave.connect(cave);
		
		leitorComandos = new Comando();
		leitorComandos.connect(heroi);
		
		cave.connect(heroi);
	}
	
	
	private void criarViewCaverna() {
		viewCave = new ViewCaverna();
		
		viewCave.setPixelsX(800);
		viewCave.setPixelsY(480);
		viewCave.setTamCelula(32);
	}
	
	public void render() {
		super.render();
	}
	
	
	// desloca as coisas
	   public void dispose() {
	      batch.dispose();
	      viewCave.dispose();
	   }
	
}
