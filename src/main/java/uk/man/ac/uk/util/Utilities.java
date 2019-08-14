package uk.man.ac.uk.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/***
 * Various generic methods used to support implementation
 * 
 * @author Klitos Christodoulou
 *
 */
public class Utilities {

	
	/*constructor*/
	public Utilities() {}
	
	
	/***
	 * Read a configuration file
	 * 
	 * @param filePath
	 * @return
	 */
	public static Map<String, String> loadConfig(String filePath) {
		Map<String, String> alignMap = null;		
		try {
			alignMap = new HashMap<String, String>();
			InputStream propertyStream = new FileInputStream(filePath);
			Properties alignProps = new java.util.Properties();
			alignProps.load(propertyStream);			
			
			//Read the configuration file
			for(String key : alignProps.stringPropertyNames()) {				
				String value = alignProps.getProperty(key);								
				alignMap.put(key, value);				
			}//end for
	 
		 } catch (FileNotFoundException exc) {
		 	System.err.println("Error - Configuration files not found.");
		 } catch (IOException ioexc) {
			System.err.println("Error - I/O configuration file.");
		 }//end catch	
		
		return alignMap;
	}//end loadConfigAlignments()
	
	
	
	
}//end class
