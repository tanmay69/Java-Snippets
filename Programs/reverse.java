import java.util.*;
class reverse
{
	public static void main(String args[])
	{
		int rem,no,sum=0,n;
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		while(n!=0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}	
		
			System.out.println("Reverse of the number is "+sum);
		
	}
	

}