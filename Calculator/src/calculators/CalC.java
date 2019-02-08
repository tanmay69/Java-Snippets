package calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CalC 
{

	private JFrame frame;
	private JTextField txtDisplay;
	
	
	double fNum;
	double sNum;
	double result;
	String operations;
	String answer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					CalC window = new CalC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CalC() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setFont(new Font("Algerian", Font.PLAIN, 25));
		frame.setBounds(100, 100, 269, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(10, 11, 235, 42);
		frame.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		//---------------Row 1----------------
				JButton btnBack = new JButton("\uF0E7");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String backspace = null;
						if(txtDisplay.getText().length() > 0) {
							StringBuilder strB = new StringBuilder(txtDisplay.getText());
							strB.deleteCharAt(txtDisplay.getText().length() - 1);
							backspace = strB.toString();
							txtDisplay.setText(backspace);
						}
					}
				});
				btnBack.setBackground(Color.WHITE);
				btnBack.setFont(new Font("Wingdings", Font.BOLD, 15));
				btnBack.setBounds(10, 73, 55, 50);
				frame.getContentPane().add(btnBack);
				
				JButton btnClear = new JButton("C");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtDisplay.setText(null);
					}
				});
				btnClear.setBackground(Color.WHITE);
				btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnClear.setBounds(70, 73, 55, 50);
				frame.getContentPane().add(btnClear);
				
				JButton btnPerc = new JButton("%");
				btnPerc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						fNum = Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations = "%";
					}
				});
				btnPerc.setBackground(Color.WHITE);
				btnPerc.setFont(new Font("Times New Roman", Font.BOLD, 20));
				btnPerc.setBounds(130, 73, 55, 50);
				frame.getContentPane().add(btnPerc);
				
				JButton btnPlus = new JButton("+");
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						fNum = Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations = "+";
					}
				});
				btnPlus.setBackground(Color.WHITE);
				btnPlus.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnPlus.setBounds(190, 73, 55, 50);
				frame.getContentPane().add(btnPlus);
		
		
		
		//---------------Row 2----------------
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = txtDisplay.getText() + btn7.getText();
				txtDisplay.setText(num);
			}
		});
		btn7.setBackground(Color.WHITE);
		btn7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btn7.setBounds(10, 134, 55, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(num);
			}
		});
		btn8.setBackground(Color.WHITE);
		btn8.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btn8.setBounds(70, 134, 55, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(num);
			}
		});
		btn9.setBackground(Color.WHITE);
		btn9.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btn9.setBounds(130, 134, 55, 50);
		frame.getContentPane().add(btn9);
		
		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-";
			}
		});
		btnSubtract.setBackground(Color.WHITE);
		btnSubtract.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSubtract.setBounds(190, 134, 55, 50);
		frame.getContentPane().add(btnSubtract);
		
		//---------------Row 3----------------
				JButton btn4 = new JButton("4");
				btn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					String num = txtDisplay.getText() + btn4.getText();
					txtDisplay.setText(num);
					}
				});
				btn4.setBackground(Color.WHITE);
				btn4.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn4.setBounds(10, 195, 55, 50);
				frame.getContentPane().add(btn4);
				
				JButton btn5 = new JButton("5");
				btn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btn5.getText();
						txtDisplay.setText(num);
					}
				});
				btn5.setBackground(Color.WHITE);
				btn5.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn5.setBounds(70, 195, 55, 50);
				frame.getContentPane().add(btn5);
				
				JButton btn6 = new JButton("6");
				btn6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btn6.getText();
						txtDisplay.setText(num);
					}
				});
				btn6.setBackground(Color.WHITE);
				btn6.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn6.setBounds(130, 195, 55, 50);
				frame.getContentPane().add(btn6);
				
				JButton btnMul = new JButton("*");
				btnMul.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fNum = Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations = "*";
					}
				});
				btnMul.setBackground(Color.WHITE);
				btnMul.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnMul.setBounds(190, 195, 55, 50);
				frame.getContentPane().add(btnMul);
				
				
				//---------------Row 4----------------
				JButton btn1 = new JButton("1");
				btn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String num = txtDisplay.getText() + btn1.getText();
						txtDisplay.setText(num);
					}
				});
				btn1.setBackground(Color.WHITE);
				btn1.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn1.setBounds(10, 256, 55, 50);
				frame.getContentPane().add(btn1);
				
				JButton btn2 = new JButton("2");
				btn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btn2.getText();
						txtDisplay.setText(num);
					}
				});
				btn2.setBackground(Color.WHITE);
				btn2.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn2.setBounds(70, 256, 55, 50);
				frame.getContentPane().add(btn2);
				
				JButton btn3 = new JButton("3");
				btn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btn3.getText();
						txtDisplay.setText(num);
					}
					
				});
				btn3.setBackground(Color.WHITE);
				btn3.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn3.setBounds(130, 256, 55, 50);
				frame.getContentPane().add(btn3);
				
				JButton btnDiv = new JButton("/");
				btnDiv.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						fNum = Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations = "/";
					}
				});
				btnDiv.setBackground(Color.WHITE);
				btnDiv.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnDiv.setBounds(190, 256, 55, 50);
				frame.getContentPane().add(btnDiv);
				
				//---------------Row 5----------------
				JButton btn0 = new JButton("0");
				btn0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btn0.getText();
						txtDisplay.setText(num);
					}
				});
				btn0.setBackground(Color.WHITE);
				btn0.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btn0.setBounds(10, 317, 55, 50);
				frame.getContentPane().add(btn0);
				
				JButton btnDot = new JButton(".");
				btnDot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num = txtDisplay.getText() + btnDot.getText();
						txtDisplay.setText(num);
					}
				});
				btnDot.setBackground(Color.WHITE);
				btnDot.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnDot.setBounds(70, 317, 55, 50);
				frame.getContentPane().add(btnDot);
				
				JButton btnPM = new JButton("+/-");
				btnPM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
						ops = ops * (-1);
						txtDisplay.setText(String.valueOf(ops));
					}
				});
				btnPM.setBackground(Color.WHITE);
				btnPM.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnPM.setBounds(130, 317, 55, 50);
				frame.getContentPane().add(btnPM);
				
				JButton btnEqual = new JButton("=");
				btnEqual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String answer;
						sNum = Double.parseDouble(txtDisplay.getText());
						
						if (operations == "+")
						{
							result = fNum + sNum;
							answer = String.format("%.2f",result);
							txtDisplay.setText(answer);
						}
						
						else if (operations == "-")
						{
							result = fNum - sNum;
							answer = String.format("%.2f",result);
							txtDisplay.setText(answer);
						}
						
						else if (operations == "*")
						{
							result = fNum * sNum;
							answer = String.format("%.2f",result);
							txtDisplay.setText(answer);
						}
						
						else if (operations == "/")
						{
							result = fNum / sNum;
							answer = String.format("%.2f",result);
							txtDisplay.setText(answer);
						}
						
						else if (operations == "%")
						{
							result = fNum % sNum;
							answer = String.format("%.2f",result);
							txtDisplay.setText(answer);
						}
					}
				});
				btnEqual.setBackground(Color.WHITE);
				btnEqual.setFont(new Font("Times New Roman", Font.BOLD, 25));
				btnEqual.setBounds(190, 317, 55, 50);
				frame.getContentPane().add(btnEqual);
	}
}
