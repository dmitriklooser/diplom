package web;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import geneticalg.Lessons;

public class WebTool {

	public static String formatTime(LocalTime time){
		return String.format("%tR", time);
	}

	public static String formatLessonTime(LocalTime timeStart){
		LocalTime timeEnd = LocalTime.of(timeStart.getHour() + 2, 0);
		return String.format("%tR-%tR", timeStart, timeEnd);
	}

	public static boolean isDigit(String val){
		val = val.trim();
		if(val.length() == 0) return false;
		return val.chars().allMatch((ch)->Character.isDigit(ch));
	}
	
	public static List<Lessons> filterByTime(List<Lessons> allLessons, LocalTime time){
		return allLessons.stream()
								   .filter(lss->lss.getTimeslot().getTime().equals(time))
								   .sorted((lssA, lssB)->lssA.getTimeslot().getDay().compareTo(lssB.getTimeslot().getDay()))
								   .collect(Collectors.toList());
	}
	
	public static Lessons filterByDT(List<Lessons> allLessons, DayOfWeek day, LocalTime time){
		Optional<Lessons> opt = allLessons.stream()
															   .filter(lss->lss.getTimeslot().getDay().equals(day) && 
																	    lss.getTimeslot().getTime().equals(time))
															   .sorted((lssA, lssB)->lssA.getTimeslot().getDay().compareTo(lssB.getTimeslot().getDay()))
															   .findFirst();
								   //.collect(Collectors.toList());
		return opt.isPresent() ? opt.get():null;
	}
	
}// class WebTool 
