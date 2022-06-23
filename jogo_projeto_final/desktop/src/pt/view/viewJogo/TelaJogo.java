package pt.view.viewJogo;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import pt.model.ator.IAtorVivo;
import pt.model.ator.IHeroi;
import pt.controller.comando.IComando;
import pt.controller.controle.ControleJogo;
import pt.controller.controle.IControleJogo;
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
	private IControleJogo controleJogo;
	public SpriteBatch batch;
    
    // font é usado para plotar textos na tela
    public BitmapFont font;
	OrthographicCamera camera;
	
	
	
	public TelaJogo(final ViewJogo2 jogo) {
		this.jogo = jogo;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		controleJogo = ControleJogo.getInstance();
		
		batch = jogo.getBatch();
		font = jogo.getFont();
	}

	/**
	 * Renderiza a tela, é chamada toda vez que um loop do jogo se passa
	 */
	public void render(float delta) {
		// limpa a tela, os 3 primeiros valores sao RGB
		
	  
	   
	   // seta pra usar as coord da camera
	   batch.setProjectionMatrix(camera.combined);
	   // comeca uma tela
	   batch.begin();
	   
	   if (controleJogo.perdeu()) {
		   font.draw(batch, "Voce perdeu", 100, 100);
	   } else if (controleJogo.ganhou()) {
		   font.draw(batch, "Voce ganhou", 100, 100);
	   } else {
		   controleJogo.passarRodada();
		   controleJogo.plotarJogo(batch, font);
	   }

	   batch.end();
	   
	}

	
	@Override
	public void dispose() {
		controleJogo.dispose();
	}


	@Override
	public void show() {
		controleJogo.iniciarJogo();
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
