package nl.robbystoned.reverser;

import java.io.File;

import nl.robbystoned.reverser.actionlisteners.NameReverserListener;
import nl.robbystoned.reverser.actionlisteners.StartReverserListener;
import nl.robbystoned.reverser.ui.NameReverserUI;

public class FileNameReverser {

	private NameReverserUI nameReverserUI;

	public static void main(String[] args) {
		FileNameReverser fileNameReverser = new FileNameReverser();
	}
	public FileNameReverser (){
		constructUserInterface();
		addActionListeners();

	}
	
	private void constructUserInterface(){
		nameReverserUI = new NameReverserUI();
	}
	
	private void addActionListeners(){
		NameReverserListener listener = new NameReverserListener(nameReverserUI);
		StartReverserListener startListener = new StartReverserListener(nameReverserUI);
		nameReverserUI.setActionListener(listener,startListener);
	}
	
	private void reverseAllFilesInDirectory(String baseDir){
		try {
			File baseDirFile = new File(baseDir);
			if (baseDirFile.isDirectory()) {
				File[] filesInDirectory = baseDirFile.listFiles();
				for (File file : filesInDirectory) {
					reverseFileName(baseDir, file);
				}
			} else {
				throw new Exception("The given location is not a directory");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void reverseFileName(String baseDir, File file) {
		if (file.isFile()) {
			String fileName = file.getName();
			if(fileName.endsWith("mkv") || fileName.endsWith("srt")){
				String extension = fileName.substring(fileName.length()-4, fileName.length());
				String nameWithoutExtension = fileName.substring(0, fileName.length()-4);
				//don't forget the base directory, or else the basedirectory will be in the base dir of this program
				file.renameTo(new File(baseDir + "/" + reverse(nameWithoutExtension)+extension));
				
			}
		}
	}
	
	/**
	 * reverses the given string
	 * @param the string to revers
	 * @return the reversed string
	 */
	public String reverse(String s) {
	    return new StringBuffer(s).reverse().toString();
	}

}
