package pt.view.viewHeroi;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.model.inventario.IInventarioProperties;

public class ViewInventario {
	private IInventarioProperties inventario;


	protected void connect(IInventarioProperties inventario) {
		this.inventario = inventario;
	}
	
	
	protected void plotarInventario(SpriteBatch batch, BitmapFont font) {
		// TODO
	}
}
