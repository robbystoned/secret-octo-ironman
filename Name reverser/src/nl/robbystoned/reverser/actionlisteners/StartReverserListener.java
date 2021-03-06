package nl.robbystoned.reverser.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import nl.robbystoned.reverser.ui.NameReverserUI;
/**
 * copyright 2014
 * @author robertvds
 * the eventt listener for the start button
 */
public class StartReverserListener implements ActionListener {
	private NameReverserUI ui;
	/**
	 * the constructor
	 * @param nameReverserUI an instance of the ui that created it for callback purposes
	 */
	public StartReverserListener(NameReverserUI nameReverserUI) {
		this.ui = nameReverserUI;//pass the ui to be able to get to the values in the interface
	}

	/**
	 * performs the actual renaming based on if it is a file or directory 
	 * and what filetypes were selected.
	 */
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
					File[] listFiles = fileOrDir.listFiles();
					for(File file : listFiles){
						if(file.isFile()){
							processSingleFile(selectedExtensions, file);
						}
					}
				} else {
					//single file mode.
					processSingleFile(selectedExtensions, fileOrDir);
				}
			}
		}
	}

	/**
	 * reverses the name of one single file if the extension matches any of the extensions
	 * in the arraylist
	 * @param selectedExtensions the selected file extensions to rename
	 * @param fileName the file to rename
	 * @param baseDir the dir where the file is
	 */
	private void processSingleFile(List<String> selectedExtensions, File file) {
		
		String fileName = file.getName();
		String baseDir = file.getParent();
		String extension = fileName .substring(fileName.lastIndexOf("."), fileName.length());
		if(selectedExtensions.contains(extension)){
			String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
			ui.appendToLog("Reversing name: " + nameWithoutExtension + " to " + reverse(nameWithoutExtension)+extension);
			file.renameTo(new File(baseDir + "/" + reverse(nameWithoutExtension)+extension));
		}
	}
	
	/**
	 * reverses the given string
	 * @param the string to revers
	 * @return the reversed string
	 */
	private String reverse(String s) {
	    return new StringBuffer(s).reverse().toString();
	}
}
