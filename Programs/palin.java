import java.util.*;
class palin
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
		if(sum==no)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome")
		}
	}
	

}