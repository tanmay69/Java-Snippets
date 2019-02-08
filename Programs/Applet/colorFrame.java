import java.awt.event.*;
import java.awt.*;

public class colorFrame extends Frame implements ActionListener
{
	Button b1,b2,b3;
	
	colorFrame()
	{
	    b1 = new Button("Red");
	 	b1.setBounds(40,40,40,40);
	 	add(b1);
	 	b1.addActionListener(this);

		b2 = new Button("Blue");
		b2.setBounds(100,40,40,40);
		add(b2);
		b2.addActionListener(this);

		b3 = new Button("Green");
		b3.setBounds(160,40,40,40);
		add(b3);
		b3.addActionListener(this);

		setSize(400,400);
		setLayout(null);
		setVisible(true);


	

	


		
		
		
		
		
		
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

	public static void main(String[] args) {
		new colorFrame();	
	}
}