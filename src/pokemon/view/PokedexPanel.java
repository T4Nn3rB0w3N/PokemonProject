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
	private JButton saveButton;
	
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
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		numberLabel = new JLabel("This pokemon's number is");
		nameLabel = new JLabel("This pokemon's name is");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon's attack level is ");
		enhanceLabel = new JLabel("This pokemon's enhancement level is ");
		healthLabel = new JLabel("This pokemon's health is");
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		changeButton = new JButton("Click here to change the pokevalues");
		saveButton = new JButton("Click to save data");
		pokedexDropdown = new JComboBox<String>();
		
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 6, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, -359, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 49, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 243, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 51, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);	
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 83, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, numberLabel);		
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, numberLabel);		
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 14, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 17, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 15, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, numberLabel);		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 15, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 12, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, numberLabel);		
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -8, SpringLayout.WEST, numberLabel);		
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, -39, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -47, SpringLayout.EAST, this);		
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 27, SpringLayout.SOUTH, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 120, SpringLayout.WEST, this);
		
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
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.savePokedex();
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
