package nl.robbystoned.reverser.actionlisteners;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class NameReverserListener implements ActionListener {
	List extensions;
	public NameReverserListener() {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(fileChooser);
		File selectedFileOrDirectory = fileChooser.getSelectedFile();
		if(selectedFileOrDirectory != null) {//file is null if cancel was pressed
			if(selectedFileOrDirectory.isDirectory()) {
				//iterate over all matching files in the directory
			} else {
				//single file mode
			}
		}
		
	}

}
