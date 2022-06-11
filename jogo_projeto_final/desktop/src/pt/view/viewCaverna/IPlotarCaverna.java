package pt.view.viewCaverna;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IPlotarCaverna {
	public void plotarCaverna(SpriteBatch batch);
	
	/**
	 * desaloca as coisas do libGDX
	 */
	public void dispose();
}
