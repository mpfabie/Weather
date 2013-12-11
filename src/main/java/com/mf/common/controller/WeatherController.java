package com.mf.common.controller;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mf.common.model.State;
import com.mf.common.service.JSONURLParser;
 
@Controller
public class WeatherController {
	
	@Autowired
	private JSONURLParser jsonURLParser;

	@RequestMapping(value="usweather", method = RequestMethod.GET)
	public String askZipCode(ModelMap model) {
		model.addAttribute("state",new State());
		return "usweather";
	}
	
	@RequestMapping(value="usweather", method = RequestMethod.POST)
	public String getTemperature(@ModelAttribute("state") @Valid State state, BindingResult result, Model model) {
		if(result.hasErrors()) {
            return "usweather";
        }
		
		try{
			String zip = state.getZipCode();
			JSONObject jsonObject = jsonURLParser.getJSONFromURL("http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/" + zip +".json"); //94117.json");
			JSONObject location = jsonObject.getJSONObject("display_location");
			state.setCityName(location.getString("city"));
			state.setStateName(location.getString("state_name"));
			state.setTemp(jsonObject.get("temp_f").toString());
		}catch(JSONException je){
			model.addAttribute("message", je.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    state.setZipCode(null);
		return "usweather";
	}
	
	
}
