package geneticalg;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Comparator;

public class Lesson {

    private DayOfWeek day;
    private LocalTime time;
    private ModRoomTeach mrt;
    public static final ByDayComparator BY_DAY_COMPARATOR = new ByDayComparator();
    
    
    public void setDayOfWeek(DayOfWeek day){
        this.day = day;
    }
   
    public DayOfWeek getDayOfWeek(){
       return day;
    }
   
    public void setLocalTime(LocalTime time){
       this.time = time;
    }
  
    public LocalTime getLocalTime(){
      return time;
    }
    
    public void setModRoomTeach(ModRoomTeach mrt){
        this.mrt = mrt;
    }
    
    public ModRoomTeach getModRoomTeach(){
        return mrt;
    }
    
    
private static class ByDayComparator implements Comparator<Lesson>{

    @Override
    public int compare(Lesson l1, Lesson l2) {
        return l1.getDayOfWeek().compareTo(l2.getDayOfWeek());
    }
    
}//class ByDayComparator 
} // class Lesson 
