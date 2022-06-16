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
		IAtorObjeto parede;
		viewCave.setPixelsX(800);
		viewCave.setPixelsY(480);
		viewCave.setTamCelula(32);
		// imprime 25 x 15 salas
		
		Heroi heroi = new Heroi();
		
		leitorComandos = new Comando();
		
		cave.setTamX(100);
		cave.setTamY(100);
		
		cave.start();
		
		cave.connect(viewCave);
		heroi.setX(5);
		heroi.setY(5);
		
		heroi.connect(cave);
		
		for (int i = 0; i < 32; i++) {
			parede = AtorObjeto.criarAtorObjeto("parede", 's');
			parede.setX(i);
			parede.setY(14);
			parede.connect(cave);
		}
		
		for (int i = 0; i < 32; i++) {
			parede = AtorObjeto.criarAtorObjeto("parede", 'w');
			parede.setX(i);
			parede.setY(0);
			parede.connect(cave);
		}
		
		
		for (int i = 0; i < 15; i++) {
			parede = AtorObjeto.criarAtorObjeto("parede", 'd');
			parede.setX(0);
			parede.setY(i);
			parede.connect(cave);
		}
		
		for (int i = 0; i < 15; i++) {
			parede = AtorObjeto.criarAtorObjeto("parede", 'a');
			parede.setX(24);
			parede.setY(i);
			parede.connect(cave);
		}
		
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
