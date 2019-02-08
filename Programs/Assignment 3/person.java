import java.util.*;
class person1
{
	String name,gender,address,city,age;
	public void acceptData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name");
		name=sc.next();
		System.out.println("Enter Your Gender");
		gender=sc.next();
		System.out.println("Enter Your Address");
		address=sc.next();
		System.out.println("Enter Your City");
		city=sc.next();
		System.out.println("Enter Your Age");
		age=sc.next();

	}

	public void displayData()
	{
		System.out.println("Name is"+ " "+name);
		System.out.println("Gender is"+ " "+gender);
		System.out.println("Address is"+ " "+address);
		System.out.println("City is"+ " "+city);
		System.out.println("Age is"+ " "+age);
	}

	
}

class person
{
	public static void main(String[] args) {
		person1 p = new person1();
		p.acceptData();
		p.displayData();
	}
}