import java.util.*;
class customer1
{
	int id;
	String name;
	long number;
	public void accept_Info(int a,String b,long c)
	{
		id=a;
		name=b;
		number=c;

	}

	public void display_Info()
	{
		System.out.println("Customer's Id is"+ " "+ id);
		System.out.println("Customer's Name is"+ " "+ name);
		System.out.println("Customer's Id is"+ " "+ number);		
	}

	
}

class customer
{
	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		String b=(args[1]);
		long c=Long.parseLong(args[2]);
		customer1 c1 = new customer1();
		c1.accept_Info(a,b,c);
		c1.display_Info();

	}
}