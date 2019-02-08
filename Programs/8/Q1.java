import java.io.*;

class Q1
{
	public static void main(String[] args) throws IOException {
		BufferedReader readmodi = new BufferedReader(new FileReader("modichutiya.txt")),
			readrajnanand = new BufferedReader(new FileReader("rajnandchotahai.txt"));
		BufferedWriter lodalelo = new BufferedWriter(new FileWriter("foofa.txt"));

		String str;
		while((str=readmodi.readLine()) != null)
		{
			lodalelo.write(str);
			lodalelo.newLine();
		}

		while((str=readrajnanand.readLine()) != null)
		{
			lodalelo.write(str);
			lodalelo.newLine();
		}		

		lodalelo.close();
	}
}