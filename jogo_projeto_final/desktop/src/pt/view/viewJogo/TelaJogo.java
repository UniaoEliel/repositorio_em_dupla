package pt.view.viewJogo;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.model.ator.IAtorVivo;
import pt.controller.comando.IComando;
import pt.model.ator.Heroi;
import pt.model.caverna.Caverna;
import pt.model.caverna.ICaverna;
import pt.view.viewCaverna.IViewCaverna;
import pt.view.viewCaverna.ViewCaverna;
/**
 * Define a tela principal do jogo, onde está a caverna
 * @author elias
 *
 */
public class TelaJogo implements Screen {
	private final ViewJogo2 jogo;
	private IComando leitorComandos;
	OrthographicCamera camera;
	
	
	
	public TelaJogo(final ViewJogo2 jogo, IComando leitorComandos) {
		this.jogo = jogo;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		this.leitorComandos = leitorComandos;
	}

	/**
	 * Renderiza a tela, é chamada toda vez que um loop do jogo se passa
	 */
	public void render(float delta) {
		// limpa a tela, os 3 primeiros valores sao RGB
		leitorComandos.lerComando();
	   ScreenUtils.clear(0, 0, 0, 1);
	   
	   camera.update();
	   
	   jogo.cave.passarRodada();
	   
	   // seta pra usar as coord da camera
	   jogo.batch.setProjectionMatrix(camera.combined);
	   // comeca uma tela
	   jogo.batch.begin();
	   // coloca as coisas na tela
	   jogo.getViewCave().plotarCaverna(jogo.batch);
	   
	   jogo.getViewHeroi().plotarHeroi(jogo.batch, jogo.font);
	   // manda pra renderizar
	   jogo.batch.end();
	   
	   
	}

	
	@Override
	public void dispose() {
	}


	@Override
	public void show() {
	}
	

	
	
	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}
	@Override
	public void resize(int width, int height) {
	}

}
