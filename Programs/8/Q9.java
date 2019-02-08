import java.util.*;
import java.io.*;

class Q9
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("foofa.txt"));
		BufferedWriter odd = new BufferedWriter(new FileWriter("odd.txt")),
			even = new BufferedWriter(new FileWriter("even.txt"));

		int lines =1;
		String str;
		while((str=br.readLine()) != null)
		{
			if(lines%2 ==0)
			{
				even.write(str);
				even.newLine();
			}
			else
			{
				odd.write(str);
				odd.newLine();
			}
			lines++;
		}

		even.close();
		odd.close();
	}
}