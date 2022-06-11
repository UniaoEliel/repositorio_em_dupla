package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.controller.comando.Comando;
import pt.controller.comando.IComando;
import pt.model.ator.AtorObjeto;
import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;
import pt.model.ator.Heroi;
import pt.model.caverna.Caverna;
import pt.model.caverna.ICaverna;
import pt.view.viewCaverna.IPlotarCaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;

public class ViewJogo2 extends Game {
	public IViewCaverna viewCave;
    public SpriteBatch batch;
    private IComando leitorComandos;
	
	public void create() {
		ICaverna cave = new Caverna();
		viewCave = new ViewCaverna();
		viewCave.setPixelsX(800);
		viewCave.setPixelsY(480);
		viewCave.setTamCelula(32);
		// imprime 32 x 15 salas
		
		Heroi heroi = new Heroi();
		leitorComandos = new Comando();
		
		cave.setTamX(100);
		cave.setTamY(100);
		
		cave.start();
		
		cave.connect(viewCave);
		
		heroi.connect(cave);
		
		leitorComandos.connect(heroi);
      
		batch = new SpriteBatch();
		
		this.setScreen(new TelaJogo(this, leitorComandos));
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
