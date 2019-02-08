import java.util.*;
class armstrong
{
	public static void main(String args[])
	{
		int i,rem,sum,n;
		for(i=1;i<1000;i++)
		{
			sum=0;
			n=i;
			while(n!=0)
			{
				rem=n%10;
				sum+=rem*rem*rem;
				n=n/10;
			}
			if(sum==i)
			{
				System.out.println(i);
			}
		}
	}
}