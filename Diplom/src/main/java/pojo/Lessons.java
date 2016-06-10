package pojo;

public class Lessons {
    private Grp gro;
    private Module mod;
    private Professor pro;
    private Room room;
    private Timeslot tmslt;
    
    public void setGrp(Grp gro){
        this.gro = gro;
   }
    
    public Grp getGrp(){
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
    
   
}
