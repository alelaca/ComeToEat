package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileManager {
	
	//final static Logger logger = Logger.getLogger(FileManager.class);
	
	public FileManager() {
		// TODO Auto-generated constructor stub
	}

	public String readFile(String pathFile, String key){
		
		Properties prop   = new Properties();
		InputStream input = null;
		String value      = "";
		
		try {
			input = new FileInputStream(pathFile);
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException ex){
			//logger.error("ERR: could not open file " + pathFile + " - " + ex);
			System.out.println("ERR: could not open file " + pathFile + " - " + ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
					//logger.error("ERR: could not close file " + pathFile + " - " + ex);
					System.out.println("ERR: could not close file " + pathFile + " - " + ex);
				}				
			}
		}
		
		return value;
	}
}
