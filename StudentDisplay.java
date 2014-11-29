// Fig. 28.32: AddressBookDisplay.java
// A simple address book
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

//
public class StudentDisplay extends JFrame {
	private Student currentEntry;
	private StudentQueries studentQueries;
	private List<Student> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;
	//
	private int entryStatus = 0;// 0=new, 1=insert
	private JButton browseButton;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel idLabel;
	private JTextField idTextField;
	private JTextField indexTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	
	private JLabel majorLabel;
	private JTextField majorTextField;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthTextField;
	private JLabel addrLabel;
	private JTextField addrTextField;
	private JLabel zipLabel;
	private JTextField zipTextField;
	
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JButton previousButton;
	private JButton queryButton;
	private JLabel queryLabel;
	private JPanel queryPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;

	//
	// no-argument constructor
	public StudentDisplay() {
		super("Maintain Student Data");
		//
		// establish database connection and set up PreparedStatements
		studentQueries = new StudentQueries();
		// create GUI
		navigatePanel = new JPanel();
		previousButton = new JButton();
		indexTextField = new JTextField(2);
		ofLabel = new JLabel();
		maxTextField = new JTextField(2);
		nextButton = new JButton();
		displayPanel = new JPanel();
		idLabel = new JLabel();
		idTextField = new JTextField(10);
		firstNameLabel = new JLabel();
		firstNameTextField = new JTextField(10);
		lastNameLabel = new JLabel();
		lastNameTextField = new JTextField(10);
		majorLabel = new JLabel();
		majorTextField = new JTextField(10);
		emailLabel = new JLabel();
		emailTextField = new JTextField(10);
		phoneLabel = new JLabel();
		phoneTextField = new JTextField(10);
		dateOfBirthLabel = new JLabel();
		dateOfBirthTextField = new JTextField(10);
		addrLabel = new JLabel();
		addrTextField = new JTextField(10);

		zipLabel = new JLabel();
		zipTextField = new JTextField(10);


		queryPanel = new JPanel();
		queryLabel = new JLabel();
		queryTextField = new JTextField(10);
		queryButton = new JButton();
		browseButton = new JButton();
		insertButton = new JButton();
		//
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(400, 800);
		setResizable(false);
		//
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
		//
		previousButton.setText("Previous");
		previousButton.setEnabled(false);
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				previousButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		//
		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				indexTextFieldActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		//
		ofLabel.setText("of");
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		//
		nextButton.setText("Next");
		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nextButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		navigatePanel.add(nextButton);
		add(navigatePanel);
		//
		displayPanel.setLayout(new GridLayout(13, 2, 9, 9));
		// 1
		idLabel.setText("Student ID:");
		displayPanel.add(idLabel);
		// 2
		idTextField.setEditable(false);
		displayPanel.add(idTextField);
		// 3
		firstNameLabel.setText("First Name:");
		displayPanel.add(firstNameLabel);
		displayPanel.add(firstNameTextField);
		// 4
		lastNameLabel.setText("Last Name:");
		displayPanel.add(lastNameLabel);
		displayPanel.add(lastNameTextField);
		// 5
		majorLabel.setText("Major:");
		displayPanel.add(majorLabel);
		displayPanel.add(majorTextField);
		// 6
		emailLabel.setText("Email:");
		displayPanel.add(emailLabel);
		displayPanel.add(emailTextField);
		// 7
		phoneLabel.setText("Phone Number:");
		displayPanel.add(phoneLabel);
		displayPanel.add(phoneTextField);
		// 8
		dateOfBirthLabel.setText("Date Of Birth:");
		displayPanel.add(dateOfBirthLabel);
		displayPanel.add(dateOfBirthTextField);
		// 9
		addrLabel.setText("Address:");
		displayPanel.add(addrLabel);
		displayPanel.add(addrTextField);
		// 10
		zipLabel.setText("Zip Code:");
		displayPanel.add(zipLabel);
		displayPanel.add(zipTextField);
		//
		add(displayPanel);
		// 11
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		// 12
		queryPanel.setBorder(BorderFactory
				.createTitledBorder("Find an entry by last name"));
		queryLabel.setText("Last Name:");
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(queryLabel);
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));

		queryButton.setText("Find");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				queryButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		add(queryPanel);
		//
		browseButton.setText("Browse All Entries");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		add(browseButton);
		//
		insertButton.setText("Insert New Entry");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				insertButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener
					//
		add(insertButton);
		//
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				StudentQueries.close(); // close database connection
				System.exit(0);
			} // end method windowClosing
		} // end anonymous inner class
		); // end call to addWindowListener
			//
		setVisible(true);
	} // end no-argument constructor
		//
	// handles call when previousButton is clicked

	private void previousButtonActionPerformed(ActionEvent evt) {
		currentEntryIndex--;
		//
		if (currentEntryIndex < 0)
			currentEntryIndex = numberOfEntries - 1;
		//
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	} // end method previousButtonActionPerformed
		//
	// handles call when nextButton is clicked

	private void nextButtonActionPerformed(ActionEvent evt) {
		currentEntryIndex++;
		//
		if (currentEntryIndex >= numberOfEntries)
			currentEntryIndex = 0;
		//
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	} // end method nextButtonActionPerformed
		//
	// handles call when queryButton is clicked

	private void queryButtonActionPerformed(ActionEvent evt) {
		results = StudentQueries.getPeopleByLastName(queryTextField.getText());
		numberOfEntries = results.size();
		//
		if (numberOfEntries != 0) {
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getStudentID());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextField.setText(currentEntry.getLastName());
			majorTextField.setText(currentEntry.getMajor());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			dateOfBirthTextField.setText(currentEntry.getDateOfBirth().toString());
			addrTextField.setText(currentEntry.getAddress());
			zipTextField.setText(Integer.toString(currentEntry.getZip()));
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
			nextButton.setEnabled(true);
			previousButton.setEnabled(true);
		} // end if
		else
			browseButtonActionPerformed(evt);
	} // end method queryButtonActionPerformed
		//
	// handles call when a new value is entered in indexTextField

	private void indexTextFieldActionPerformed(ActionEvent evt) {
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);
		//
		if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getStudentID());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextField.setText(currentEntry.getLastName());
			majorTextField.setText(currentEntry.getMajor());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			dateOfBirthTextField.setText(currentEntry.getDateOfBirth().toString());
			addrTextField.setText(currentEntry.getAddress());
			zipTextField.setText(Integer.toString(currentEntry.getZip()));
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
		} // end if
	} // end method indexTextFieldActionPerformed
		//
	// handles call when browseButton is clicked

	private void browseButtonActionPerformed(ActionEvent evt) {
		try {
			results = StudentQueries.getAllPeople();
			numberOfEntries = results.size();

			if (numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				idTextField.setText("" + currentEntry.getStudentID());
				firstNameTextField.setText(currentEntry.getFirstName());
				lastNameTextField.setText(currentEntry.getLastName());
				majorTextField.setText(currentEntry.getMajor());
				emailTextField.setText(currentEntry.getEmail());
				phoneTextField.setText(currentEntry.getPhoneNumber());
				dateOfBirthTextField.setText(currentEntry.getDateOfBirth().toString());
				addrTextField.setText(currentEntry.getAddress());
				zipTextField.setText(Integer.toString(currentEntry.getZip()));
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			} // end if
		} // end try
		catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end method browseButtonActionPerformed
// handles call when insertButton is clicked

	private void insertButtonActionPerformed(ActionEvent evt) {
		//is this first time? 
		if(entryStatus==0)
		{
		//yes = clear fields
			clearForm();			
			entryStatus=1;
		}
		else
		{
		//no = check fields, enter data.
			validateForm();
			List studentIDList = StudentQueries.getStudentID(Integer.parseInt(idTextField.getText()));
			if(studentIDList.get(1)!=null)
			{
				//studentID exist.
				int t = Integer.parseInt(studentIDList.get(0).toString());
				t++;
				JOptionPane.showMessageDialog(this, 
						"That Student record exists\n\r\n\rPlease try another.\n\r"
								+ "\n\r  We suggest that you use the next one @ "+ t +".",
						"Student Record Exists!", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int result = StudentQueries.addStudent(
					firstNameTextField.getText(),
					lastNameTextField.getText(),
					majorTextField.getText(),
					emailTextField.getText(),
					phoneTextField.getText(),
					Date.parseDate(dateOfBirthTextField.getText()),
					addrTextField.getText(),
					Integer.parseInt(zipTextField.getText()));
				if (result == 1)
					JOptionPane.showMessageDialog(this, "Student added!",
							"Student added", JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(this, "Student not added!", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		
		
		
		//
		browseButtonActionPerformed(evt);
	} // end method insertButtonActionPerformed
		//
	// main method
	
	private  void clearForm()
	{
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		majorTextField.setText("");
		emailTextField.setText("");
		phoneTextField.setText("");
		dateOfBirthTextField.setText("");
		addrTextField.setText("");
		zipTextField.setText("");
	}
	
	private  boolean validateForm()
	{
		String msg ="";
		if(firstNameTextField.getText().length()==0){msg+="\n\r First Name Required."; };
		if(lastNameTextField.getText().length()==0){msg+="\n\r Last Name Required."; };
		if(majorTextField.getText().length()==0){msg+="\n\r Major Required."; };
		if(emailTextField.getText().length()==0){msg+="\n\r eMail Required."; };
		if(phoneTextField.getText().length()==0){msg+="\n\r Phone Required."; };
		if(dateOfBirthTextField.getText().length()==0){msg+="\n\r Date Of Birth Required."; };
		if(addrTextField.getText().length()==0){msg+="\n\r Address Required."; };
		if(zipTextField.getText().length()==0){msg+="\n\r Zip Code Required."; };
		if(msg!="")
		{
			JOptionPane.showMessageDialog(this, msg, "Form Validation",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;

	}
	public static void main(String args[]) {
		new StudentDisplay();
	} // end method main
} // end class AddressBookDisplay