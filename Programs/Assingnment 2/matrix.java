import java.util.*;

class matrix
{
	public static void main(String[] args) {
		
		int ch;
		char cho;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter Rows ");
		int row=sc.nextInt();
		System.out.print("\n Enter Columns ");
		int col=sc.nextInt();
		int a[][] = new int[row][col];
		int b[][] = new int[row][col];
		int c[][] = new int[row][col];

        System.out.print("\n Enter 1st Matrix " + row + " row and "  + col +" Column" );
        for(int i=0;i<row;i++)
        {
        	for (int j=0;j<col ;j++ ) {

        		a[i][j]=sc.nextInt();
        		
        	}
        }

         System.out.print("\n Enter 2nd Matrix " + row + " row and "  + col +" Column" );
        for(int i=0;i<row;i++)
        {
        	for (int j=0;j<col ;j++ ) {

        		b[i][j]=sc.nextInt();
        		
        	}
        }

         do
         {
         	System.out.print("\n 1.Addition \n2.Subtraction \n3.Transpose \n Enter Your Choice ");
             ch=sc.nextInt();
             switch (ch) {

             	case 1: 
             	          for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {

             	          		c[i][j]=a[i][j]+b[i][j];
             	          	}
             	          	
             	          }


             	           for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {

             	          		System.out.print(" "+c[i][j]);
             	          	}
             	          	
             	          		System.out.print("\n");
             	          }
             	
             	      break;
 
					 case 2: 
             	          for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {

             	          		c[i][j]=a[i][j]-b[i][j];
             	          	}
             	          	
             	          }


             	           for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {

             	          		System.out.print(" "+c[i][j]);
             	          	}
             	          	
             	          		System.out.print("\n");
             	          }
             	
             	   break;


             	   case 3: 
             	          		System.out.print("\n 1st Matrix \n");
             	          for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {


             	          	System.out.print(" "+a[j][i]);

             	          	}
             	          		System.out.print("\n");
             	          	
             	          }


             	          		System.out.print("\n2nd Matrix \n");
             	           for (int i=0;i<row ;i++ ) {

             	          	for (int j=0; j<col;j++) {

             	          		System.out.print(" "+b[j][i]);
             	          	}
             	          	
             	          		System.out.print("\n");
             	          }
             	
             	   break;

                 }
                 System.out.print("\n Do You Want To Continue ");
                 cho=sc.next().charAt(0);

         }while(cho=='Y' || cho=='y');

         

	}
}