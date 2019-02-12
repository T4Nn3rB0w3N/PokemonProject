package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private SpringLayout appLayout;
	
	private JComboBox <String> pokedexDropdown;
	private JButton changeButton;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		
		numberField = new JTextField("0");
		nameField = new JTextField("Pokemon Name");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		numberLabel = new JLabel("This pokemon's number is");
		nameLabel = new JLabel("This pokemon's name is");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon's attack level is ");
		enhanceLabel = new JLabel("This pokemon's enhancement level is ");
		healthLabel = new JLabel("This pokemon's health is");
		imageLabel = new JLabel("pokemon goes here");
		
		appLayout = new SpringLayout();
		changeButton = new JButton("Click here to change the pokevalues");
		pokedexDropdown = new JComboBox<String>(); // stub
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();	
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel <String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);	
		this.add(pokedexDropdown);
		this.add(changeButton);
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}

}
