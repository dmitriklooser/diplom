package db;

import java.sql.SQLException;
import java.time.LocalTime;

import geneticalg.Group;
import geneticalg.Lessons;
import geneticalg.Module;
import geneticalg.Professor;
import geneticalg.Room;
import geneticalg.Timeslot;

public class Writer {
    private static final String INS_MODULE = "insert into Module (code, name, typeRoom) " +
                                             " values (?, ?, ?)";
    private static final String INS_GROUP = "insert into Group (id, groupSize) " +
            " values (?, ?)";
    private static final String INS_ROOM = "insert into Room (roomNumber, capacity, typeRoom) " +
            " values (?, ?, ?)";
    private static final String INS_PROFESSOR = "insert into Professor (professorName) " +
            " values (?)";
    private static final String INS_TIMESLOT = "insert into Timeslot (lessontime, day, inuse) " +
            " values (?, ?, ?)";
    private static final String INS_LESSONS = "insert into Lesson (groupid, moduleid, professorid, roomid, timeslotid) " +
            " values (?, ?, ?, ?, ?)";

    private DB db = new DB();
	
	public void writeModule(final Module md){
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
	}
	
	public void writeGroup(final Group gr){
        db.write(INS_GROUP, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setInt(idx++, gr.getId());
                pStmt.setInt(idx++, gr.getGroupSize());
            }catch(SQLException ex){
                ex.toString();
            }
        });
    }
	
	public void writeRoom(final Room ro){
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
    }
	
	public void writeProfessor(final Professor pro){
        db.write(INS_PROFESSOR, (pStmt)->{
            try{
                int idx = 1;
                pStmt.setString(idx++, pro.getProfessorName());
            }catch(SQLException ex){
                ex.toString();
            }
        });
    }
	
	public void writeTimeslot(final Timeslot tmsl){
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
	
}// class Writer 
