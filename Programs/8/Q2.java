import java.io.*;

class Q2
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("foofa.txt"));
		
		int count=0;
		String str;
		while((str=br.readLine()) !=null)
		{
			count = count + str.length();
		}		

		System.out.println("Count Characters = "+count);
	}
}