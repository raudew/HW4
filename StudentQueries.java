//public class StudentQueries {

//}
//Fig. 28.31: StudentQueries.java
//PreparedStatements used by the Address Book application.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
//C:/Users/raude.woods/eclipse-workspace/HW4/
public class StudentQueries {
	private static final String URL = "jdbc:derby:Education";
	private static final String USERNAME = "java2hw4";
	private static final String PASSWORD = "java2hw4";
	private static Connection connection = null; // manages connection
	private static PreparedStatement selectAllPeople = null;
	private static PreparedStatement selectPeopleByLastName = null;
	private static PreparedStatement insertNewStudent = null;
	private static PreparedStatement selectStudentID = null;
	private static PreparedStatement selectMaxStudentID = null;	
	

	// constructor
	public StudentQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// create query that selects all entries in the AddressBook
			selectAllPeople = connection
					.prepareStatement("SELECT * FROM student");
			// create query that selects entries with a specific last name
			selectPeopleByLastName = connection
					.prepareStatement("SELECT * FROM student WHERE LastName = ?");
			// create insert that adds a new entry into the database
			insertNewStudent = connection
					.prepareStatement("INSERT INTO student ( FirstName, LastName, Major, Email, PhoneNumber, birthDate, Address, zipCode ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )");
			// query that selects studentID to see if exists
			selectStudentID = connection
					.prepareStatement("select MAX(studentID) as MAXStudentID, (SELECT studentID from Student where studentID=?) as studentIDcheck from student");
			
	
			// query that gets nexx studentID
			selectMaxStudentID = connection
					.prepareStatement("SELECT Max(studentID) as MaxStudentiD FROM student");
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	}// end StudentQueries constructor

	// select all of the addresses in the database
	public static List<Student> getAllPeople() {
		List<Student> results = null;
		ResultSet resultSet = null;
		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Student>();
			while (resultSet.next()) {
				results.add(new Student(resultSet.getInt("studentID"),
						resultSet.getString("FirstName"), 
						resultSet.getString("LastName"), 
						resultSet.getString("Major"), resultSet
								.getString("Email"), resultSet
								.getString("PhoneNumber"), 
								Date.parseDate(resultSet.getString("birthDate")),
						resultSet.getString("Address"), resultSet.getInt("zipCode")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	}// end method getAllPeople

	// select Student by last name
	public static List<Student> getPeopleByLastName(String name) {
		List<Student> results = null;
		ResultSet resultSet = null;

		try {
			selectPeopleByLastName.setString(1, name); // specify last name
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectPeopleByLastName.executeQuery();
			results = new ArrayList<Student>();

			while (resultSet.next()) {
				results.add(new Student(resultSet.getInt("studentID"),
						resultSet.getString("FirstName"), resultSet
								.getString("LastName"), resultSet
								.getString("Major"), resultSet
								.getString("Email"), resultSet
								.getString("PhoneNumber"), Date
								.parseDate(resultSet.getString("birthDate")),
						resultSet.getString("Address"), resultSet.getInt("zipCode")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getPeopleByName

	// add an entry
	public static int addStudent(String fname, String lname, String major, String email, String phonenum, Date birthdate, String addr, int zipCode) {
		int result = 0;
		java.sql.Date nDate = new java.sql.Date(birthdate.getMonth(), birthdate.getDay(), birthdate.getYear());
		// set parameters, then execute insertNewStudent
		try {

			insertNewStudent.setString(1, fname);
			insertNewStudent.setString(2, lname);
			insertNewStudent.setString(3, major);
			insertNewStudent.setString(4, email);
			insertNewStudent.setString(5, phonenum);
			insertNewStudent.setDate(6, nDate);
			insertNewStudent.setString(7, addr);
			insertNewStudent.setInt(8, zipCode);
			// insert the new entry; returns # of rows updated
			result = insertNewStudent.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	} // end method addStudent

	public static List getStudentID(int _studentID) {
		List results = null;
		ResultSet resultSet = null;

		try {
			selectStudentID.setInt(1, _studentID);  
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectStudentID.executeQuery();
			results = new ArrayList();

			while (resultSet.next()) {
				results.add(resultSet.getInt("MaxStudentID"));
				results.add(resultSet.getInt("studentIDcheck"));
				
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getPeopleByName

	
	// close the database connection
	public static void close() {
		try {
			connection.close();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
	} // end method close
} // end class StudentQueries