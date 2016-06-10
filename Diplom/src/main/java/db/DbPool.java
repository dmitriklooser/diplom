package db;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbPool {
	
	
	public Connection getConnection(){
		try{
			InitialContext cxt = new InitialContext();
			if ( cxt == null ) {
			   throw new Exception("Uh oh -- no context!");
			}
	
			DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );
	
			if ( ds == null ) {
			   throw new Exception("Data source not found!");
			}
			return ds.getConnection();
		}catch(Exception ex){
			ex.toString();
			return null;
		}
	}
}//class DbPool 
