package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;


public class DB {
	
	public Connection getConnection(){
		try{
			DriverManager.registerDriver(new	org.postgresql.Driver());
			String url = "jdbc:postgresql://localhost:5432/timetable";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","postgre");
			props.setProperty("ssl","false");
			Connection conn = DriverManager.getConnection(url, props);
			return conn;
		}catch(SQLException ex){
			ex.toString();
			return null;
		}
	}
	
	
	public<T> List<T> read(String sql,  Function<ResultSet, T> func){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<T> items = new ArrayList<>();
			T item = null;
			while(rs.next()){
				item = func.apply(rs);
				if(item != null){
					items.add(item);
				}
			}
			return items;
		}catch(SQLException ex){
			return null;
			
		}finally{
			try{
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(SQLException ex){}
		}
	}
	
	
	public void write(String sql, Consumer<PreparedStatement> setter){
		Connection conn = null;
		PreparedStatement pStmt = null;
		try{
			conn = getConnection();
			pStmt = conn.prepareStatement(sql);
			setter.accept(pStmt);
			pStmt.execute();
		}catch(SQLException ex){
			ex.toString();
		}finally{
			try{
				if(pStmt != null)pStmt.close();
				if(conn != null)conn.close();
			}catch(SQLException ex){}
		}
	}
	
	public void run(String sql){
		Connection conn = null;
		Statement stmt = null;
	}
}//class DB 
