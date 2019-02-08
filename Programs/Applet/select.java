import java.awt.*;
import java.awt.event.*;
public class select extends Frame implements ItemListener
{
	Label l,l1;
	Choice c;

	select()
	{
		l = new Label("Select Country's Name :-");
		l.setBounds(50,50,200,60);
		add(l);

		l1 = new Label("");
		l1.setBounds(80,400,200,60);
		add(l1);

		c = new Choice();
		c.setBounds(60,100,50,50);
		add(c);
		c.add("India");
		c.add("Sri Lanka");
		c.add("Australia");
		c.add("Spain");
		c.add("England");
		
		c.addItemListener(this);
			
			setVisible(true);
			setSize(800,800);
			setLayout(null);

	}


			public void itemStateChanged(ItemEvent ie){
			
				if(c.getSelectedIndex() != 0)
				l1.setText("Your Country is:-"+ c.getSelectedItem());
				else
				l1.setText("");
				
			}
	
	

	public static void main(String[] args) {
		
		new select();
	}
}