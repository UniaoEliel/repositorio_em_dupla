package pt.view.viewJogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.view.viewCaverna.IPlotarCaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;

public class ViewJogo2 extends ApplicationAdapter {
	private IViewCaverna caverna;
   private OrthographicCamera camera;
   private SpriteBatch batch;
	
	public void create() {
		caverna = new ViewCaverna();
		caverna.setPixelsX(800);
		caverna.setPixelsY(480);
		caverna.setTamCelula(32);
		
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
		   caverna.plotarCaverna(batch);
		   // manda pra renderizar
		   batch.end();
	}
	
	
	// dealoca as coisas
	   public void dispose() {
	      batch.dispose();
	   }
	
}
