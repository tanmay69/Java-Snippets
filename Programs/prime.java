import java.util.*;
class prime
{
	public static void main(String args[])
	{
		int f=0,n,i,a,b,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first limit");
		a=sc.nextInt();
		System.out.println("Enter the last limit");
		b=sc.nextInt();
		
		
		for(i=a;i<=b;i++)
		{
			for(j=2;j<i;j++){

			if(i%j==0)
				break;	
			}
			if(i==j)
				System.out.print(" " + i);
			
		}	
		




	}
}