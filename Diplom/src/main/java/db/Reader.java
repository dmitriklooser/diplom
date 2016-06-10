package db;

import java.sql.SQLException;
import java.util.List;

import geneticalg.Module;
import geneticalg.Room.TypeRoom;

public class Reader {
	private DB db = new DB();
	
	public List<Module> readAllModules(){
		String sql = "select id, code, name, typeroomid from Module";
		return db.read(sql, (rs)->
			   					  {try{
				   						 int idx = 1;
										 int id = rs.getInt(idx++);
										 String moduleCode = rs.getString(idx++);
										 String module = rs.getString(idx++);
										 TypeRoom typeRoom = TypeRoom.valueOf(rs.getString(idx++)); 
										 Module md = null;//new Module(id, moduleCode, module, typeRoom);
										return md;
			   					   }catch(SQLException ex){
			   						   return null;
			   					   }
							 });
	}
	
	
}// class Reader 
