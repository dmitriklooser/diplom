package db;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import geneticalg.Group;
import geneticalg.Lessons;
import geneticalg.Module;
import geneticalg.Professor;
import geneticalg.Room;
import geneticalg.Room.TypeRoom;
import web.Cache;
import geneticalg.Timeslot;

public class Reader {
    private static final String READ_ALL_MODULE = "select id, code, name, typeroomid from Module";
    private static final String READ_ALL_GROUP = "select id, groupSize from Grp";
    private static final String READ_ALL_ROOM = "select id, number, capacity, typeRoomId from Room";
    private static final String READ_ALL_PROFESSOR = "select id, name from Professor";
    private static final String READ_ALL_TIMESLOT = "select id, time, day from Timeslot";
    private static final String READ_PROFESOR_IDS = "select professorId from ModProf where moduleId=";
    private static final String READ_MODULE_IDS = "select moduleId from GrpMod where groupId=";
    private static final String READ_ALL_LESSONS = "select groupId, moduleId, professorId, roomId, timeslotId from Lessons";
    private DB db = new DB();
    
	private int[] readIds(String sql){
	    return db.read(sql, (rs)->
            	            {  try{
            	                    int id = rs.getInt(1);
            	                    return id;
            	                }catch(SQLException ex){
            	                    return null;
            	                }
            	            }).stream().mapToInt((id)->id.intValue()).toArray();

	}
    
	public List<Module> readAllModules(){
		
		return db.read(READ_ALL_MODULE, (rs)->
			   					  {try{
				   						 int idx = 1;
										 int id = rs.getInt(idx++);
										 String moduleCode = rs.getString(idx++);
										 String module = rs.getString(idx++);
										 TypeRoom typeRoom = TypeRoom.valueOf(rs.getString(idx++)); 
										 Module md = new Module(id, moduleCode, module, typeRoom);
										 int[] professorIds = readIds(READ_PROFESOR_IDS + id);
										 md.setProfessorIds(professorIds);
										return md;
			   					   }catch(SQLException ex){
			   						   return null;
			   					   }
							     });
	}
	
    public List<Group> readAllGroups(){
            
            return db.read(READ_ALL_GROUP, (rs)->
                                      {try{
                                             int idx = 1;
                                             int id = rs.getInt(idx++);
                                             int groupSize = rs.getInt(idx++); 
                                             Group gr = new Group(id, groupSize);
                                             int[] moduleIds = readIds(READ_MODULE_IDS + id);
                                             gr.setModuleIds(moduleIds);
                                            return gr;
                                       }catch(SQLException ex){
                                           return null;
                                       }
                                     });
        }
    
    public List<Room> readAllRooms(){
        
        return db.read(READ_ALL_ROOM, (rs)->
                                  {try{
                                         int idx = 1;
                                         int id = rs.getInt(idx++);
                                         String roomNumber = rs.getString(idx++); 
                                         int capacity = rs.getInt(idx++);
                                         TypeRoom typeRoom = TypeRoom.valueOf(rs.getString(idx++));
                                         Room ro = new Room(id, roomNumber, capacity, typeRoom);
                                        return ro;
                                   }catch(SQLException ex){
                                       return null;
                                   }
                                 });
    }
    
    public List<Professor> readAllProfessors(){
            
            return db.read(READ_ALL_PROFESSOR, (rs)->
                                      {try{
                                             int idx = 1;
                                             int id = rs.getInt(idx++);
                                             String professorName = rs.getString(idx++); 
                                             Professor pro = new Professor(id, professorName);
                                            return pro;
                                       }catch(SQLException ex){
                                           return null;
                                       }
                                     });
        }
    
    public List<Timeslot> readAllTimeslots(){
        
        return db.read(READ_ALL_TIMESLOT, (rs)->
                                  {try{
                                         int idx = 1;
                                         int id = rs.getInt(idx++);
                                         LocalTime time = LocalTime.of(rs.getInt(idx++), 0);
                                         DayOfWeek day = DayOfWeek.valueOf(rs.getString(idx++)); 
                                         Timeslot ts = new Timeslot(id, time, day);
                                        return ts;
                                   }catch(SQLException ex){
                                       return null;
                                   }
                                 });
    }
	
    public List<Lessons> readAllLessons(Cache cache){

    	return db.read(READ_ALL_LESSONS, (rs)->
									        {try{
									               int idx = 1;
									               int groupId = rs.getInt(idx++);
									               int moduleId = rs.getInt(idx++);
									               int professorId = rs.getInt(idx++);
									               int roomId = rs.getInt(idx++);
									               int timeslotId = rs.getInt(idx++);
									               Lessons ls = new Lessons();
									               ls.setGroup(cache.GROUP_CACHE.get(groupId));
									               ls.setModule(cache.MODULE_CACHE.get(moduleId));
									               ls.setProfessor(cache.PROFESSOR_CACHE.get(professorId));
									               ls.setRoom(cache.ROOM_CACHE.get(roomId));
									               ls.setTimeslot(cache.TIMESLOT_CACHE.get(timeslotId));
									              return ls;
									         }catch(SQLException ex){
									             return null;
									         }
									       });
    }
}

// class Reader 
