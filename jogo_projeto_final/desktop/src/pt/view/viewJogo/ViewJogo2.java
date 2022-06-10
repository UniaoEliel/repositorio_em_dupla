package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.model.ator.AtorObjeto;
import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;
import pt.model.ator.Jogador;
import pt.model.caverna.Caverna;
import pt.model.caverna.ICaverna;
import pt.view.viewCaverna.IPlotarCaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;

public class ViewJogo2 extends Game {
	public IViewCaverna viewCave;
    public SpriteBatch batch;
	
	public void create() {
		ICaverna cave = new Caverna();
		viewCave = new ViewCaverna();
		viewCave.setPixelsX(800);
		viewCave.setPixelsY(480);
		viewCave.setTamCelula(32);
		// imprime 32 x 15 salas
		
		IAtorVivo heroi = new Jogador();
		
		cave.setTamX(100);
		cave.setTamY(100);
		
		cave.start();
		
		cave.connect(viewCave);
		
		cave.inserirAtorVivo(heroi, 5, 10);
		
      
		batch = new SpriteBatch();
		
		this.setScreen(new TelaJogo(this));
	}
	
	public void render() {
		super.render();
	}
	
	
	// dealoca as coisas
	   public void dispose() {
	      batch.dispose();
	   }
	
}
