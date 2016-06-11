package geneticalg;

import java.util.Comparator;

public class Lessons {
    private Group gro;
    private Module mod;
    private Professor pro;
    private Room room;
    private Timeslot tmslt;
    
    public void setGroup(Group gro){
        this.gro = gro;
   }
    
    public Group getGroup(){
       return gro;
   }
    
    public void setModule(Module mod){
        this.mod = mod;
   }
    
    public Module getModule(){
       return mod;
   }
    
    public void setProfessor(Professor pro){
        this.pro = pro;
   }
    
    public Professor getProfessor(){
       return pro;
   }
    
    public void setRoom(Room room){
        this.room = room;
   }
    
    public Room getRoom(){
       return room;
   }
    
    public void setTimeslot(Timeslot tmslt){
        this.tmslt = tmslt;
   }
    
    public Timeslot getTimeslot(){
       return tmslt;
   }
    
    private static class ByDayComparator implements Comparator<Lessons>{

        @Override
        public int compare(Lessons l1, Lessons l2) {
            return l1.getTimeslot().getDay().compareTo(l2.getTimeslot().getDay());
        }
        
    }//class ByDayComparator 
   
}
