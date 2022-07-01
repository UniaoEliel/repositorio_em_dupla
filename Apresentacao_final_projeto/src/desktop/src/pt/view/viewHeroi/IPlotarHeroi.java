package pt.view.viewHeroi;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IPlotarHeroi {
	public void plotarHeroi(SpriteBatch batch, BitmapFont font);
	
	/**
	 * desaloca as coisas do libGDX
	 */
	public void dispose();
}
