package pojo;

public class Room {
    private int id;
    private short number;
    private TypeRoom tprm;
    
    public void setId(int id){
        this.id = id;
   }
    
    public int getId(){
       return id;
   }
    
    public void setNumber(short number){
        this.number = number;
   }
    
    public short getNumber(){
       return number;
   }
    
    public void setTypeRoom(TypeRoom tprm){
        this.tprm = tprm;
   }
    
    public TypeRoom getTyperoom(){
       return tprm;
   }
}