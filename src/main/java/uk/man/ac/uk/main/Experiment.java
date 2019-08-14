package uk.man.ac.uk.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import uk.man.ac.uk.services.CrawlerServiceImpl;
import uk.man.ac.uk.util.Utilities;

/***
 * 
 * 
 * Crawler setup for Linked Open Data
 * 
 * 
 * 
 * @author Klitos Christodoulou
 *
 */
public class Experiment {
	
    public static void main(String[] args) throws InterruptedException {
    	String startTimeStamp = new SimpleDateFormat("dd/MM/yyyy @ HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println( "Running experiment: " + startTimeStamp + "\n");

        /***
         * Supply the parameters for running the approach as configuration files
         */
        String confFilePath = "./conf/run1.conf";        
        Map<String, String> configParameters = Utilities.loadConfig(confFilePath);
        
        System.out.println( "Configuration is:");
        for (Map.Entry<String, String> entry : configParameters.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
        /***
         * Call the Crawler
         */
        CrawlerServiceImpl crawlerInstance = new CrawlerServiceImpl(configParameters);
        //crawlerInstance.start();
        
    }
}//end class
