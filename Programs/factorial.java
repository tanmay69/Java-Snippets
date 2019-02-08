import java.util.*;
class factorial
{
	public static void main(String args[])
	{
		int rem=1,n,no;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		n=sc.nextInt();
		while(n!=0)
		{
			rem=rem*n;
			n--;
		}
		System.out.println(rem);



	}
}