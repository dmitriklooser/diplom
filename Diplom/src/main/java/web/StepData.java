package web;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public abstract class StepData {
	private Map<String, Object> holder = new HashMap<>();
	private Cache cache;
	private ResourceBundle messages = ResourceBundle.getBundle("web.page", new Locale("ru"));

	
	
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
	
	protected String fmt(String key){
		return messages.getString(key);
	}
	
	/** reads and prepares data for page rendering */
	public abstract void load(HttpServletRequest request);
		
	
	
}// class StepData 
