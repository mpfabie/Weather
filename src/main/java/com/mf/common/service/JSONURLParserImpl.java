package com.mf.common.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class JSONURLParserImpl implements JSONURLParser {


	public JSONObject getJSONFromURL(String url) throws IOException, JSONException{

		InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      Iterator jsonKeys = json.keys();
	    
	      while(jsonKeys.hasNext()) {
	    	  String keys = (String)jsonKeys.next();
	    	  if(keys.equals("current_observation")){
	    		  return json.getJSONObject("current_observation");
	    	  }
	      }
	      throw new JSONException("error: zipcode not found");
	    } finally {
	      is.close();
	    }

	}
	
	
	private String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
}
