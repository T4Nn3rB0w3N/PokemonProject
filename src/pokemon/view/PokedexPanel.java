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
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		
		this.appLayout = new SpringLayout();

		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Pokemon1-entei.jpeg"));
		
		numberField = new JTextField("0");
		nameField = new JTextField("Pokemon Name");
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 87, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -82, SpringLayout.EAST, this);
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -12, SpringLayout.NORTH, enhancementField);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 0, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 74, SpringLayout.EAST, attackField);
		healthField = new JTextField("0");
		
		numberLabel = new JLabel("This pokemon's number is");
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 16, SpringLayout.EAST, enhancementField);
		nameLabel = new JLabel("This pokemon's name is");
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -51, SpringLayout.EAST, this);
		evolveLabel = new JLabel("This pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 245, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, -43, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -183, SpringLayout.EAST, this);
		attackLabel = new JLabel("This pokemon's attack level is ");
		enhanceLabel = new JLabel("This pokemon's enhancement level is ");
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 20, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -130, SpringLayout.EAST, this);
		healthLabel = new JLabel("This pokemon's health is");
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 14, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 71, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 42, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, -6, SpringLayout.NORTH, healthLabel);
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 18, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 18, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 130, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 50, SpringLayout.EAST, imageLabel);
		changeButton = new JButton("Click here to change the pokevalues");
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, -33, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -105, SpringLayout.EAST, this);
		pokedexDropdown = new JComboBox<String>(); // stub
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 53, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -54, SpringLayout.SOUTH, this);
		
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
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			//insert code here
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "ultraball";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
		});
	}
	
		

}
