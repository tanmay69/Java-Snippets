import java.util.*;
class array
{
	public static void main(String args[])
	{
		int n,i;
		int a[] = new int[10];
		System.out.println("Enter Number");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			
		}

		for(int j=0;j<n;j++)
		{
			
			System.out.println(a[j]);
		}
		
	}

}