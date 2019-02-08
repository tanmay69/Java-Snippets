import java.awt.event.*;
import java.awt.*;

public class check extends Frame implements ItemListener
{
	Label l;
	CheckboxGroup cr = new CheckboxGroup();
	Checkbox c1,c2;
	
	check()
	{
		l = new Label();
		l.setBounds(60,100,50,50);
		add(l);

	    c1 = new Checkbox("Yes",cr,false);
	 	c1.setBounds(40,40,40,40);
	 	add(c1);
	 	c1.addItemListener(this);

		c2 = new Checkbox("No",cr,false);
		c2.setBounds(100,40,40,40);
		add(c2);
		c2.addItemListener(this);


		setSize(400,400);
		setLayout(null);
		setVisible(true);


	

	


		
		
		
		
		
		
	}

		
	

	

	public void itemStateChanged(ItemEvent i)
	{

		if(c1.getState() == true)
		{
			l.setText("Yes");
		}

		if(c2.getState() == true)
		{
			l.setText("No");
		}
		
		
		

	}

	public static void main(String[] args) {
		new check();	
	}
}