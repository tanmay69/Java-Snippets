import java.io.*;

class Q5
{
	public static void main(String[] args) throws IOException {
		try
		{
			String str = args[0];
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(str));
				while((str=br.readLine()) != null)
				{
					System.out.println(str);
				}
			}catch(FileNotFoundException e)
			{
				System.out.println("Modi hai kya?");
			}
		}catch(Exception e)
		{
			System.out.println("Daal to sahi bhosdike");
		}
	}
}