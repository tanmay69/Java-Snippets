import java.util.*;
class test
{
	interface college
	{
		void getInfo();
		void displayInfo();
	}

	 abstract static class student implements college
	{
		String name,bday,city,gen,age;
		public void getInfo()
		{
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name:-");
			name=sc.next();
			System.out.println("Enter Birth Date:-");
			bday=sc.next();
			System.out.println("Enter City:-");
			city=sc.next();
			System.out.println("Enter Gender:-");
			gen=sc.next();
			System.out.println("Enter Age:-");
			age=sc.next();
		}

		public void displayInfo()
		{
			System.out.println("Name is"+ " "+ name);
			System.out.println("Birth Date is"+ " "+ bday);
			System.out.println("City is"+ " "+ city);
			System.out.println("Gender is"+ " "+ gen);
			System.out.println("Age is"+ " "+ age);
		}
	}

	public static class BScIT extends student
	{
		void display()
		{
			displayInfo();

			System.out.println("Java");
			System.out.println("C++");
			System.out.println("DS");
		}
	}

	public static class MscIT extends student
	{
		void display()
		{
			displayInfo();

			System.out.println("Python");
			System.out.println("Ruby");
			System.out.println("Swift");
		}
	}

	public static void main(String[] args) {
		
		BScIT bs = new BScIT();
		MscIT ms = new MscIT();
		System.out.println("Enter BScIT Student Details");
		bs.getInfo();
		System.out.println("BScIT Student Details :-");
		bs.display();

		System.out.println("Enter MScIT Student Details");
		ms.getInfo();
		System.out.println("MScIT Student Details :-");
		ms.display();

	}
}