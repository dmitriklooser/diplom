package web;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import db.Reader;
import geneticalg.Group;
import geneticalg.Lessons;

public class Step8Data extends StepData{
	public static final String ATTR_LESSONS = "lessons";
	public static final String ATTR_GROUPS = "groups";
	public static final String ATTR_GROUP = "crGroup";
	public static final String ATTR_TIMES = "times";
	public static final String ATTR_WEEK_DAYS = "weekDays";
	
	private Reader reader = new Reader(); 
	private String crGroup;
	private List<Lessons> lessons;
	
	protected Step8Data(Cache cache) {
		super(cache);
	}

	@Override
	public void load(HttpServletRequest request) {
		if(lessons == null) lessons = new ArrayList<>();
		request.setAttribute(ATTR_LESSONS, lessons);
		request.setAttribute(ATTR_GROUPS, getCache().GROUP_CACHE.getAll());
		request.setAttribute(ATTR_GROUP, crGroup);
		request.setAttribute(ATTR_TIMES, getUniqueTSlots());
		request.setAttribute(ATTR_WEEK_DAYS, getWeekDays());
		
	}
	
	@Override
	public void save(HttpServletRequest request) {
		crGroup = request.getParameter("group");
		List<Lessons> lessonsList = reader.readAllLessons(getCache());
		Map<Group, List<Lessons>> groupedLessons = 
																lessonsList.stream()
															    .collect(Collectors.groupingBy(ls->ls.getGroup(), Collectors.toList()));
		if(crGroup != null){
			int grpID = Integer.parseInt(crGroup);
			Group group = getCache().GROUP_CACHE.get(grpID);
			lessons = groupedLessons.get(group);
		}
	}

	@Override
	public void delete(HttpServletRequest request) {
		
	}

	
	public Collection<LocalTime> getUniqueTSlots(){
		return getCache().TIMESLOT_CACHE.getAll().stream()
																		 .map(tSl->tSl.getTime())
																		 .sorted()
																		 .distinct()
																		 .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Collection<DayOfWeek> getWeekDays(){
		return getCache().TIMESLOT_CACHE.getAll().stream()
																		  .map((tSl)->tSl.getDay())
																		  .distinct()
																		  .sorted()
																		  .collect(Collectors.toCollection(ArrayList::new));
	}
	

}
