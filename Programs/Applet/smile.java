import java.applet.*;
import java.awt.*;
public class smile extends Applet
{
	int x,y;
	public void init()
	{
		x=285;
		y=250;
	}
	public void paint(Graphics g)
	{
		int flag=0;
		try
		{
			
		    


			   for(int i=0;i<400 && i>-1;)
			    {
					g.clearRect(0,0,1000,1000);
					g.setColor(Color.red);
					g.fillOval(x,y-i,200,200);

					g.setColor(Color.white);												
					g.fillOval(340,320-i,20,20);											

					g.setColor(Color.white);
					g.fillOval(415,320-i,20,20);

					g.setColor(Color.white);
					g.fillArc(355,370-i,60,60,0,-180);

					Thread.sleep(10);

					if(i>200 || flag==1)
					{
						flag=1;
                          i--;
					}
                     else
                     	i++;
			    }
			    flag=0;
			repaint();

		    }
		catch(Exception e)
			{
				System.out.println(e);
			}
		
         
	
}


}