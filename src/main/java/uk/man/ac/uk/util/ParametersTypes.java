package uk.man.ac.uk.util;

/***
 * Configuration parameters for the experiment
 * 
 * @author Klitos Christodoulou
 *
 */
public enum ParametersTypes {

	NUMBER_OF_SAMPLES("NUMBER_OF_SAMPLES"),
	NUMBER_OF_THREADS("NUMBER_OF_THREADS"),
	CRAWLER_OUTPUT_LOCATION("CRAWLER_OUTPUT_LOCATION"),
	SPARQL_ENDPOINT_URI("SPARQL_ENDPOINT_URI"),
	TBOX_CRAWLING("TBOX_CRAWLING"),
	ABOX_CRAWLING("ABOX_CRAWLING"),
	LOAD_BALANCED_STRATEGY("LOAD_BALANCED_STRATEGY"),
	BREADTH_FIRST_STRATEGY("BREADTH_FIRST_STRATEGY"),
	BREADTH_FIRST_DEPTH("BREADTH_FIRST_DEPTH"),
	BREADTH_FIRST_URI_LIMIT("BREADTH_FIRST_URI_LIMIT"),
	LOAD_BALANCED_URI_LIMIT("LOAD_BALANCED_URI_LIMIT"),
	SEED_LIST_LOCATION("SEED_LIST_LOCATION");	
		
	private final String value;

	ParametersTypes (String v) {
		value = v;
    }
	
    public static ParametersTypes fromValue(String v) {
        for (ParametersTypes c: ParametersTypes.values()) {
            if (c.value.equals(v.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }	
	
}//end enum
