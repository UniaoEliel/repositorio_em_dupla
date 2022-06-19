package pt.view.viewHeroi;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.model.ator.IHeroiProperties;

public class ViewHeroi implements IViewHeroi {
	private int pixelsX, pixelsY;
	
	


	private IHeroiProperties heroi;
	
	
	public void setPixelsX(int pixelsX) {
		this.pixelsX = pixelsX;
	}


	public void setPixelsY(int pixelsY) {
		this.pixelsY = pixelsY;
	}


	public void plotarHeroi(SpriteBatch batch, BitmapFont font) {
		String vida = heroi.getVidaAtual() + " / " + heroi.getVidaTotal();
		// vermelho
		font.setColor(255, 0, 0, 1);
		
		
		font.draw(batch, vida, pixelsX / 10, pixelsY / 10);
		
		
		
	}


	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	public void connect(IHeroiProperties heroi) {
		this.heroi = heroi;
	}
}
