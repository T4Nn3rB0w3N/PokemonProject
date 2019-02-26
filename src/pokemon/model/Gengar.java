package pokemon.model;

public class Gengar extends Pokemon implements Ghost
{
	public Gengar()
	{
		super(100, "Gengar");
	}
	
	public Gengar(String name)
	{
		super(100, name);
	}
	
	public Gengar(int num, String name)
	{
		super(num, name);
	}

}
