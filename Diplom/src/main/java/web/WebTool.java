package web;

import java.time.LocalTime;

public class WebTool {

	public static String formatTime(LocalTime time){
		return String.format("%tR", time);
	}
	
	public static boolean isDigit(String val){
		val = val.trim();
		if(val.length() == 0) return false;
		return val.chars().allMatch((ch)->Character.isDigit(ch));
	}
}// class WebTool 
