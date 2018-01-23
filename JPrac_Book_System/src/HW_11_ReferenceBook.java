import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


public class HW_11_ReferenceBook extends JInternalFrame implements ActionListener{

	
	JButton print_button = new JButton();
	JDesktopPane desktop;

	public HW_11_ReferenceBook(){
		this.setLocation(0, 0);
		this.setSize( 500 , 500 );
		this.setTitle("Reference Book" );
		this.setVisible ( true );
		this.setMaximizable(true);
		this.setClosable( true );
		this.setResizable( true );		
			
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		desktop = new JDesktopPane();
		contentPane.add(desktop);
		
		print_button.setText("Show the List");
		print_button.setVisible(true);
		print_button.addActionListener(this);
		desktop.add(print_button);
		
		
		this.setVisible(true);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
