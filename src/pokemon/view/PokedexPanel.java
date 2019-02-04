package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPanel extends JPanel
{
	private PokedexController appController;
	private JButton updateButton;
	private SpringLayout appLayout;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		updateButton = new JButton("UPDATE");
		
		setupPanel();
		setupLayout();
		setupListeners();	
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(updateButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}

}
