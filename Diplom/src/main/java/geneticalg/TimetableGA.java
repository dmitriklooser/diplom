package geneticalg;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import geneticalg.Room.TypeRoom;
import writer.Lesson;
import writer.TimetableWriter;

/**
 * Don't be daunted by the number of classes in this chapter -- most of them are
 * just simple containers for information, and only have a handful of properties
 * with setters and getters.
 * 
 * The real stuff happens in the GeneticAlgorithm class and the Timetable class.
 * 
 * The Timetable class is what the genetic algorithm is expected to create a
 * valid version of -- meaning, after all is said and done, a chromosome is read
 * into a Timetable class, and the Timetable class creates a nicer, neater
 * representation of the chromosome by turning it into a proper list of Classes
 * with rooms and professors and whatnot.
 * 
 * The Timetable class also understands the problem's Hard Constraints (ie, a
 * professor can't be in two places simultaneously, or a room can't be used by
 * two classes simultaneously), and so is used by the GeneticAlgorithm's
 * calcFitness class as well.
 * 
 * Finally, we overload the Timetable class by entrusting it with the
 * "database information" generated here in initializeTimetable. Normally, that
 * information about what professors are employed and which classrooms the
 * university has would come from a database, but this isn't a book about
 * databases so we hardcode it.
 * 
 * @author bkanber
 *
 */
public class TimetableGA {

    public static void main(String[] args) {
    	// Get a Timetable object with all the available information.
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
        TimetableWriter printer = new TimetableWriter();
        Map<Group, List<Lesson>> allLessons = printer.fillLessons(timetable);
        Group grp = allLessons.keySet().iterator().next();
        List<Lesson> lessons = allLessons.get(grp);
        printer.write(grp, lessons);
//        System.out.println();
//        System.out.println("Solution found in " + generation + " generations");
//        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
//        System.out.println("Clashes: " + timetable.calcClashes());
//
//        // Print classes
//        System.out.println();
//        Class classes[] = timetable.getClasses();
//        int classIndex = 1;
//        for (Class bestClass : classes) {
//            System.out.println("Class " + classIndex + ":");
//            System.out.println("Module: " + 
//                    timetable.getModule(bestClass.getModuleId()).getModuleName());
//            System.out.println("Group: " + 
//                    timetable.getGroup(bestClass.getGroupId()).getGroupId());
//            System.out.println("Room: " + 
//                    timetable.getRoom(bestClass.getRoomId()).getRoomNumber());
//            System.out.println("Professor: " + 
//                    timetable.getProfessor(bestClass.getProfessorId()).getProfessorName());
//            System.out.println("Time: " + 
//                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot());
//            System.out.println("-----");
//            classIndex++;
        
//        }
    }

    /**
     * Creates a Timetable with all the necessary course information.
     * 
     * Normally you'd get this info from a database.
     * 
     * @return
     */
	private static Timetable initializeTimetable() {
		// Create timetable
		Timetable timetable = new Timetable();

		// Set up rooms
		timetable.addRoom(1, "A1", 15, TypeRoom.AUDITORIA);
		timetable.addRoom(2, "B1", 30, TypeRoom.LABORATORIA);
		timetable.addRoom(4, "D1", 20, TypeRoom.AUDITORIA);
		timetable.addRoom(5, "F1", 25, TypeRoom.SPORT);

		// Set up timeslots
		timetable.addTimeslot(1, LocalTime.of(9, 0), DayOfWeek.MONDAY );
		timetable.addTimeslot(2, LocalTime.of(11, 0), DayOfWeek.MONDAY);
		timetable.addTimeslot(3, LocalTime.of(13, 0),  DayOfWeek.MONDAY);
		timetable.addTimeslot(4, LocalTime.of(9, 0), DayOfWeek.TUESDAY);
		timetable.addTimeslot(5, LocalTime.of(11, 0), DayOfWeek.TUESDAY);
		timetable.addTimeslot(6, LocalTime.of(13, 0), DayOfWeek.TUESDAY);
		timetable.addTimeslot(7, LocalTime.of(9, 0), DayOfWeek.WEDNESDAY);
		timetable.addTimeslot(8, LocalTime.of(11, 0), DayOfWeek.WEDNESDAY);
		timetable.addTimeslot(9, LocalTime.of(13, 0), DayOfWeek.WEDNESDAY);
		timetable.addTimeslot(10, LocalTime.of(9, 0), DayOfWeek.THURSDAY);
		timetable.addTimeslot(11, LocalTime.of(11, 0), DayOfWeek.THURSDAY);
		timetable.addTimeslot(12, LocalTime.of(13, 0), DayOfWeek.THURSDAY);
		timetable.addTimeslot(13, LocalTime.of(9, 0), DayOfWeek.FRIDAY);
		timetable.addTimeslot(14, LocalTime.of(11, 0), DayOfWeek.FRIDAY);
		timetable.addTimeslot(15, LocalTime.of(13, 0), DayOfWeek.FRIDAY);

		// Set up professors
		timetable.addProfessor(1, "Dr P Smith");
		timetable.addProfessor(2, "Mrs E Mitchell");
		timetable.addProfessor(3, "Dr R Williams");
		timetable.addProfessor(4, "Mr A Thompson");

		// Set up modules and define the professors that teach them
		timetable.addModule(1, "cs1", "Computer Science", new int[] { 1, 2 }, TypeRoom.LABORATORIA);
		timetable.addModule(2, "en1", "English", new int[] { 1, 3 }, TypeRoom.AUDITORIA);
		timetable.addModule(3, "ma1", "Maths", new int[] { 1, 2 }, TypeRoom.AUDITORIA);
		timetable.addModule(4, "ph1", "Physics", new int[] { 3, 4 }, TypeRoom.LABORATORIA);
		timetable.addModule(5, "hi1", "chemistry", new int[] { 4 }, TypeRoom.LABORATORIA);
		timetable.addModule(6, "dr1", "physical education", new int[] { 1, 4 }, TypeRoom.SPORT);

		// Set up student groups and the modules they take.
		timetable.addGroup(1, 10, new int[] { 1, 3, 4 });
		timetable.addGroup(2, 30, new int[] { 2, 3, 5, 6 });
		timetable.addGroup(3, 18, new int[] { 3, 4, 5 });
		timetable.addGroup(4, 25, new int[] { 1, 4 });
		timetable.addGroup(5, 20, new int[] { 2, 3, 5 });
		timetable.addGroup(6, 22, new int[] { 1, 4, 5 });
		timetable.addGroup(7, 16, new int[] { 1, 3 });
		timetable.addGroup(8, 18, new int[] { 2, 6 });
		timetable.addGroup(9, 24, new int[] { 1, 6 });
		timetable.addGroup(10, 25, new int[] { 3, 4 });
		return timetable;
	}
}
//1)оценить, чего не хватает(аудит, преп и тд)
//2)кол-во часов в неделю
