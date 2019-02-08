import java.io.*;

class Q7
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter("bua.txt"));

		String st;
		while((st = br.readLine()) != null)
		{
			bw.write(st);
			bw.newLine();
		}

		bw.close();
	}
}