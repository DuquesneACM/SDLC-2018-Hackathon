package hackathon.sdlc.unittests;

import hackathon.sdlc.database.DbConn;

public class DbTest {
	// This class is not executed as part of the RunAllTests class because doing so would write
	// the test data to the production database, which is undesirable.
	public static void main(String[] args) {
		DbConn conn = new DbConn();
		conn.writeToDb("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", 
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");
	}
}
