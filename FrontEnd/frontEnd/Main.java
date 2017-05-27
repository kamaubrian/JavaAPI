package frontEnd;

import mySqlDatabase.EditDatabase;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {		
	public Main(){	
	}

	public static void main(String[]args) throws Exception{
		Scanner scan = new Scanner(System.in);
		EditDatabase obj = new EditDatabase();
		int choice;
		System.out.println("Select from either of the Options\n\n1. Add User\n2. Remove User\n3. List Users");
		choice=scan.nextInt();
		scan.close();
		switch(choice){
		
		case 1:
			
			addUsers("Kamau",78,"admn","wamat");
			break;
			
		case 2:
			removeUser("Brian");
			break;
			
		case 3:
			getUsers("Brian");
			break;
			
			default:
				System.out.println("Invalid Option, Enter Vaild Option");
				
				break;
		}
		
		
	}
	
	public static void addUsers(String name,int id,String user,String pass) throws Exception{
		Scanner scam = new Scanner(System.in);
		EditDatabase tes = new EditDatabase();
		if(!tes.checkNameExists(name)){
			tes.addUser(user, id, name, pass);
		}else{
			System.out.println("User Already Exists");
		}
	}
	
	public static ArrayList<String> getUsers(String name) throws Exception{
		ArrayList names = new ArrayList();
		EditDatabase tes = new EditDatabase();
		System.out.println(tes.getNames(name));
		
		
		
		return names;
	}
	public static void removeUser(String name) throws Exception{
		EditDatabase tes = new EditDatabase();
		if(tes.checkNameExists(name)){
			tes.removeUser(name);
		}else{
			System.out.println("User Does Not Exist");
		}
		
	}
	
	
}
