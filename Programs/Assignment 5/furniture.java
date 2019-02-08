import java.util.*;
class furniture
{
	Scanner sc = new Scanner(System.in);
	int ch;
	public void printl()
	{
		System.out.println("Select Your Furniture \n 1.Wood \n 2.Metal \n 3.Iron \n 4.Plastic ");
		switch(ch)
		{
			case 1: System.out.println("Wood "); break;
			case 2: System.out.println("Metal "); break;
			case 3: System.out.println("Iron "); break;
			case 4: System.out.println("Plastic "); break;
		}
	}
}

class chair extends furniture
{
	public void printl()
	{
		super(printl);
	}

	public static void main(String[] args) {
		chair c = new chair();
		c.printl();
	}
}
