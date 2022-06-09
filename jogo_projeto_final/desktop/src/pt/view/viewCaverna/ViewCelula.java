package pt.view.viewCaverna;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ViewCelula implements IViewCelula {
	// guarda as texturas de cada componente
	private static Map<String, TextureRegion> textures;
	// guarda as prioridades de cada elemento, quanto mais alta
	// mais em cima da tela ele será impresso.
	private static Map<String, Integer> prioridades;
	
	private int luminosidade;
	
	
	protected void plotar(SpriteBatch batch, int x, int y) {
		Texture teste = new Texture(Gdx.files.internal("teste.png"));
		TextureRegion teste2 = new TextureRegion(teste, 0, 0, 32, 32);
		
		batch.draw(teste2, x, y);
	}
	
	
}
