package web;

import java.time.LocalTime;

public class WebTool {

	public static String formatTime(LocalTime time){
		return String.format("%tR", time);
	}
}// class WebTool 
