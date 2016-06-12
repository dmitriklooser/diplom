package web;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import geneticalg.Timeslot;

public class Step2Data extends StepData{
	public static final String ATTR_ALL_TIMESLOTS = "allTimes";
	public static final String ATTR_WEEK_DAYS = "weekDays";
	public static final String ATTR_TIMES = "times";
	public static final String ATTR_GRP_TSLOTS = "grpTSlots";
	
	protected Step2Data(Cache cache) {
		super(cache);
	}

	@Override
	public void load(HttpServletRequest request) {
		Collection<Timeslot> timeslots = getCache().TIMESLOT_CACHE.getAll();
		request.setAttribute(ATTR_ALL_TIMESLOTS, timeslots);
		request.setAttribute(ATTR_WEEK_DAYS, getWeekDays());
		request.setAttribute(ATTR_TIMES, getUniqueTSlots());
		request.setAttribute(ATTR_GRP_TSLOTS, getGroupedTSlots());
		
	}

	
	public Collection<Timeslot> getAllTimeslots(){
		return (Collection<Timeslot>)getAttribute(ATTR_ALL_TIMESLOTS);
	}
	
	public Collection<LocalTime> getUniqueTSlots(){
		return getCache().TIMESLOT_CACHE.getAll().stream()
																		 .map(tSl->tSl.getTime())
																		 .sorted()
																		 .distinct()
																		 .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Collection<String> getWeekDays(){
		return getCache().TIMESLOT_CACHE.getAll().stream()
																		  .map((tSl)->tSl.getDay())
																		  .sorted()
																		  .distinct()
																		  .map((day)->fmt(day.name()))
																		  .collect(Collectors.toCollection(ArrayList::new));
	}
	

	public Map<LocalTime, List<Timeslot>> getGroupedTSlots(){
		return getCache().TIMESLOT_CACHE.getAll().stream()
												   .collect(Collectors.groupingBy((tSl)->tSl.getTime(), Collectors.toList()));
	}
}
