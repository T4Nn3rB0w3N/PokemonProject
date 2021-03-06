package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController appController;
	private PokedexPanel appPanel;
	
	public PokedexFrame(PokedexController appController)
	{
		super();
		this.appController = appController;
		this.appPanel = new PokedexPanel(appController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(900, 900);
		this.setTitle("Pokemon Pokedex");
		this.setResizable(false);
		this.setVisible(true);
	}

}
