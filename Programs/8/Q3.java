import java.util.*;
import java.io.*;

class Q3
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileReader("foofa.txt"));

		int words=0,lines=0;

		while(sc.hasNext())
		{
			sc.next();
			words++;
		}

		sc = new Scanner(new FileReader("foofa.txt"));

		while(sc.hasNextLine())
		{
			sc.nextLine();
			lines++;
		}

		System.out.println("Lines :- "+lines+
			"\nWords :- "+words);
	}
}