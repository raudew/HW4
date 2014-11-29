/*INSY 4305-002 Homework 4
Joel Smith
Raude Woods
Sudhir Kayastha
Madhu Dhakal
 */

public class Student {
	private int studentID;
	private String firstName;
	private String lastName;
	private String major;
	private String email;
	private String phoneNumber;
	private Date dateOfBirth;
	private String address;
	private int zipCode;

	// no argument- constructor
	public Student() {
	} // end no-argument Student constructor

	// constructor
	public Student(int id, String first, String last, String major,
			String emailAddress, String phone, Date dateOfBirth, String address, int zip) {
		setStudentID(id);
		setFirstName(first);
		setLastName(last);
		setMajor(major);
		setEmail(emailAddress);
		setPhoneNumber(phone);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setZip(zip);
	} // end Student constructor

	// sets the studentID
	public void setStudentID(int id) {
		studentID = id;
	} // end method setStudentID

	// returns the studentID
	public int getStudentID() {
		return studentID;
	} // end method getStudentID

	// sets the firstName
	public void setFirstName(String first) {
		firstName = first;
	} // end method setFirstName

	// returns the first name
	public String getFirstName() {
		return firstName;
	} // end method getFirstName

	// sets the lastName
	public void setLastName(String last) {
		lastName = last;
	} // end method setLastName

	// returns the last name
	public String getLastName() {
		return lastName;
	} // end method getLastName

	// sets the major
	public void setMajor(String _major) {
		major = _major;
	} // end method setMajor

	// returns the major
	public String getMajor() {
		return major;
	}// end method getMajor

	// sets the email address
	public void setEmail(String emailAddress) {
		email = emailAddress;
	}// end method setEmail

	// returns the email address
	public String getEmail() {
		return email;
	}// end method getEmail

	// sets the phone number
	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}// end method setPhoneNumber

	// returns the phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}// end method getPhoneNumber

	public void setDateOfBirth(Date dob)
	{
		dateOfBirth = dob;		
	}
	
	public Date getDateOfBirth()
	{
		return dateOfBirth;		
	}
	// sets the address
	public void setAddress(String _address) {
		address = _address;
	} // end method setAddress

	// returns the address
	public String getAddress() {
		return address;
	}// end method getAddress

	// sets the zip
	public void setZip(int zip) {
		zipCode = zip;
	} // end method setzipCode

	// returns the zipCode
	public int getZip() {
		return zipCode;
	} // end method zipCode
	


} // end class HW4Student