package web;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import db.Reader;
import geneticalg.Group;
import geneticalg.Lessons;
import geneticalg.Module;
import geneticalg.Professor;
import geneticalg.Room;
import geneticalg.Timeslot;

public class Cache {
	final private Reader reader = new Reader();
	private Map<Group, List<Lessons>> timetables = new HashMap<>();

	public Storage<Integer, Module> MODULE_CACHE = new Storage<>((m)->m.getId(), ()->reader.readAllModules());
	public Storage<Integer, Professor> PROFESSOR_CACHE = new Storage<>((p)->p.getId(), ()->reader.readAllProfessors());
	public Storage<Integer, Room> ROOM_CACHE = new Storage<>((r)->r.getId(), ()->reader.readAllRooms());
	public Storage<Integer, Timeslot> TIMESLOT_CACHE = new Storage<>((tm)->tm.getId(), ()->reader.readAllTimeslots());
	public Storage<Integer, Group> GROUP_CACHE = new Storage<>((g)->g.getId(), ()->reader.readAllGroups());

	public void loadAllTimetables(){
		List<Lessons> allLessons = reader.readAllLessons(this);
		this.timetables = allLessons.stream().collect(Collectors.groupingBy((ls)->ls.getGroup(), Collectors.toList()));
	}
	
	public List<Lessons>getTimetable(Group group){
		return timetables.get(group);
	}
	
public static class Storage<K, T>{
	private Map<K, T> map = new HashMap<>();
	private Function<T, K> getKey;
	private Supplier<List<T>> dataProvider;
	
	public Storage(Function<T, K> getKey, Supplier<List<T>> dataProvider){
		this.getKey = getKey;
		this.dataProvider = dataProvider;
	}
	
	public void store(K key, T value){
		map.put(key, value);
	}
	public T get(K key){
		return map.get(key);
	}
	
	public void storeAll(List<T> values){
		values.forEach((value)->map.put(getKey.apply(value), value));
	}
	
	public Collection<T> getAll(){
		return map.values();
	}
	
	public void load(){
		map.clear();
		List<T> values = dataProvider.get();
		storeAll(values);
	}
}//class Storage
}// class Cache 
