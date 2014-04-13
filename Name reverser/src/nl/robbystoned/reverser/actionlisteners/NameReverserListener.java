package nl.robbystoned.reverser.actionlisteners;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import nl.robbystoned.reverser.ui.NameReverserUI;
/**
 * copyright 2014
 * @author robertvds handles the select file or directory event and 
 * passes it to the textbox
 *
 */
public class NameReverserListener implements ActionListener {
	List extensions;
	private NameReverserUI ui;
	/**
	 * the construction
	 * @param ui the instance of the ui that created it for callback purposes
	 */
	public NameReverserListener(NameReverserUI ui) {
		this.ui = ui;
	}

	/**
	 * handles the select file dialog
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(fileChooser);
		File selectedFileOrDirectory = fileChooser.getSelectedFile();
		if(selectedFileOrDirectory != null) {//file is null if cancel was pressed
			//set the filename to the textbox
			ui.getFileOrDir().setText(selectedFileOrDirectory.getAbsolutePath());
		}
	}
}
