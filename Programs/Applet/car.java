import java.applet.*;
import java.awt.*;
public class car extends Applet
{

	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillPolygon(new int[] {300,500,580,220}, new int[] {300,300,350,350},4);

		g.setColor(Color.blue);
		g.fillPolygon(new int[] {170,650,680,170}, new int[] {350,350,400,400},4);

		g.setColor(Color.black);
		g.fillOval(220,390,30,30);

		g.setColor(Color.black);
		g.fillOval(500,390,30,30);
		
	}
}
