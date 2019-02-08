import java.util.*;
class average1
{
	double avg;
	average1(int a,int b)
	{
		avg = (a+b)/2;
		System.out.println("Average is"+ " "+ avg);

	}

	 average1(int a,int b,int c)
	{
		avg = (a+b+c)/3;	
		System.out.println("Average is"+ " "+ avg);	
	}

	
}

class average
{
	public static void main(String[] args) {
		if(args.length == 2)
		{
			
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
			average1 a1 = new average1(a,b);
			
		}
		else if(args.length == 3)
		{
			
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
			int c=Integer.parseInt(args[2]);
			average1 a2 = new average1(a,b,c);
			
		}
		else
			System.out.println("Error");

	}
}