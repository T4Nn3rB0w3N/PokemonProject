package pokemon.model;
import javax.swing.JOptionPane;

public class Mewtwo extends Pokemon implements Psychic
{
	public Mewtwo()
	{
		super(150, "Mewtwo");
	}
	
	public Mewtwo(String name)
	{
		super(150, name);
	}
	
	public Mewtwo(int num, String name)
	{
		super(num, name);
	}
	
	public int mindCrush()
	{
		return 2000 * 40;
	}
	
	public void readMind()
	{
		JOptionPane.showMessageDialog(null, "The mind has been read. All is clear. Now think of something else.");
	}
	
	public int illusion()
	{
		return 1100;
	}

}
