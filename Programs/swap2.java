import java.util.*;
class swap2
{
	public static void main(String args[])
	{
		int a,b,temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		a=sc.nextInt();
		System.out.println("Enter second number");
		b=sc.nextInt();
		temp=a;
		a=b;
		b=temp;
		System.out.println("Swapped numbers are \n First Number :-" + " "+ a +" \n" +"Second Number" + " "+ b);


	}
}