package mySqlDatabase;
import java.sql.*;

public abstract class ConnectDatabase {

	public static String dbUsername ="root";
	public static String dbUrl ="jdbc:mysql://localhost:3306/TestAPI?useSSL=false";
	public static String dbPassword="wamatu";
	public static String dbDriver="com.mysql.cj.jdbc.Driver";
	protected PreparedStatement pst =null;
	protected Statement stat = null;
	protected Connection conn = null;
	protected ResultSet rst= null;
	
	protected ConnectDatabase() throws Exception{
		String sql;
		dbConnect();
		try{
			stat = conn.createStatement();
			sql="CREATE TABLE IF NOT EXISTS Credentials(Name VARCHAR(30) NOT NULL,Identification INTEGER"
					+ " NOT NULL,Username VARCHAR(30) NOT NULL, Password VARCHAR (30) NOT NULL,PRIMARY KEY"
					+ "(Identification))";
			stat.addBatch(sql);
			stat.executeBatch();
		}catch(Exception ex){
			System.err.println("Error In Connection"+ex.getMessage());
		}
		
		dbDisconnect();
	}	
	protected final boolean dbConnect() throws Exception {
		boolean success = true;
		try{
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			success = true;
			System.out.println("Database Connection Successful");
		}catch(Exception ex){
			System.out.println("Database Error"+ex.getMessage());
			success=false;
		}				
		return success;
	}
	protected final boolean dbDisconnect() throws Exception{
		boolean success = true;
		try{
			if(rst!=null){
				rst.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}			
		}catch(Exception ex){
			System.err.println("Error Message"+ex.getMessage());
		}	
		return success;
	}
	
}
