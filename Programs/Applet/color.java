import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class color extends Applet implements ActionListener
{
	

	Button b1 = new Button("Red");
	Button b2 = new Button("Blue");
	Button b3 = new Button("Green");
	

	public void init()
	{


		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		
	

	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == b1)
		{
			setBackground(Color.red);
		}
		
		if(e.getSource() == b2)
		{
			setBackground(Color.blue);
		}

		if(e.getSource() == b3)
		{
			setBackground(Color.green);
		}
		

	}
}