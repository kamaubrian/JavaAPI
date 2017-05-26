package frontEnd;

import mySqlDatabase.EditDatabase;
import java.util.Scanner;

public class Main {
	static EditDatabase tes;
	
	
	public Main(){
	
	}

	public static void main(String[]args) throws Exception{
		Scanner scan = new Scanner(System.in);
		EditDatabase obj = new EditDatabase();
		int choice;
		System.out.println("Select from either of the Options\n\n1. Add User\n2. Remove User\n3. List Users");
		choice=scan.nextInt();
		
		switch(choice){
		
		case 1:
			
			break;
			
		case 2:
			
			break;
			
		case 3:
			
			break;
			
			default:
				System.out.println("Invalid Option, Enter Vaild Option");
				
				break;
		}
		
		
	}
	
}
