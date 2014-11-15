

import java.util.ArrayList;

public class Testdb {

	public static void main(String args[]){

		ArrayList<String> tag = new ArrayList<String>();
		tag.add("Health");
		tag.add("Charity");
		tag.add("Design");
		System.out.println(tag.toString());
		System.out.println(Database.tagSearch(tag).toString());
	}
	
}
	



