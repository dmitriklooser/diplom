package db;

import java.sql.SQLException;
import java.time.LocalTime;

import geneticalg.Group;
import geneticalg.Lessons;
import geneticalg.Module;
import geneticalg.Professor;
import geneticalg.Room;
import geneticalg.Timeslot;
import web.Cache;

public class Writer {
    private static final String INS_MODULE = "insert into Module (code, name, typeRoom) " +
                                             " values (?, ?, ?)";
    private static final String INS_GROUP = "insert into Grp (id, groupsize) " +
    										" values (?, ?)";
    private static final String INS_ROOM = "insert into Room (roomNumber, capacity, typeRoom) " +
            							   " values (?, ?, ?)";
    private static final String INS_PROFESSOR = "insert into Professor (professorName) " +
            								" values (?)";
    private static final String INS_TIMESLOT = "insert into Timeslot (lessontime, day, inuse) " +
            								" values (?, ?, ?)";
    private static final String INS_LESSONS = "insert into Lesson (groupid, moduleid, professorid, roomid, timeslotid) " +
            								" values (?, ?, ?, ?, ?)";

    private static final String UPD_TIMESLOT = "update Timeslot set inuse=? where id=?";

    private static final String INS_GM_REL = "insert into grpmod (groupid, moduleid)  values(?, ?)";	
    
    private static final String DEL_GM_REL = "delete from grpmod  where groupid=? and moduleid=?";
    
    private DB db = new DB();
	
	public void writeModule(final Module md, Cache cache){
		db.write(INS_MODULE, (pStmt)->{
			try{
				int idx = 1;
				pStmt.setString(idx++, md.getModuleCode());
				pStmt.setString(idx++, md.getModuleName());
				pStmt.setString(idx++, md.getNeedlab().name());
			}catch(SQLException ex){
				ex.toString();
			}
		});
		cache.MODULE_CACHE.store(md);
	}
	
	public void writeGroup(final Group gr, Cache cache){
        db.write(INS_GROUP, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, gr.getId());
                pStmt.setInt(idx++, gr.getGroupSize());
            }catch(SQLException ex){
                ex.toString();
            }
        });
        cache.GROUP_CACHE.store(gr);
    }
	
	public void writeRoom(final Room ro, Cache cache){
        db.write(INS_ROOM, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setString(idx++, ro.getRoomNumber());
                pStmt.setInt(idx++, ro.getRoomCapacity());
                pStmt.setString(idx++, ro.getTypeRoom().name());
            }catch(SQLException ex){
                ex.toString();
            }
        });
        cache.ROOM_CACHE.store(ro);
    }
	
	public void writeProfessor(final Professor pro, Cache cache){
        db.write(INS_PROFESSOR, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setString(idx++, pro.getProfessorName());
            }catch(SQLException ex){
                ex.toString();
            }
        });
        cache.PROFESSOR_CACHE.store(pro);
    }
	
	public void writeTimeslot(final Timeslot tmsl, Cache cache){
        db.write(INS_TIMESLOT, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, tmsl.getTime().getHour());
                pStmt.setString(idx++, tmsl.getDay().name());
                pStmt.setBoolean(idx++, tmsl.isInUse());
            }catch(SQLException ex){
                ex.toString();
            }
        });
        cache.TIMESLOT_CACHE.store(tmsl);
    }
	
	public void updateTimeslot(final Timeslot tmsl, Cache cache){
        db.write(UPD_TIMESLOT, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setBoolean(idx++, tmsl.isInUse());
                pStmt.setInt(idx++, tmsl.getId());
            }catch(SQLException ex){
                ex.toString();
            }
        });
        cache.TIMESLOT_CACHE.store(tmsl);
	}
	
	
	public void writeLessons(final Lessons lss){
        db.write(INS_LESSONS, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, lss.getGroup().getId());
                pStmt.setInt(idx++, lss.getModule().getId());
                pStmt.setInt(idx++, lss.getProfessor().getId());
                pStmt.setInt(idx++, lss.getRoom().getId());
                pStmt.setInt(idx++, lss.getTimeslot().getId());
            }catch(SQLException ex){
                ex.toString();
            }
        });
    }

	public void addGMRelation(final Group grp, final Module module){
        db.write(INS_GM_REL, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, grp.getId());
                pStmt.setInt(idx++, module.getId());
            }catch(SQLException ex){
                ex.toString();
            }
        });
	}
	
	public void delGMRelation(final Group grp, final Module module){
        db.write(DEL_GM_REL, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, grp.getId());
                pStmt.setInt(idx++, module.getId());
            }catch(SQLException ex){
                ex.toString();
            }
        });
	}
	
	
}// class Writer 
