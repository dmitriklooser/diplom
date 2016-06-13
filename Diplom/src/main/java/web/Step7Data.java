package web;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import db.Writer;
import geneticalg.Clazz;
import geneticalg.GeneticAlgorithm;
import geneticalg.Group;
import geneticalg.Lessons;
import geneticalg.Module;
import geneticalg.Population;
import geneticalg.Professor;
import geneticalg.Room;
import geneticalg.Timeslot;
import geneticalg.Timetable;

public class Step7Data extends StepData{
	private Writer writer = new Writer(); 
	
	
	protected Step7Data(Cache cache) {
		super(cache);
	}

	@Override
	public void load(HttpServletRequest request) {
	}
	
	@Override
	public void save(HttpServletRequest request) {
		writer.clearTimetable();
		Timetable timetable = runCalculationGA();
		List<Lessons> lessonsList = extractLessons(timetable);
		lessonsList.stream().forEach(lss->writer.writeLessons(lss));
	}

	@Override
	public void delete(HttpServletRequest request) {
		
	}
	
	
	
	private Timetable runCalculationGA(){
        Timetable timetable = initializeTimetable();
        
        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        
        // Initialize population
        Population population = ga.initPopulation(timetable);
        
        // Evaluate population
        ga.evalPopulation(population, timetable);
        
        // Keep track of current generation
        int generation = 1;
        
        // Start evolution loop
        while (ga.isTerminationConditionMet(generation, 1000) == false
            && ga.isTerminationConditionMet(population) == false) {
            // Print fitness
            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));
		return timetable; 
	}
	

	private Timetable initializeTimetable(){
		Timetable timetable = new Timetable();
		getCache().ROOM_CACHE.getAll().forEach(rm->timetable.addRoom(rm));
		getCache().GROUP_CACHE.getAll().forEach(grp->timetable.addGroup(grp));
		getCache().MODULE_CACHE.getAll().forEach(md->timetable.addModule(md));
		getCache().PROFESSOR_CACHE.getAll().forEach(prof->timetable.addProfessor(prof));
		getCache().TIMESLOT_CACHE.getAll().stream().filter(tSl->tSl.isInUse())
																			.forEach(tSl->timetable.addTimeslot(tSl));

		return timetable;
	}
	

	public List<Lessons> extractLessons(Timetable tTbl){
        Clazz[] classes = tTbl.getClasses();
        List<Lessons> lessonsList = new ArrayList<>();
        for(int i = 0; i < classes .length; i++){
            Clazz cls = classes[i];
            Group group = tTbl.getGroup(cls.getGroupId());
            Module module =  tTbl.getModule(cls.getModuleId());
            Room room = tTbl.getRoom(cls.getRoomId());
            Professor professor = tTbl.getProfessor(cls.getProfessorId());
            Timeslot tSl = tTbl.getTimeslot(cls.getTimeslotId());
        	Lessons lessons = new Lessons();
        	lessons.setGroup(group);
        	lessons.setModule(module);
        	lessons.setRoom(room);
        	lessons.setProfessor(professor);
        	lessons.setTimeslot(tSl);
        	lessonsList.add(lessons);
        }
        return lessonsList;
    }
        

    private List<Lessons> filterByLessonStart(List<Lessons> lessons, LocalTime start){
        return lessons.stream()
                      .filter((lesson)->lesson.getTimeslot().getTime().equals(start))
                      .collect(Collectors.toList());
    }
	
	
	
}
