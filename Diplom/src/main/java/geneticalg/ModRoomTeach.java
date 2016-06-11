package geneticalg;

public class ModRoomTeach {
	
	private Professor professor;
	private Room room;
	private Module module;
	
	public void setProfessor(Professor professor){
	     this.professor = professor;
	}
	
    public Professor getProfessor(){
        return professor;
    }
    
    public void setRoom(Room room){
        this.room = room;
   }
   
   public Room getRoom(){
       return room;
   }
   
   public void setModule(Module module){
       this.module = module;
  }
  
  public Module getModule(){
      return module;
  }
	
}
