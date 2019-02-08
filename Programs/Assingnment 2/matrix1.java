import java.util.*;
class matrix1
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		char cho;
		System.out.println("Enter the number of rows");
		int rows = sc.nextInt();
		System.out.println("Enter the number of columns");
		int col = sc.nextInt();
		int a[][] = new int[rows][col];
		int b[][] = new int[rows][col];
		int c[][] = new int[rows][col];

		System.out.println("Enter the first matrix of"+ " "+ rows+ "rows "+" "+ "and"+ " "+ col+ " "+ "columns");

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}

		System.out.println("Enter the second matrix of"+ " "+ rows+ "rows "+" "+ "and"+ " "+ col+ " "+ "columns");

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				b[i][j]=sc.nextInt();
			}
		}

		do
		{
			System.out.println("Enter your choice \n 1.Addition \n 2.Subtraction \n 3.Transpose");
			ch=sc.nextInt();

			switch(ch)
			{
				case 1 :
				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						c[i][j]= a[i][j] + b[i][j];
					}
				}

				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.println(" "+c[i][j]);
					}
					System.out.println("\n");
				}
				break;

				case 2 :
				
					for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						c[i][j]= a[i][j] - b[i][j];
					}
				}

				

				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.println(" "+c[i][j]);
					}
					System.out.println("\n");
				}
				break;

				case 3:
				System.out.println("First Matrix is");
				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.println(" "+a[j][i]);
					}
					System.out.println("\n");
				}
				
				System.out.println("Second Matrix is");
				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.println(" "+b[j][i]);
					}
					System.out.println("\n");
				}
				break;

			}
			System.out.println("Do You Want to continue");
			cho = sc.next().charAt(0);
		}while(cho == 'Y' || cho == 'y');

	}
}