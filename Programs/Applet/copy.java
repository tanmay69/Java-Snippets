import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class copy extends Applet implements ActionListener
{
	TextField t1 = new TextField(10);
	TextField t2 = new TextField(10);
	

	Label l1 = new Label("Enter Content");
	Label l2 = new Label("Copied Content");
	

	Button b = new Button("Copy Content");
	String n1,n2;

	public void init()
	{
		n1=t1.getText();
		

		add(l1);
		add(t1);

		add(l2);
		add(t2);


		add(b);
		b.addActionListener(this);

		
	

	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == b)
		{
			n2=t1.getText();
			t2.setText(" "+n2);
			t1.setText(" ");
		}
		
		

	}
}