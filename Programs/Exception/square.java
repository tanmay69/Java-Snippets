import java.util.*;
class square
{
	public static void main(String args[])
	{
		try
		{
			check(Integer.parseInt(args[0]));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void check(int a)
	{
		System.out.println("Square is"+ " "+ a*a);
	}
}