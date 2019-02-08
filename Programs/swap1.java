import java.util.*;
class swap1
{
	public static void main(String args[])
	{
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		a=sc.nextInt();
		System.out.println("Enter second number");
		b=sc.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Swapped numbers are \n First Number :-" + " "+ a +" \n" +"Second Number" + " "+ b);


	}
}