package frontEnd;

import mySqlDatabase.Test;

public class Main {
	static Test tes;
	
	
	public Main(){
	
	}

	public static void main(String[]args) throws Exception{
		Test obj = new Test();
		obj.testConnection();
		
		
	}
	
}
