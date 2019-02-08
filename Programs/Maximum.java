import java.util.*;
class Maximum
{
	public static void main(String args[])
	{
		int a,b,c;
		System.out.println("Enter the numbers");
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();

		if(a>b && a>c)
		{
			System.out.println("Maximum number is "+ " "+ a);
		}
		else if(b>a && b>c)
		{
			System.out.println("Maximum number is "+ " "+ b);
		}

		else 
		{
			System.out.println("Maximum number is "+ " "+ c);
		}

	}
}