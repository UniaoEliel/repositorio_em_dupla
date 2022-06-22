package pt.view.viewCaverna;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IPlotarCaverna {
	public void plotarCaverna(SpriteBatch batch, BitmapFont font);
	
	/**
	 * desaloca as coisas do libGDX
	 */
	public void dispose();
}
