package pokemon.model;

public class Raikou extends Pokemon implements Electric
{
	public Raikou()
	{
		super(243, "Raikou");
	}
	
	public Raikou(String name)
	{
		super(243, name);
	}
	
	public Raikou(int num, String name)
	{
		super(num, name);
	}
	
	public int thunderStorm()
	{
		return 1020;
	}
	
	public int coulombCrush()
	{
		return 3045;
	}

}
