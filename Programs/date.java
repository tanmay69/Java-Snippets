import java.util.*;
class date
{
	public static void main(String args[])
	{
		int day,month,year,age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter date");
		day=sc.nextInt();
		System.out.println("Enter month");
		month=sc.nextInt();
		System.out.println("Enter year");
		year=sc.nextInt();
		age = 2017 - year;
		System.out.println("Age is "+ " "+age + " " + "years");




	}
}