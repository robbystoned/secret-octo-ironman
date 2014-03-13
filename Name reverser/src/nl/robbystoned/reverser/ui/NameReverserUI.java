package nl.robbystoned.reverser.ui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.robbystoned.reverser.actionlisteners.NameReverserListener;

public class NameReverserUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5634096799351334128L;
	private Button button;
	private JFrame frame;
	private List extensions;
	
	public NameReverserUI() {
		constructUI();
	     
	}

	private void constructUI() {
		frame = new JFrame();
		frame.getContentPane().add(this);
	    frame.setSize(800, 600);
	    frame.setLayout(new FlowLayout());
	    button = new Button("testbutton");
	    extensions = new List(2,true);
	    button.setSize(5, 20);
	    frame.add(button);  
	    extensions.add(".mkv");
	    extensions.add(".srt");
	    frame.add(extensions);
	    extensions.getSelectedItem();
	    frame.setVisible(true);
	}
	
	public void setActionListener(ActionListener fileSelectorEvent){
		button.addActionListener(fileSelectorEvent);
	}
	
	public String[] getExtensionValues(){
		return extensions.getSelectedItems();
	}
	
	public void paint(Graphics g) {
	      Graphics2D g2 = (Graphics2D)g;
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	      RenderingHints.VALUE_ANTIALIAS_ON);
	      
	   }
}
