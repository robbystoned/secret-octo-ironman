package nl.robbystoned.reverser.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
				if(fileOrDir.isDirectory()){
					//dir mode
				} else {
					//single file mode.
				}
			}
		}

	}

}
