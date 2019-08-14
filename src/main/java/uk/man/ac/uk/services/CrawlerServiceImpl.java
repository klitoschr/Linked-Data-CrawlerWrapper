package uk.man.ac.uk.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.man.ac.uk.util.ParametersTypes;

import com.ontologycentral.ldspider.Crawler;
import com.ontologycentral.ldspider.CrawlerConstants;
import com.ontologycentral.ldspider.frontier.BasicFrontier;
import com.ontologycentral.ldspider.frontier.Frontier;
import com.ontologycentral.ldspider.hooks.content.*;
import com.ontologycentral.ldspider.hooks.links.LinkFilter;
import com.ontologycentral.ldspider.hooks.links.LinkFilterDefault;
import com.ontologycentral.ldspider.hooks.sink.Sink;
import com.ontologycentral.ldspider.hooks.sink.SinkSparul;

/***
 * This class wraps the crawler library used which is responsible for crawling the
 * Web of Data at the T-box level.
 * 
 * 
 * Documentation: https://code.google.com/p/ldspider/wiki/GettingStartedAPI
 * 
 * @author Klitos Christodoulou
 *
 */
public class CrawlerServiceImpl {
		
	
	private Map<String, String> configParameters = null;
	private Crawler crawler = null;	
	private Frontier frontier = null;
		
	/*Constructor*/
	public CrawlerServiceImpl(Map<String, String> confParams) {
		this.configParameters = confParams;
	}
	
	
	
	/***
	 * Given a list of URIs determine which URIs will be used as seeds for the crawler to start 
	 * performing its crawling
	 */
	
	private void performCrawling() {
		
		int numberOfthreads = Integer.parseInt(configParameters.get(ParametersTypes.NUMBER_OF_THREADS.toString()));
		crawler = new Crawler(numberOfthreads);
		
		frontier = new BasicFrontier();
	
		
		//frontier.add(new URI(seedUri));		
		
	}//end init()
	
	
	/***
	 * Supportive method that reads URIs from a file into a List object 
	 * to be used later for random sampling.
	 */
	private List<URI> readURIs() {
		
		List<URI> uris = null;	
		String filePath = "";
		
		BufferedReader bufferReader = null;
		File file = null;

	    try {	    	
			uris = new ArrayList<URI>();		
			filePath = configParameters.get(ParametersTypes.SEED_LIST_LOCATION.toString());
	    	
	    	file = new File(filePath);
	    	bufferReader = new BufferedReader(new FileReader(file));
	    	
	    	String line = null;
	    	while ((line = bufferReader.readLine()) != null) {
	    		uris.add(new URI(line));
	    	}	    	
	    
	    	//release resources
	    	if (bufferReader != null) { 
	    		bufferReader.close();	   
	    	}	    	
	    } catch (Exception exe) {
	    	 System.err.println("Error - I/O while reading list of URIs");
	    }		
		
		return uris;
	}//end readURIs()
	
}//end class
