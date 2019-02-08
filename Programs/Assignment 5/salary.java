import java.util.*;
class employee
{
	static Scanner sc = new Scanner(System.in);
	String name,bday,qua,desi;
	public void get()
	{
		System.out.println("Enter Name :-");
		name=sc.next();
		System.out.println("Enter Birth Date :-");
		bday=sc.next();
		System.out.println("Enter Qualification :-");
		qua=sc.next();
		System.out.println("Enter Designation :-");
		desi=sc.next();

	}
}

class salary extends employee	
{
	int bsal;
	double hra,pf,nsal,da;
	public void calc()
	{
		System.out.println("Enter Basic Salary");
		bsal = sc.nextInt();
		da=bsal/8*100;
		hra=bsal/18*100;
		pf=bsal/14*100;
		nsal=bsal+hra+da-pf;

		
	}

	public void display()
	{
		System.out.println("Name is"+" "+ name);
		System.out.println("Birth Day is"+" "+ bday);
		System.out.println("Qualification is"+" "+ qua);
		System.out.println("Designation is"+" "+ desi);
		System.out.println("Basic Salary is"+" "+ bsal);
		System.out.println("Net Salary is"+" "+ nsal);
	}

	public static void main(String[] args) {
		salary s = new salary();
		s.get();
		s.calc();
		s.display();
	}
}
