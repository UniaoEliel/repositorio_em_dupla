package pt.view.viewJogo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ViewJogo2 extends Game {
	// batch é usado para plotar as coisas na tela
	// devido ao libGDX esse atributo precisa ser public
    public SpriteBatch batch;
    
    // font é usado para plotar textos na tela
    public BitmapFont font;
    
    private int pixelsX = 800, pixelsY = 480;
	
	public void create() {
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		
		this.setScreen(new TelaJogo(this));
	}
	
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	
	public BitmapFont getFont() {
		return font;
	}

	
	public void render() {
		super.render();
	}
	
	
	// desloca as coisas
	   public void dispose() {
	      batch.dispose();
	      font.dispose();
	      
	   }
	
}
