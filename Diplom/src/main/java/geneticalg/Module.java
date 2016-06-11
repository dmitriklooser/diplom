package geneticalg;

import geneticalg.Room.TypeRoom;

/**
 * Simple course module abstraction, which defines the Professors teaching the module.
 */
public class Module {
	private final int moduleId;
    private final String moduleCode;
    private final String module;
    private int professorIds[];
    private final TypeRoom needlab;
    
    /**
     * Initialize new Module
     * 
     * @param moduleId
     * @param moduleCode
     * @param module
     * @param professorIds
     */
    public Module(int moduleId, String moduleCode, String module, TypeRoom needlab){
        this.moduleId = moduleId;
        this.moduleCode = moduleCode;
        this.module = module;
        this.needlab = needlab;
    }
    
    /**
     * Get moduleId
     * 
     * @return moduleId
     */
    public int getId(){
        return this.moduleId;
    }
    
    /**
     * Get module code
     * 
     * @return moduleCode
     */
    public String getModuleCode(){
        return this.moduleCode;
    }
    
    /**
     * Get module name
     * 
     * @return moduleName
     */
    public String getModuleName(){
        return this.module;
    }
    
    public int[] getProfessorIds(){
        return professorIds;
    }
    public void setProfessorIds(int[] ids){
        this.professorIds = ids;
    }
    /**
     * Get random professor Id
     * 
     * @return professorId
     */
    public int getRandomProfessorId(){
        int professorId = professorIds[(int) (professorIds.length * Math.random())];
        return professorId;
    }
    public TypeRoom getNeedlab(){
        return this.needlab;
    }
}
