import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class tax extends Applet implements ActionListener
{
	TextField t1 = new TextField(10);
	TextField t2 = new TextField(10);
	TextField t3 = new TextField(10);

	Label l1 = new Label("Enter Name");
	Label l2 = new Label("Enter Salary");
	Label l3 = new Label("Tax is");

	Button b = new Button("Calculate");
	int n2;
	String n1;

	public void init()
	{
		add(l1);
		add(t1);
		add(l2);
     
			 n2 = Integer.parseInt(getParameter("b"));
			  n1 = getParameter("a");
		add(t2);
		add(l3);
		add(t3);

		add(b);
		t1.setText(" " + n1);
        t2.setText(" " + n2);
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b)
		{
			
			t3.setText(" " + ( n2 /10));
		}
	}

}