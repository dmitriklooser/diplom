package geneticalg;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Simple timeslot abstraction -- just represents a timeslot (like "Wed 9:00am-11:00am").
 *  
 * 
 *
 */

public class Timeslot {
    private final int timeslotId;
    private final LocalTime time;
    private final DayOfWeek day;
 

    /**
     * Initalize new Timeslot
     * 
     * @param timeslotId The ID for this timeslot
     * @param timeslot The timeslot being initalized
     */
    public Timeslot(int timeslotId, LocalTime time, DayOfWeek day){
    	this.timeslotId = timeslotId;
        this.time = time;
        this.day = day;
    }
    
    /**
     * Returns the timeslotId
     * 
     * @return timeslotId
     */
    public int getId(){
        return this.timeslotId;
    }
    
    /**
     * Returns the timeslot
     * 
     * @return timeslot
     */
    public LocalTime getTime(){
        return this.time;
    }
        
    public DayOfWeek getDay(){
        return this.day;
    }
}
