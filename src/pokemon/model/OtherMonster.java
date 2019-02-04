package pokemon.model;

public class OtherMonster extends Pokemon implements Weird
{
	
	public OtherMonster(int num, String pokename)
	{
		super(num,pokename);
	}
	
	public void spook()
	{
		System.out.println("My spookyness is so high: " + this.getAttackPoints());
	}
	
	public int goofyLevel()
	{
		return this.getHealthPoints();
	}

}
