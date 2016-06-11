package geneticalg;

/**
 * A simple "group-of-students" abstraction. Defines the modules that the group is enrolled in.
 *
 */
public class Group {
    private final int groupId;
    private final int groupSize;
    private  int moduleIds[];

    /**
     * Initialize Group
     * 
     * @param groupId
     * @param groupSize
     * @param moduleIds
     */
    public Group(int groupId, int groupSize){
        this.groupId = groupId;
        this.groupSize = groupSize;
    }
    
    /**
     * Get groupId
     * 
     * @return groupId
     */
    public int getGroupId(){
        return this.groupId;
    }
    
    /**
     * Get groupSize
     * 
     * @return groupSize
     */
    public int getGroupSize(){
        return this.groupSize;
    }
    
    public void setModuleIds(int[] moduleIds){
        this.moduleIds = moduleIds;
    }
        
    /**
     * Get array of group's moduleIds
     * 
     * @return moduleIds
     */
    public int[] getModuleIds(){
        return this.moduleIds;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Group))return false;
        Group out = (Group)obj;
        return (out.getGroupId() == this.getGroupId());
    }
    
    @Override
    public int hashCode(){
        return getGroupId();
    }
    
}

