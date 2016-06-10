package pojo;

public class Module {
    private int id;
    private String code;
    private String name;
    private TypeRoom tprm;
    
    public void setId(int id){
        this.id = id;
   }
    
    public int getId(){
       return id;
   }
    
    public void setCode(String code){
        this.code = code;
   }
    
    public String getCode(){
       return code;
   }
    
    public void setName(String name){
        this.name = name;
   }
    
    public String getName(){
       return name;
   }
    
    public void setTypeRoom(TypeRoom tprm){
        this.tprm = tprm;
   }
    
    public TypeRoom getTyperoom(){
       return tprm;
   }
   
}
