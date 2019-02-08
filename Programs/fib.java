import java.util.*;
class fib
{
	public static void main(String args[])
	{
		int x=0,y=1,c,z=0;
		System.out.println("Enter number of elements");
		Scanner sc = new Scanner(System.in);
		c=sc.nextInt();
		System.out.println( x + "\n" + y);
		for(int i=0;i<c;i++)
		{
            z=x+y;
            x=y;
            y=z;
            System.out.println(z);

		}
		

	}
}