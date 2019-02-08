import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class greatest extends Applet implements ActionListener
{
	TextField t1 = new TextField(10);
	TextField t2 = new TextField(10);
	TextField t3 = new TextField(10);
	TextField t4 = new TextField(10);

	Label l1 = new Label("Enter First Number");
	Label l2 = new Label("Enter Second Number");
	Label l3 = new Label("Enter Third Number");
	Label l4 = new Label("Greatest Number is");

	Button b = new Button("Greatest");
	int n1,n2,n3;

	public void init()
	{
		n1=Integer.parseInt(getParameter("a"));
		n2=Integer.parseInt(getParameter("b"));
		n3=Integer.parseInt(getParameter("c"));

		add(l1);
		add(t1);

		add(l2);
		add(t2);

		add(l3);
		add(t3);

		add(l4);
		add(t4);

		add(b);
		b.addActionListener(this);

		t1.setText(" "+n1);
		t2.setText(" "+n2);
		t3.setText(" "+n3);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(n1>n2 && n1>n3)
		{
			t4.setText(" "+n1);
		}
		else if(n2>n3 && n2>n1)
		{
			t4.setText(" "+n2);
		}
		else
		{
			t4.setText(" "+n3);
		}
		
		

	}
}