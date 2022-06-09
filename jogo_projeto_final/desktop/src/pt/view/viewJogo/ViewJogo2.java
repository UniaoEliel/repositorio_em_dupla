package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
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

public class ViewJogo2 extends ApplicationAdapter {
	private IViewCaverna viewCave;
   private OrthographicCamera camera;
   private SpriteBatch batch;
	
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
		
		cave.inserirAtorVivo(heroi, 100, 100);
		
		camera = new OrthographicCamera();
      // fixa a quantidade de pixels que aparecem
		camera.setToOrtho(false, 800, 480);
      
		batch = new SpriteBatch();
	}
	
	public void render() {
		   // limpa a tela, os 3 primeiros valores sao RGB
		   ScreenUtils.clear(0, 0, 0.2f, 1);
		   
		   camera.update();
		   
		   // seta pra usar as coord da camera
		   batch.setProjectionMatrix(camera.combined);
		   // comeca uma tela
		   batch.begin();
		   // coloca as coisas na tela
		   viewCave.plotarCaverna(batch);
		   // manda pra renderizar
		   batch.end();
	}
	
	
	// dealoca as coisas
	   public void dispose() {
	      batch.dispose();
	   }
	
}
