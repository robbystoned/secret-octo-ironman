package nl.robbystoned.reverser.ui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NameReverserUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5634096799351334128L;
	private Button fileSelectButton;
	private Button startButton;
	private JFrame frame;
	private List extensions;
	private TextField fileOrDir;
	private TextArea textArea;
	
	public NameReverserUI() {
		constructUI();
	     
	}

	private void constructUI() {
		frame = new JFrame();
		frame.getContentPane().add(this);
	    frame.setSize(800, 400);
	    frame.setLayout(new FlowLayout());
	    fileSelectButton = new Button("Select file or folder");
	    startButton = new Button("Start!");
	    fileOrDir = new TextField(20);
	    fileOrDir.setEditable(false);//only edit the value with the select button.
	    extensions = new List(3,true);
	    fileSelectButton.setSize(5, 20);
	    frame.add(fileSelectButton);
	    frame.add(startButton);
	    frame.add(fileOrDir);
	    extensions.add(".mkv");
	    extensions.add(".srt");
	    extensions.add(".avi");
	    extensions.select(0);
	    extensions.select(1);
	    extensions.select(2);
	    frame.add(extensions);
	    extensions.getSelectedItem();
	    textArea = new TextArea("", 10, 75);
	    frame.add(textArea);
	    frame.setVisible(true);
	    frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
	}
	
	public List getExtensions() {
		return extensions;
	}

	public void setActionListener(ActionListener fileSelectorEvent, ActionListener startEvent){
		fileSelectButton.addActionListener(fileSelectorEvent);
		startButton.addActionListener(startEvent);
	}
	
	public TextField getFileOrDir() {
		return fileOrDir;
	}

	public String[] getExtensionValues(){
		return extensions.getSelectedItems();
	}
	
	public void paint(Graphics g) {
	      Graphics2D g2 = (Graphics2D)g;
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	      RenderingHints.VALUE_ANTIALIAS_ON);
	      
	   }
	public void appendToLog(String msg){
		
		textArea.append(msg + "\r\n");
	}
}
