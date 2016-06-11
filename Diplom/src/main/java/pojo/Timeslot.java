package pojo;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
    private int id;
    private LocalTime time;
    private DayOfWeek day;
    
    public void setId(int id){
        this.id = id;
   }
    
    public int getId(){
       return id;
   }
    
    public void setTime(LocalTime time){
        this.time = time;
   }
    
    public LocalTime getTime(){
       return time;
   }
    
    public void setDay(DayOfWeek day){
        this.day = day;
   }
    
    public DayOfWeek getDay(){
       return day;
   }
    
    
}
