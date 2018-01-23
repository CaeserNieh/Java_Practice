import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class HW11JFrame extends JFrame implements ActionListener {

	JTextArea contents = new JTextArea();
	
	JButton function_1 = new JButton();
	JButton function_2 = new JButton();
	JButton function_3 = new JButton();
	JButton function_4 = new JButton();
	
		
	// use Jlabel to add background into JFrame
	ImageIcon background = new ImageIcon("background.jpg");
	
	JLabel Back = new JLabel(background);
	JLabel label = new JLabel();
	JLabel label_information = new JLabel();
	
	JScrollPane scrollpane;
	
	
	/* constructor */
	public HW11JFrame(){
		// setting JFrame
		this.setTitle("Practice JAVA HW11");
		this.setSize(500, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//set the application in the middle of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height)/2);
		
		Back.setBounds((dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height)/2,background.getIconWidth(),background.getIconHeight());
		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		
		function_1.setText("Start");
		function_1.setBounds(75, 25, 100, 50);
		function_1.setFont(new Font(null,Font.BOLD,16));
		function_1.setForeground(Color.WHITE);
		function_1.setBackground(Color.BLACK);
		
		function_2.setText("Help");
		function_2.setBounds(175, 25, 150, 50);
		function_2.setFont(new Font(null,Font.BOLD,16));
		function_2.setForeground(Color.WHITE);
		function_2.setBackground(Color.BLACK);
		
		function_3.setText("Exit");
		function_3.setBounds(325, 25, 100, 50);
		function_3.setFont(new Font(null,Font.BOLD,16));
		function_3.setForeground(Color.WHITE);
		function_3.setBackground(Color.BLACK);
		
		this.add(function_1);
		this.add(function_2);
		this.add(function_3);
		
		function_1.addActionListener(this);
		function_2.addActionListener(this);
		function_3.addActionListener(this);
		
		label.setText("Book System");
		label.setBounds(200,100,150,50);
		label.setFont(new Font(null,Font.BOLD,16));
		label.setForeground(Color.BLACK);
		
		
		this.add(label);
		this.add(Back);
	
	}// HW11JFrmae constructor
	
	

	
	
	@Override
	public void actionPerformed(ActionEvent choice) {
		// TODO Auto-generated method stub
		if(choice.getSource() == function_1){
			HW11_Begin book = new HW11_Begin();
		}
		else if(choice.getSource() == function_2){
			
		}
		else if(choice.getSource() == function_3){
			System.exit(EXIT_ON_CLOSE);
		}
		
	}
	
}
