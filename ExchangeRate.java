package Project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ExchangeRate{

	static double rate=1.0;
	static JSONObject myObject;
	
	public static double getRate(String currencyCode) throws Exception {	
		
		//from powerpoint 15
		try {
			String firstPartURL = "https://v6.exchangerate-api.com/v6/";
			String key ="";
			String thirdPart = "/latest/USD";
			String theURL = firstPartURL + key + thirdPart;
			URL url = new URL(theURL);
	
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			JSONParser jsonParser = new JSONParser();	
			myObject = (JSONObject)jsonParser.parse(br);
			
			
			rate = (long) ((JSONObject) myObject.get("conversion_rates")).get(currencyCode);		
			
				
		} catch(Exception ex) {	
			
			rate = (double) ((JSONObject)myObject.get("conversion_rates")).get(currencyCode);
	
		}	return rate;
	
	}
	
}
