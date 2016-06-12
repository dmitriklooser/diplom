package web;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import geneticalg.Module;

public abstract class StepData {
	private Map<String, Object> holder = new HashMap<>();
	private Cache cache;
	private static ResourceBundle messages = ResourceBundle.getBundle("web.page", new Locale("ru"));

	
	
	protected StepData(Cache cache){
		this.cache = cache;
	}
	
	protected Cache getCache(){
		return cache;
	}
	
	protected void storeAttribute(String key, Object value){
		holder.put(key, value);
	}
	
	protected Object getAttribute(String key){
		return holder.get(key);
	}
	
	protected List<Integer> getIDParams(HttpServletRequest req){
		List<Integer> result = new ArrayList<>();
		Enumeration<String> pNames = req.getParameterNames();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
			if(WebTool.isDigit(pName)){
				result.add(Integer.valueOf(pName)); 
			}
		}
		return result;
	}
	
	protected List<String> getParamsStartFrom(HttpServletRequest req, String prefix){
		List<String> result = new ArrayList<>();
		Enumeration<String> pNames = req.getParameterNames();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
			if(pName.startsWith(prefix)){
				result.add(pName); 
			}
		}
		return result;
	}
	
	public static String fmt(String key){
		return messages.getString(key);
	}
	
	/** reads and prepares data for page rendering */
	public abstract void load(HttpServletRequest request);
	/** saves data on submit */		
	public abstract void save(HttpServletRequest request);
	/** delete data on submit */
	public abstract void delete(HttpServletRequest request);
	
}// class StepData 
