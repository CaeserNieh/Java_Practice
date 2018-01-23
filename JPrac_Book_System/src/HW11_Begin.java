import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class HW11_Begin extends JFrame implements ActionListener {

	JMenu menu1 = new JMenu("Book System");
	JMenu menu2 = new JMenu("Book List");
	JMenuBar menu_bar;
	
	JButton function_1 = new JButton();
	JButton function_2 = new JButton();
	
	JDesktopPane desktop;
	
	JMenuItem exit = new JMenuItem("exit");
	JMenuItem exposition = new JMenuItem("exposition");
	
	JMenuItem Reference = new JMenuItem("Reference book");
	JMenuItem Magazine = new JMenuItem("Magazine");
	JMenuItem Literature = new JMenuItem("Literature");
	JMenuItem Computerscience = new JMenuItem("Computerscience");
	
	// constructor
	public HW11_Begin(){
		this.setSize(1000,700);
		this.setTitle("Book System");
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(true);
		
		//set the location
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( ( dim.width - this.getSize().width ) / 2, ( dim.height - this.getSize().height )/ 2 );
		
		menu_bar = new JMenuBar();
		this.setJMenuBar(menu_bar);
		
		// what is container 
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		desktop = new JDesktopPane();
		contentPane.add(desktop);
		
		
		exit.addActionListener(this);
		exposition.addActionListener(this);
		
		Reference.addActionListener(this);
		Magazine.addActionListener(this);
		Literature.addActionListener(this);
		Computerscience.addActionListener(this);
		
		
		menu1.add(exit);
		menu1.add(exposition);
		
		menu2.add(Reference);
		menu2.add(Magazine);
		menu2.add(Literature);
		menu2.add(Computerscience);
		
		menu_bar.add(menu1);
		menu_bar.add(menu2);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == exit){
			JOptionPane joptionpane = new JOptionPane();
			int result = joptionpane.showConfirmDialog(null, "Are you sure??","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == 0){
				System.exit(0);
			}
		}
		else if(event.getSource() == exposition){
			JOptionPane.showMessageDialog(null, "This is GUI work !!!", "About this program",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(event.getSource() == Reference){
			HW_11_ReferenceBook referbook = new HW_11_ReferenceBook();
			desktop.add(referbook);
		}
		
	}

}
