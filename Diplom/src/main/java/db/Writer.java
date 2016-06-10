package db;

import java.sql.SQLException;

import geneticalg.Module;

public class Writer {
	private DB db = new DB();
	
	public void writeModule(Module md){
		String sql = "insert into Module (id, code, name, typeroomid) " +
						  " values (?, ?, ?, ?)";
		db.write(sql, (pStmt)->{
			try{
				int idx = 1;
				pStmt.setInt(idx++, md.getModuleId());
				pStmt.setString(idx++, md.getModuleCode());
				pStmt.setString(idx++, md.getModuleName());
				pStmt.setString(idx++, md.getNeedlab().name());
			}catch(SQLException ex){
				ex.toString();
			}
		});
	}
	
}// class Writer 
