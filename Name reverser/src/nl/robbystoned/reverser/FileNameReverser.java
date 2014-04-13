package nl.robbystoned.reverser;
/**
 * copyright 2014 robert vd steen
 * Main class for the Application
 */
import nl.robbystoned.reverser.actionlisteners.NameReverserListener;
import nl.robbystoned.reverser.actionlisteners.StartReverserListener;
import nl.robbystoned.reverser.ui.NameReverserUI;

public class FileNameReverser {

	private NameReverserUI nameReverserUI;

	/**
	 * main function, starts an instance of itself
	 * @param args
	 */
	public static void main(String[] args) {
		new FileNameReverser();
	}
	
	/**
	 * default constructor, construct UI and assign action listneres
	 */
	public FileNameReverser (){
		constructUserInterface();
		addActionListeners();

	}
	
	/**
	 * cicks off the ui class
	 */
	private void constructUserInterface(){
		nameReverserUI = new NameReverserUI();
	}
	
	/**
	 * assign the listeners
	 */
	private void addActionListeners(){
		NameReverserListener listener = new NameReverserListener(nameReverserUI);
		StartReverserListener startListener = new StartReverserListener(nameReverserUI);
		nameReverserUI.setActionListener(listener,startListener);
	}
}
