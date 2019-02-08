import java.util.*;
class sort
{
	public static void main(String args[])
	{
		int a[] = new int[10];
		int i,temp,n,j;
		System.out.println("Enter the number of elements");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		System.out.println("Enter the elements");
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(a[j]>a[i])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("Sorted array is:-");
		for(i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}

	}
}