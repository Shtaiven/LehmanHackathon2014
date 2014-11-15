

import java.util.ArrayList;

public class Testdb {

	public static void main(String args[]){

		ArrayList<String> tags = new ArrayList<String>();
		tags.add("Health");
		tags.add("Charity");
		tags.add("Design");
		System.out.println(tags.toString());		
		System.out.println(Database.findEvents(tags).toString());
		System.out.println(Database.getLocation("Hackathon"));
		System.out.println(Database.getTime("Hackathon"));
//		System.out.println(Database.getTags("Hackathon").toString());
		System.out.println(Database.getCost("Hackathon"));
		System.out.println(Database.getInfo("Hackathon"));
	}
	
}
	



