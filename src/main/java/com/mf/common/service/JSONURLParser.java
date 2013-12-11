package com.mf.common.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONURLParser {
	
	JSONObject getJSONFromURL(String url) throws IOException, JSONException;

}
