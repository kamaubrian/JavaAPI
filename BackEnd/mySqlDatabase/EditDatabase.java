package mySqlDatabase;

import java.util.*;

public class EditDatabase extends ConnectDatabase{
	
	public EditDatabase() throws Exception{
		super();		
	}
	
	public void testConnection() throws Exception{
		dbConnect();
	}
	
	public ArrayList<String> getNames(String name) throws Exception{
		ArrayList names = new ArrayList();
		String sql;
		dbConnect();
		try{
			sql="SELECT *FROM Credentials WHERE Name=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			rst=pst.executeQuery();
			
			while(rst.next()){
				ArrayList list = new ArrayList();
				list.add(rst.getString("Name").replace("[",""));
				list.add(rst.getString("Username"));
				list.add(rst.getInt("Identification"));
				names.add(list);
			}
			
		}catch(Exception ex){
			System.out.println("Error Database"+ex.getMessage());
		}				
		dbDisconnect();
		return names;
	}
	
	public boolean checkNameExists(String name) throws Exception{
		return !getNames(name).isEmpty();
	}
	
	public boolean addUser(String user,int id,String name,String pass) throws Exception{
		boolean success = true;
		dbConnect();
		String sql;
		try{
			sql="INSERT INTO `Credentials`(`Name`,`Identification`,`Username`,`Password`) VALUES(?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setInt(2,id);
			pst.setString(3,user);
			pst.setString(4,pass);
			pst.executeUpdate();
		}catch(Exception ex){
			System.err.println("Error"+ex.getMessage());
			success = false;
		}
		dbDisconnect();
	return success;	
	}
	public boolean removeUser(String name) throws Exception{
		boolean success= true;
		String sql;
		dbConnect();
		try{
			sql="DELETE FROM Credentials WHERE Name = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.executeUpdate();
			success= true;
		}catch(Exception ex){
			System.err.println("Removing user from Database Error ");
			success= false;
		}
		
		dbDisconnect();
		return success;
	}
	
	
	
}
