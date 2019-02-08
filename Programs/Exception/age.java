import java.util.*;
import java.io.*;
class age extends Exception
{
	age (String str)
	{
		super(str);
	}
	public static void main(String args[]) throws IOException
	{
		int ages;
		System.out.println("Enter your age");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ages = Integer.parseInt(br.readLine());
		try
		{
			if(ages<18)
			{
				System.out.println("Age is" + " "+ ages + " "+ "years");
				age a=new age("Invalid age");
				throw a;
			}
			else
			{
				System.out.println("Age is" + " "+ ages + " "+ "years");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}