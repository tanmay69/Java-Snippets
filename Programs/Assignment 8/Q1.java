import java.io.*;
class Q1
{
	public static void main(String[] args) throws IOException
	{
		String str;
		File f1 = new File("yess.txt");
		File f2 = new File("yess1.txt");
		BufferedReader br = new BufferedReader(new FileReader("yess.txt")),
		 br1 = new BufferedReader(new FileReader("yess1.txt"));

		BufferedWriter bw = new BufferedWriter(new FileWriter("nooo.txt"));

		while((str = br.readLine()) != null)
		{
			bw.write(str);
			bw.newLine();
		}

		while((str = br1.readLine()) != null)
		{
			bw.write(str);
			bw.newLine();
		}
		bw.close();
	
	}
}