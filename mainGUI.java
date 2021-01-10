//Importing Required modules//
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.lang.Math;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/////////////////////////////


////////Arithmetic Frame////////
class ArithmeticGUI extends JFrame implements ActionListener
{
	JButton button[] = new JButton[17];
	JTextField textfield;
	Font f=new Font("Serif", Font.PLAIN, 50);
	String operand;
	public String num="",num1="",num2="";
	ArithmeticGUI()
	{
		super("Arithmetic Calculator");
		
		setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(15, 40, 295, 60);
		textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield.setFont(f);
		
		//Instantiating all JButtons
		for (int i=0;i<=9;i++) 
		{
		button[i]=new JButton(i+"");		
		}
		button[10]=new JButton("+");
		button[11]=new JButton("-");
		button[12]=new JButton("*");
		button[13]=new JButton("/");
		button[14]=new JButton("%");
		button[15]=new JButton("=");
		button[16]=new JButton("C");
		
		//Setting buttons on the frame
		button[16].setBounds(15,100,70,70);
		button[10].setBounds(90,100,70,70);
		button[11].setBounds(165,100,70,70);
		button[0].setBounds(15,175,70,70);
	    button[1].setBounds(90,175,70,70);
		button[2].setBounds(165,175,70,70);
		button[12].setBounds(240,175,70,70);
		button[3].setBounds(15,250,70,70);
		button[4].setBounds(90,250,70,70);
		button[5].setBounds(165,250,70,70);
		button[13].setBounds(240,250,70,70);
		button[6].setBounds(15,325,70,70);
		button[7].setBounds(90,325,70,70);
	    button[8].setBounds(165,325,70,70);
		button[14].setBounds(240,325,70,70);
	    button[9].setBounds(15,400,70,70);
		button[15].setBounds(240,400,70,70);
		
		//Adding the components onto the frame
		add(textfield);
		for(int i=0;i<17;i++) 
		{
			add(button[i]);
		}	
		
		//Adding ActionListener to the JButtons
		for(int i=0;i<17;i++)
		{
			button[i].addActionListener(this);
		}
		
		//Customizing the JBUttons
		for(int i=0;i<10;i++) {
			button[i].setBackground(Color.black);
			button[i].setFont(new Font("Serif", Font.PLAIN, 35));
			button[i].setForeground(Color.cyan);
		}
		for(int i=10;i<17;i++) {
			button[i].setBackground(Color.decode("#AEB6BF"));
			button[i].setFont(new Font("Serif", Font.BOLD, 35));
			button[i].setForeground(Color.black);
		}
	}
	
	//Calculation Method
	public double calmethod(String op,double num1, double num2) 
	{
		double res=0;
		switch(op) {
		case "+": res = num1+num2;
		break;
		case "-": res = num1-num2;
		break;
		case "*": res = num1*num2;
		break;
		case "/": res = num1/num2;
		break;
		case "%": res = num1%num2;
		break;
		}
		return res;
	}	
	
@Override
	public void actionPerformed(ActionEvent e) 
	{
		double res=0;
		String key = e.getActionCommand();
		if(key.equals("0")|key.equals("1")|key.equals("2")|key.equals("3")|key.equals("4")|key.equals("5")|key.equals("6")|key.equals("7")|key.equals("8")|key.equals("9"))
		{
		num+=key;
		textfield.setText(num);
		}
		else if(key.equals("+")|key.equals("-")|key.equals("*")|key.equals("/")|key.equals("%")) 
		{
			operand = key;
			if(!num.equals("")) 
			{
				num1 = num;
				textfield.setText("");
				num="";
			}
			else 
			{
			textfield.setText("error");
			}
	     }
		else if(key.equals("=")) 
		{
			num2=num;
			try 
			{
				if(!num1.equals("") && !num2.equals("")) {
					res = calmethod(operand,Double.parseDouble(num1),Double.parseDouble(num2));
					textfield.setText(res+"");
				}
			}
			catch(NumberFormatException nfe) 
			{
				System.out.println("error");
			}
				num2 = res+"";
				num=num2;
				num1=num2;
				textfield.setText(num1+"");
		}
		else if(key.equals("C")) 
		{
			textfield.setText("");
			num=num1=num2="";
		}
	}
}
/////End of Arithmetic GUI///////


////////Scientific Frame//////////
class ScientificGUI extends JFrame implements ActionListener
{
	JButton button[] = new JButton[16];
	JTextField textfield;
	Font f=new Font("Serif", Font.PLAIN, 50);
	ScientificGUI()
	{
		super("Scientific Calculator");
		setLayout(null);
		textfield = new JTextField();
		textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield.setFont(f);
		
		button[0] = new JButton("sin");
		button[1] = new JButton("cos");
		button[2] = new JButton("tan");
		button[3] = new JButton("sinh");
		button[4] = new JButton("cosh");
		button[5] = new JButton("tanh");
		button[6] = new JButton("asin");
		button[7] = new JButton("acos");
		button[8] = new JButton("atan");
		button[9] = new JButton("log");
		button[10] = new JButton("x^2");
		button[11] = new JButton("x^3");
		button[12] = new JButton("√x");
		button[13] = new JButton("∛x");
		button[14] = new JButton("X!");
		button[15] = new JButton("C");
		
		button[0].setBounds(15,100,70,70);
		button[1].setBounds(90,100,70,70);
		button[2].setBounds(165,100,70,70);
		button[3].setBounds(240,100,70,70);
		button[4].setBounds(15,175,70,70);
	    button[5].setBounds(90,175,70,70);
		button[6].setBounds(165,175,70,70);
		button[7].setBounds(240,175,70,70);
		button[8].setBounds(15,250,70,70);
		button[9].setBounds(90,250,70,70);
		button[10].setBounds(165,250,70,70);
		button[11].setBounds(240,250,70,70);
		button[12].setBounds(15,325,70,70);
		button[13].setBounds(90,325,70,70);
	    button[14].setBounds(165,325,70,70);
		button[15].setBounds(240,325,70,70);
	    
		textfield.setBounds(15, 30, 295, 60);
		
		add(textfield);
		for(int i=0;i<=15;i++)
		{
			add(button[i]);
		}
		
		for(int i=0;i<15;i++) 
		{
		    button[i].setBackground(Color.black);
	//	    button[i].setFont(new Font("Arial", Font.BOLD, 12));
			button[i].setForeground(Color.CYAN);
  		}
		
		button[15].setBackground(Color.decode("#AEB6BF"));
		button[15].setFont(new Font("Serif", Font.BOLD, 35));
		button[15].setForeground(Color.black);
		
		for(int i=0;i<16;i++)
		{
			button[i].addActionListener(this);
		}
	}
	
@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==button[0])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.sin(num)));
			}
		}
		
		else if(e.getSource()==button[1])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.cos(num)));
			}
		}
		
		else if(e.getSource()==button[2])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.tan(num)));
			}
		}
		
		else if(e.getSource()==button[3])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.sinh(num)));
			}
		}
		
		else if(e.getSource()==button[4])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.cosh(num)));
			}
		}
		
		else if(e.getSource()==button[5])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.tanh(num)));
			}
		}
		
		else if(e.getSource()==button[6])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.asin(num)));
			}
		}
		
		else if(e.getSource()==button[7])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.acos(num)));
			}
		}
		
		else if(e.getSource()==button[8])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.atan(num)));
			}
		}
		
		else if(e.getSource()==button[9])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.log(num)));
			}
		}
		
		else if(e.getSource()==button[10])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.pow(num, 2)));
			}
		}
		
		else if(e.getSource()==button[11])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.pow(num, 3)));
			}
		}
		
		else if(e.getSource()==button[12])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.sqrt(num)));
			}
		}
		
		else if(e.getSource()==button[13])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
			double num=Double.parseDouble(textfield.getText());
			textfield.setText(String.format("%.08f",Math.cbrt(num)));
			}
		}
		
		else if(e.getSource()==button[14])
		{
			if(textfield.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Enter a number into TextField");
			}
			else
			{
				int i,fact=1;
				int num=Integer.parseInt(textfield.getText());
				  for(i=1;i<=num;i++){    
				      fact=fact*i;    
				  }  
				  textfield.setText(fact+"");
			}
		}
		
		else if(e.getSource()==button[15])
		{
			textfield.setText("");
		}
	}
}
//////End of Scientific GUI///////

/////UnitConverter Frame/////
class UnitConverterGUI extends JFrame implements ActionListener
{
	JButton button[] = new JButton[12];
	JTextField textfield1;
	JFormattedTextField textfield2;
	JLabel label1,label2,si1,si2;
	Font f=new Font("Serif", Font.PLAIN, 50);
	UnitConverterGUI()
	{
		super("Unit Converter");
		setLayout(null);
		
		NumberFormat nf =NumberFormat.getInstance();
		NumberFormatter nft = new NumberFormatter(nf);
		nft.setAllowsInvalid(false);
		
		textfield1 = new JTextField();
		textfield2= new JFormattedTextField(nft);
		
		textfield1.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield1.setFont(f);
		
		textfield2.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield2.setFont(f);
		textfield2.setEnabled(false);
		
		label1 = new JLabel("From");
		label1.setFont(new Font("Serif", Font.BOLD, 17));
		label2 = new JLabel("To");
		label2.setFont(new Font("Serif", Font.BOLD, 17));
		
		si1 = new JLabel("SI");
		si1.setFont(new Font("Serif", Font.ITALIC, 17));
		si2 = new JLabel("SI");
		si2.setFont(new Font("Serif", Font.ITALIC, 17));

		
		button[0] = new JButton("Rs-$");
		button[1] = new JButton("l-ml");
		button[2] = new JButton("km-m");
		button[3] = new JButton("m-cm");
		button[4] = new JButton("kg-gm");
		button[5] = new JButton("°C-°F");
		button[6] = new JButton("J-kJ");
		button[7] = new JButton("Ac-sq");
		button[8] = new JButton("hr-min");
		button[9] = new JButton("W-kW");
		button[10] = new JButton("gb-mb");
		button[11] = new JButton("  C  ");
			
		label1.setBounds(10,10,295,60);
		add(label1);
		
		textfield1.setBounds(10, 50, 350, 60);
		add(textfield1);
		
		si1.setBounds(20, 90, 295, 60);
		add(si1);
		
		label2.setBounds(10,120,295,60);
		add(label2);
		
		textfield2.setBounds(10, 160, 350, 60);
		add(textfield2);
		
		si2.setBounds(20, 200, 295, 60);
		add(si2);
		
		button[0].setBounds(10,250,80,80);
		button[1].setBounds(100,250,80,80);
		button[2].setBounds(190,250,80,80);
		button[3].setBounds(280,250,80,80);
		
		button[4].setBounds(10,350,80,80);
	    button[5].setBounds(100,350,80,80);
		button[6].setBounds(190,350,80,80);
		button[7].setBounds(280,350,80,80);
		
		button[8].setBounds(10,450,80,80);
		button[9].setBounds(100,450,80,80);
		button[10].setBounds(190,450,80,80);
		button[11].setBounds(280,450,80,80);
		
		add(button[11]);
		for(int i=0;i<11;i++)
		{
			add(button[i]);
		}

		for(int i=0;i<11;i++) 
		{
		    button[i].setBackground(Color.black);
		    button[i].setFont(new Font("Arial", Font.BOLD, 14));
			button[i].setForeground(Color.CYAN);
  		}
		button[11].setBackground(Color.decode("#AEB6BF"));
		button[11].setFont(new Font("Serif", Font.BOLD, 25));
		button[11].setForeground(Color.black);
		
		for(int i=0;i<12;i++)
		{
			button[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//code for Rupee to Dollar converter
		if(e.getSource()==button[0])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
			double num1=Double.parseDouble(textfield1.getText());
			si1.setText("Rs");
			textfield2.setEnabled(true);
			textfield2.setText(String.format("%.03f",num1/73.37));
			textfield2.setEnabled(false);
			si2.setText("$");
			}
		}
		
		//Code for Liter to MilliLister Converter
		else if(e.getSource()==button[1])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("Liter");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*1000));
				textfield2.setEnabled(false);
				si2.setText("milli liter");
			}
		}
		//Code for Kilometer to Meter Converter
		else if(e.getSource()==button[2])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("kilometer");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*1000));
				textfield2.setEnabled(false);
				si2.setText("meter");
			}
		}
		
		//Code for meter to Centimeter Converter
		else if(e.getSource()==button[3])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("meter");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*100));
				textfield2.setEnabled(false);
				si2.setText("Centimeter");
			}
		}
		
		//Code for Kilogram to gram Converter
		else if(e.getSource()==button[4])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("Kilogram");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*1000));
				textfield2.setEnabled(false);
				si2.setText("gram");
			}
		}
		
		//Code for Celsius to Fahrenheit Converter
		else if(e.getSource()==button[5])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("Celsius ");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*32));
				textfield2.setEnabled(false);
				si2.setText("Fahrenheit");
			}
		}
		
		//Code for joules to kilojoules Converter
		else if(e.getSource()==button[6])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
				double num1=Double.parseDouble(textfield1.getText());
				si1.setText("joules ");
				
				textfield2.setEnabled(true);
				textfield2.setText(String.format("%.03f",num1*0.001));
				textfield2.setEnabled(false);
				si2.setText("kilojoules");
			}
		}
		
		//Code for acres  to square feet Converter
		else if(e.getSource()==button[7])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
			double num1=Double.parseDouble(textfield1.getText());
			si1.setText("acres ");

			textfield2.setEnabled(true);
			textfield2.setText(String.format("%.03f",num1*43560));
			textfield2.setEnabled(false);
			si2.setText("square feet");
			}
		}

		//Code for Hours  to Minutes Converter
		else if(e.getSource()==button[8])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
			double num1=Double.parseDouble(textfield1.getText());
			si1.setText("Hour ");
			
			textfield2.setEnabled(true);
			textfield2.setText(String.format("%.03f",num1*60));
			textfield2.setEnabled(false);
			si2.setText("Minute");
			}
		}
		
		//Code for watts  to Kilowatts Converter
		else if(e.getSource()==button[9])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
			double num1=Double.parseDouble(textfield1.getText());
			si1.setText("watts");
			
			textfield2.setEnabled(true);
			textfield2.setText(String.format("%.03f",num1*0.001));
			textfield2.setEnabled(false);
			si2.setText("kilowatt");
			}
		}
		
		//Code for GigaByte to MegaByte Converter
		else if(e.getSource()==button[10])
		{
			if(textfield1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter your input into TextField");
			}
			else
			{
			double num1=Double.parseDouble(textfield1.getText());
			si1.setText("GigaByte");
			
			textfield2.setEnabled(true);
			textfield2.setText(String.format("%.03f",num1*1000));
			textfield2.setEnabled(false);
			si2.setText("MegaByte");
			}
		}
		else if(e.getSource()==button[11])
		{
			si1.setText("SI");
			si2.setText("SI");
			
			textfield1.setText("");
			
			textfield2.setEnabled(true);
			textfield2.setText("0");
			textfield2.setEnabled(false);
		}
	}
}
//////End of UnitConverterGUI	

//////Home_screen Frame creation/////
class mainScreen extends JFrame implements ActionListener
{
	JButton button[]=new JButton[3];
	JLabel label1,label2;
	mainScreen()
	{
		super("Triply Calculator");
		
		//Instantiating and customizing Label
		JLabel label1=new JLabel("Triply Calculator");
		label1.setBounds(100,0,450,100);
		label1.setForeground(Color.decode("#48C9B0"));
		label1.setFont(new Font("Serif", Font.ITALIC, 60));
		
		JLabel label2=new JLabel("Your one place solution for Calculations!");
		label2.setBounds(140,50,650,100);
		label2.setForeground(Color.decode("#AAB7B8"));
		label2.setFont(new Font("Serif", Font.ITALIC, 20));
		
		//Setting the Background of the frame.
		JLabel background=new JLabel(new ImageIcon("E:\\Web Development\\AWT Pic.jpg")); //Change the file path as required
		background.setBounds(0,0,640,640);
		
		//Instantiation of JButton
		button[0]=new JButton("Arithmetic");
		button[1]=new JButton("Scientific");
		button[2]=new JButton("Unit Converter");
		
		button[0].setBounds(40,180,200,150);
		button[1].setBounds(360,180,200,150);
		button[2].setBounds(210,350,200,150);
		
		//Setting Layout of Frame
		setLayout(null);
		
		//Customizing JButton
		button[0].setBackground(Color.black);
		button[0].setFont(new Font("Serif", Font.ITALIC, 30));
		button[0].setForeground(Color.cyan);
		button[0].setBorder(BorderFactory.createLineBorder(Color.decode("#48C9B0")));
				
		button[1].setBackground(Color.black);
		button[1].setFont(new Font("Serif", Font.ITALIC, 30));
		button[1].setForeground(Color.cyan);
		button[1].setBorder(BorderFactory.createLineBorder(Color.decode("#48C9B0")));
		
		button[2].setBackground(Color.black);
		button[2].setFont(new Font("Serif", Font.ITALIC, 30));
		button[2].setForeground(Color.cyan);
		button[2].setBorder(BorderFactory.createLineBorder(Color.decode("#48C9B0")));
		
		//Adding Jlabel to frame
		add(label1);
		add(label2);
		
		//Adding JButton to Frame
		add(button[0]);
		add(button[1]);
		add(button[2]);
		
		//Adding Background to frame
		add(background);
		
		//Adding ActionListener to JButton
		button[0].addActionListener(this);
		button[1].addActionListener(this);
		button[2].addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		if(e.getSource()==button[0])
		{
			ArithmeticGUI ag=new ArithmeticGUI();
			ag.setVisible(true);
			ag.setSize(340,510);
			ag.setBackground(Color.decode("#E5E7E9"));
			ag.setLocationRelativeTo(null);
			ag.setResizable(false);
			ag.getContentPane().setBackground(Color.decode("#D5DBDB"));
			ag.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		else if(e.getSource()==button[1])
		{
			ScientificGUI sg=new ScientificGUI();
			sg.setVisible(true);
			sg.setSize(335,440);
			sg.setBackground(Color.decode("#E5E7E9"));
			sg.setLocationRelativeTo(null);
			sg.setResizable(false);
			sg.getContentPane().setBackground(Color.decode("#D5DBDB"));
			sg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		else if(e.getSource()==button[2])
		{
			UnitConverterGUI ucg=new UnitConverterGUI();
			ucg.setVisible(true);
			ucg.setSize(390,580);
			ucg.setBackground(Color.decode("#E5E7E9"));
			ucg.setLocationRelativeTo(null);
			ucg.setResizable(false);
			ucg.getContentPane().setBackground(Color.decode("#D5DBDB"));
			ucg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}

public class mainGUI 
{
	public static void main(String args[])
	{ 
		mainScreen main=new mainScreen();
		main.setVisible(true);
		main.setSize(600,600);
		main.setLocationRelativeTo(null);
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
