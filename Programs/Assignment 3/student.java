import java.util.*;
class student1
{
	int sum=0;
	double avg;
	public void calc_perc(int a,int b,int c)
	{
		sum=a+b+c;
		avg=sum/3;

	}

	public void disp_perc()
	{
		System.out.println("Percentage is"+ " "+avg);
		
	}

	
}

class student
{
	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int c=Integer.parseInt(args[2]);
		student1 s = new student1();
		s.calc_perc(a,b,c);
		s.disp_perc();

	}
}