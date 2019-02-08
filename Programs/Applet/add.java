import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class add extends Applet implements ActionListener
{
	TextField t1 = new TextField(10);
	TextField t2 = new TextField(10);
	TextField t3 = new TextField(10);

	Label l1 = new Label("Enter First Number");
	Label l2 = new Label("Enter Second Number");
	Label l3 = new Label("Addition is");

	Button b = new Button("Add");
	int n1,n2;

	public void init()
	{
		n1 = Integer.parseInt(getParameter("a"));
    	n2 = Integer.parseInt(getParameter("b"));

		add(l1);
		add(t1);
		add(l2);
		
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
			
			t3.setText(" " +(n1+n2));
		}
	}
}
