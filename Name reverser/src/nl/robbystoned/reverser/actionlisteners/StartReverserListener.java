package nl.robbystoned.reverser.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.robbystoned.reverser.ui.NameReverserUI;

public class StartReverserListener implements ActionListener {
	private NameReverserUI ui;
	public StartReverserListener(NameReverserUI nameReverserUI) {
		this.ui = nameReverserUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedFile = ui.getFileOrDir().getText();
		//check if the string is empty
		if(selectedFile != null && !selectedFile.equals("")){
			File fileOrDir = new File(selectedFile);
			if(fileOrDir.exists()){
				//load the extensions from the selector
				List<String> selectedExtensions = Arrays.asList(ui.getExtensions().getSelectedItems());
				if(fileOrDir.isDirectory()){
					//dir mode
					
					
				} else {
					//single file mode.
					String fileName = fileOrDir.getName();
					processSingleFile(selectedExtensions, fileName);
				}
			}
		}

	}

	private void processSingleFile(List<String> selectedExtensions,
			String fileName) {
		String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		if(selectedExtensions.contains(extension)){
			
		}
	}

}
