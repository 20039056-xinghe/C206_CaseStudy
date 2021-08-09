import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class C206_CaseStudy {

	public static ArrayList<Registration> regiList = new ArrayList<Registration>(); // Done by Marcus
	public static ArrayList<Students> studentList = new ArrayList<Students>(); // done by Jason
	public static ArrayList<Enquiries> enquiryList = new ArrayList<Enquiries>(); // Done by Sanjeev
	public static ArrayList<TuitionTimetable> timetableList = new ArrayList<TuitionTimetable>(); // Done by Jerald
	
	public static ArrayList<TuitionAdministrator> adminAccList = new ArrayList<TuitionAdministrator>();// Done by Marcus
	public static ArrayList<TuitionManager> managerAccList = new ArrayList<TuitionManager>();// Done by Jerald
	
	public static int accVersion = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startMain(); 
	}

	private static void startMain() { // Done by Marcus
		int logOption = -1;
		
		while (logOption != 3) {// Done by Marcus
			loginMenu();
			logOption = Helper.readInt("Enter choice > ");

			if (logOption == 1) { // Done by Marcus
				startLoginAcc();
			} else if (logOption == 2) { // Done by Marcus
				startRegAcc();
			} else if (logOption == 3) { // Done by Marcus
				System.out.println("Good bye!");
			}
			
		}
	}
	
	//---------------------------------Register Marcus---------------------------------//
	
	private static void RegisterMenu() { // Done by Marcus
		Helper.line(70, "-");
		System.out.println("REGISTRATION TUITION TIMETABLE MENU");
		Helper.line(70, "-");
		System.out.println("1. Register for Tuition Timetable"); // Done by Marcus
		System.out.println("2. View All Registration"); // Done by Marcus
		System.out.println("3. Delete Registration"); // Done by Marcus
		System.out.println("4. Quit"); // Done by Marcus
	}
	
	private static void startRegistration(Students stuObject) {
	int regiOption = -1;
			
		while (regiOption != 4) {
			RegisterMenu();
			regiOption = Helper.readInt("Enter choice > ");
	
			if (regiOption == 1) {
				Registration regiObject = createRegiObject(stuObject);
				addRegistration(regiObject, regiList);
			} 
			else if (regiOption == 2) {
				
			} 
			else if (regiOption == 3) {
				int regiID = Helper.readInt("Please enter the registration ID of the registration to be deleted > ");
				deleteRegistration(regiList,regiID);
			}
			else if (regiOption == 4) {
				System.out.println("Good bye!");
			}
				
		}
		
	}

	protected static Registration createRegiObject(Students stuObject) {
		// registration number = Registration id must be unique.
		// tuition timetable id
		// student’s email
		// status which is initially set to “Pending”
		// registration date/time
		
		boolean check = false;
		Registration regi = null;

		while (check == false) {
			int regiID = Helper.readInt("Registration ID > "); // Done by Marcus
			boolean checkID = checkForDupeRegiNum(regiID);
			
			if (checkID == false) { // Done by Marcus
				
				boolean checkTimetable = false;

				while (checkTimetable == false) { // Done by Marcus
					int timeTableID = Helper.readInt("Time Table ID > "); // Done by Marcus
					boolean checkTTID = checkForValidTimeTableID(timeTableID);
	
					if (checkTTID == true) {
						String stuEmail = stuObject.getStudentEmail(); // Done by Marcus
						regi = new Registration(regiID, timeTableID, stuEmail);
						check = true;
						checkTimetable = true;
					}
					else {
						System.out.println("Please enter a valid time Table ID.");// Done by Marcus
					}
				}
				
			} else { // Done by Marcus
				System.out.println("Please use a unique Registration ID"); // Done by Marcus
			}
		}
		
		return regi;
	}
	
	protected static void addRegistration(Registration regiObject, ArrayList<Registration> regiList) { // Done by Marcus
		boolean repeat = true;
		
		
		
		if (repeat == false) {
			regiList.add(regiObject);
			System.out.println("Successfully added registration");
		}
		else {
			System.out.println("Invalid input");
		}
		
	}

	private static boolean checkForDupeRegiNum(int regiID) { // Done by Marcus
		boolean repeat = false;
		for (Registration x : regiList) { // Done by Marcus
			if (x.getRegID() == regiID) {
				repeat = true;
			}
		}
		return repeat;
	}
	
	private static boolean checkForValidTimeTableID(int timeTableID) {
		boolean valid = false;
		
		for (TuitionTimetable x:timetableList) {
			if (x.getTimetableID() == timeTableID) {
				valid = true;
			}
		}
		
		
		return valid;
	}

	protected static String retriveAllRegistration(ArrayList<Registration> regiList) {
		String output = "";
		if (regiList.size() == 0) {
			output = "No registration found";
		} else if (regiList.size() > 0) {
			output = String.format("%-5s %-10s %-30s %-10s %-20s", "RegID", "TimeTableID", "Student Email", "Status",
					"RegDateTime");
			for (Registration x : regiList) {
				output += x.display();
			}
		}
		return output;
	}
	
	protected static void viewAllRegistration(ArrayList<Registration> regiList) { // Done by Marcus
		String output = retriveAllRegistration(regiList);
		System.out.println(output);
	}

	protected static void deleteRegistration(ArrayList<Registration> regiList, int regiID) { // Done by Marcus

		boolean check = false;
		for (Registration x : regiList) {
			if (x.getRegID() == regiID) {
				check = true;
				regiList.remove(x);
				System.out.println("Registration succesfully deleted");
			}
		}
		if (check == false) { // Done by Marcus
			System.out.println("No registration delete, invalid registration ID.");
		}
	}
	
	
	//---------------------------------Student Jason---------------------------------//

	public static void studentRegistrationStart() {// done by Jason

		int option = -1;

		while (option != 7) {
			studentRegistrationMenu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				viewAllStudents();
			} else if (option == 2) {
				addNewStudent(studentList, null);
			} else if (option == 3) {
				deleteStudent(studentList, null);
			} else if (option == 4) {
				searchStudent();
			} else
				System.out.println("GoodBye");
		}
	}



	private static void studentRegistrationMenu() { // Done by Jason
		System.out.println("1) View all students\n2) Register new student\n3) Delete a student");

	}

	private static void viewAllStudents() { // Done by Jason

		//Password cannot be viewed
		String view = String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-40s", "Student name", "Gender", "Email",
				"DOB", "Country", "Feedback");
		for (int i = 0; i < studentList.size(); i++) {
			Students r = studentList.get(i);
			view += String.format("%-10d %-20s %-15s %-10s\n", r.getStudentName(), r.getStudentGender(),
					r.getStudentEmail(), r.getStudentDOB(), r.getStudentCountry(), r.getStudentFeedback());
		}
		System.out.println(view);
	}

	public static void addNewStudent(ArrayList<Students> studentList, Students student1) { // Done by Jason
		System.out.println("Register a new Student");
		String studentName = Helper.readString("Name> ");
		String studentGender = Helper.readString("Gender> ");
		int studentMobile = Helper.readInt("Mobile number> ");
		String studentEmail = Helper.readString("Email> ");
		String studentDOBString = Helper.readString("Date of birth dd-MM-yyyy> ");
		String studentCountry = Helper.readString("Country of residence> ");
		String studentFeedback = Helper.readString("Feedback> ");
		String studentPassword = Helper.readString("Password> ");

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate inputDOB = LocalDate.parse(studentDOBString, formatter1);

		if (duplicateEmail(studentEmail) == false) {
			studentList.add(new Students(studentName, studentGender, studentMobile, studentEmail, inputDOB,
					studentCountry, studentFeedback, studentPassword));
			System.out.println("Student has been registered successfully!");

		} else if (duplicateEmail(studentEmail) == true) {
			System.out.println("This email already exist");

		}

		else {
			System.out.println("Registration has been cancelled");
		}
	}

	private static boolean removeStudent(ArrayList<Students> studentList, String studentDelete) { // Done by Jason
		boolean removeStudent = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentDelete == studentList.get(i).getStudentEmail()) {
				removeStudent = true;
				studentList.remove(i);
			}
		}
		return removeStudent;
	}

	public static void deleteStudent(ArrayList<Students> studentList, Students student1) { // Done by Jason
		System.out.println("DELETE A STUDENT");

		String studentDelete = Helper.readString("Enter student's email to delete student> ");

		String studentDetails = C206_CaseStudy.getStudentByEmail(studentList, studentDelete);

		if (!studentDetails.isEmpty()) {
			System.out.println(studentDetails);
			String toDelete = Helper.readString("Do you wish to delete this student?(y/n) > ");

			if (toDelete == "y" || toDelete == "Y") {
				boolean deleted = C206_CaseStudy.removeStudent(studentList, studentDelete);

				if (deleted == true) {
					System.out.println(
							String.format("The student with the email %s was deleted successfully.", studentDelete));
				} else {
					System.out.println("Student was not deleted due to error");
				}
			}

		} else {
			System.out.println("This student does not exist");
		}

	}

	private static String getStudentByEmail(ArrayList<Students> studentList, String studentDelete) { // Done by Jason

		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			Students r = studentList.get(i);

			if (r.getStudentEmail() == studentDelete) {
				output += String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-40s", "Student name", "Gender", "Email",
						"DOB", "Country", "Feedback");
				output += String.format("%-10d %-20s %-15s %-10s\n", r.getStudentName(), r.getStudentGender(),
						r.getStudentEmail(), r.getStudentDOB(), r.getStudentCountry(), r.getStudentFeedback());
				break;
			}
		}
		return output;
	}

	private static boolean duplicateEmail(String email) { // Done by Jason
		boolean check = false;

		for (Students s : studentList) {
			if (s.getStudentEmail() == email) {
				check = true;
			} else {
				check = false;
			}
		}
		return check;
	}
	
	private static void searchStudent() { //Done by Jason
		
		
	}
	
	//---------------------------------Enquiry Sanjeev---------------------------------//

	public static void searchEnquiry() { // Done by Sanjeev2
		int eID = Helper.readInt("Enter Enquiry ID > ");
		for (int i = 0; i < enquiryList.size(); i++) {
			Enquiries enquiry1 = enquiryList.get(i);
			if (eID == enquiry1.getEnquiry_id()) {
				String output = displayHeader();
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry1.getEnquiry_id(),
						enquiry1.getEnquirerName(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry1.getEnquiry_dateTime()),
						enquiry1.getStatus(), enquiry1.getFllwupType());
				System.out.println(output);
				break;
			} else {
				System.out.println("Invalid Entry ID!");
				break;
			}
		}
	}

	public static Enquiries addEnquiryInputs() { // Done by Sanjeev
		String eName = Helper.readString("Enter Enquirer's name > ");
		String dateTime = Helper.readString("Enter date & time of enquiry (yyyy-MM-dd HH:mm:ss) > ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
		String eStatus = Helper.readString("Enter enquiry status(fullfilled/unfullfilled) > ");
		String fllwUpType = Helper.readString("Enter follow-up type> ");
		int enquiry_id = enquiryList.size() + 1;
		Enquiries e = new Enquiries(enquiry_id, eName, dt, eStatus, fllwUpType);
		return e;
	}

	public static void addEnquiry(ArrayList<Enquiries> enquiryList, Enquiries e) { // Done by Sanjeev
		enquiryList.add(e);
		System.out.println("Enquiry registered successfully"); // Since enquiry can be made multiple times by the same
																// person it need not be unique
	}

	public static void checkAddedEnquiry(Enquiries e) {

		if (e.getEnquirerName().isBlank() || e.getEnquiry_dateTime().isEqual(null) || e.getStatus().isBlank()
				|| e.getFllwupType().isBlank()) {
			enquiryList.remove(e);
			System.out.println("Enquiry had blank fields try again!");
		} else {
			addEnquiry(enquiryList, e);
		}
	}

	public static int deleteEnquiryInputs() { // Done by Sanjeev
		int enquiry_id = Helper.readInt("Enter Enquiry ID > ");

		return enquiry_id;
	}

	public static void deleteEnquiry(ArrayList<Enquiries> enquiryList, int enquiryId) { // Done by Sanjeev

		for (int i = 0; i < enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			if (enquiryId == enquiry.getEnquiry_id()) {
				String output = displayHeader();
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(),
						enquiry.getEnquirerName(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()),
						enquiry.getStatus(), enquiry.getFllwupType());
				System.out.println(output);
				String option = Helper.readString("Do you wish to delete this enquiry? (Y/N)> ");
				if (option.equalsIgnoreCase("y")) {
					enquiryList.remove(enquiry);
					System.out.println("Enquiry has been successfully removed!");
				} else {
					break;
				}
			} else {
				System.out.println("Enquiry with the enquiry id inputted doesn't exist!");
				break;
			}
		}
	}

	public static void enquiryMenu() { // Done by Sanjeev
		Helper.line(25, "=");
		System.out.println("1. Add New Enquiry");
		System.out.println("2. View All Enquiry");
		System.out.println("3. View All Fullfilled Enquiry");
		System.out.println("4. View All Unfullfilled Enquiry");
		System.out.println("5. Search Specific Enquiry");
		System.out.println("6. Delete Specific Enquiry");
		System.out.println("7. Exit");
		Helper.line(25, "=");
	}

	public static void startEnquiry() { // Done by Sanjeev
		int option = -1;

		while (option != 7) {
			enquiryMenu();
			option = Helper.readInt("Enter Choice > ");
			if (option == 1) {
				// Add enquiry
				Enquiries e = addEnquiryInputs();
				checkAddedEnquiry(e);
			} else if (option == 2) {
				// Display all enquiry
				displayAll();
			} else if (option == 3) {
				// Display fullfilled enquiry
				displayFullfilled();
			} else if (option == 4) {
				// Display unfullfilled enquiry
				displayNotFullfilled();
			} else if (option == 5) {
				// Search enquiry
				searchEnquiry();
			} else if (option == 6) {
				// Delete enquiry
				int e = deleteEnquiryInputs();
				deleteEnquiry(enquiryList, e);
			} else if (option == 7) {
				// Quit
				System.out.println("Goodbye!");
			} else {
				// if wrong number is entered
				System.out.println("Invalid option!");
				break;
			}
		}
	}

	public static String displayHeader() { // Done by Sanjeev
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME",
				"ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		return output;
	}

	public static String retrieveAll(ArrayList<Enquiries> enquiryList) { // Done by Sanjeev

		String output = "";

		if (enquiryList.size() != 0) {
			output = displayHeader();
			for (int i = 0; i < enquiryList.size(); i++) {
				Enquiries enquiry = enquiryList.get(i);
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(),
						enquiry.getEnquirerName(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()),
						enquiry.getStatus(), enquiry.getFllwupType());
			}
		} else {
			output += "No enquiries for now :(";
		}
		return output;
	}

	public static void displayAll() { // Done by Sanjeev
		String output = retrieveAll(enquiryList);
		System.out.println(output);

	}

	public static String retrieveFullfilled(ArrayList<Enquiries> enquiryList) { // Done by Sanjeev
		String output = "";
		if (enquiryList.size() != 0) {
			output += displayHeader();
			for (int i = 0; i < enquiryList.size(); i++) {
				Enquiries enquiry = enquiryList.get(i);
				if (enquiry.getStatus().equalsIgnoreCase("fullfilled")) {
					output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(),
							enquiry.getEnquirerName(),
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()),
							enquiry.getStatus(), enquiry.getFllwupType());
				}
			}
		} else {
			output += "No fullfilled enquiries for now :(";
		}

		return output;
	}

	public static void displayFullfilled() { // Done by Sanjeev
		String output = retrieveFullfilled(enquiryList);
		System.out.println(output);

	}

	public static String retrieveNotFuillfilled(ArrayList<Enquiries> enquiryList) { // Done by Sanjeev
		String output = "";
		if (enquiryList.size() != 0) {
			output = displayHeader();
			for (int i = 0; i < enquiryList.size(); i++) {
				Enquiries enquiry = enquiryList.get(i);
				if (enquiry.getStatus().equalsIgnoreCase("unfullfilled")) {
					output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(),
							enquiry.getEnquirerName(),
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()),
							enquiry.getStatus(), enquiry.getFllwupType());
				}
			}
		} else {
			output += "No unfullfilled enquiries :)";
		}

		return output;
	}

	public static void displayNotFullfilled() { // Done by Sanjeev
		String output = retrieveNotFuillfilled(enquiryList);
		System.out.println(output);

	}

	//---------------------------------TimeTable Jerald---------------------------------//
	
	public static void tuitionTimetableStart() { // Done by jerald

		int option = -1;

		while (option != 4) {

			tuitionTimetableMenu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				addTimetable(timetableList, insertTimetableToAdd());
			} else if (option == 2) {
				viewTimetable();
			} else if (option == 3) {
				deleteTimetable(timetableList, insertTimetableToDelete());
			} else if (option == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid option!");
			}
		}

	}

	public static void tuitionTimetableMenu() { // Done by jerald
		Helper.line(80, "=");
		System.out.println("1. Add a new tuition timetable");
		System.out.println("2. View a tuition timetable");
		System.out.println("3. Delete a tuition timetable");
		System.out.println("4. Quit");
		Helper.line(80, "=");
	}

	public static void addTimetable(ArrayList<TuitionTimetable> timetableList, TuitionTimetable tt) { // Done by jerald
		if (!(tt.equals(null))) {
			timetableList.add(tt);
			System.out.println("New tuition timetable added!");
		} else {
			System.out.println("Adding of new tuition timetable cancelled.");
		}
	}

	public static void viewTimetable() { // Done by jerald
		String output = String.format("%-10s %-5s %-10s %-20s %-20s %-10s", "Tuition Code", "ID", "Price", "Start Date",
				"End Date", "Mode");

		for (TuitionTimetable t : timetableList) {
			output = String.format("%-10s %-5d %-10.2f %-20s %-20s %-10s", t.getTuition_code(), t.getTimetableID(),
					t.getPrice(), t.getStartDate(), t.getEndDate(), t.getMode());
		}
		System.out.println(output);
	}

	public static void deleteTimetable(ArrayList<TuitionTimetable> timetableList, TuitionTimetable tt) { // Done by
																											// jerald
		if (!(tt.equals(null))) {
			timetableList.remove(tt);
			System.out.println("Tuition timetable ID " + tt.getTimetableID() + " removed!");
		}
	}

	public static TuitionTimetable insertTimetableToAdd() { // Done by jerald

		TuitionTimetable insertTT = null;

		while (insertTT == null) {
			String inputTuitionCode = Helper.readString("Enter Tuition Code > ");
			int inputID = Helper.readInt("Enter ID > ");
			double inputPrice = Helper.readDouble("Enter Price > ");
			String inputStringStartDate = Helper.readString("Enter Start Date (DD-MM-YYYY)> ");
			String inputStringEndDate = Helper.readString("Enter End Date (DD-MM-YYYY)> ");
			String inputMode = Helper.readString("Enter Mode > ");

			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			LocalDate inputStartDate = LocalDate.parse(inputStringStartDate, formatter1);
			LocalDate inputEndDate = LocalDate.parse(inputStringEndDate, formatter1);

			if (inputTuitionCode != null && inputID > 0 && duplicateIDcheck(inputID) == false && inputPrice > 0.0
					&& inputStringStartDate != null && inputStringEndDate != null && inputMode != null) {
				char proceed = Helper.readChar("Proceed on adding tuition timetable? (Y/N)> ");
				if (proceed == 'Y') {
					insertTT = new TuitionTimetable(inputTuitionCode, inputID, inputPrice, inputStartDate, inputEndDate,
							inputMode);
					System.out.println("New tuition timetable added!");
				} else {
					System.out.println("Adding of new tuition timetable cancelled.");
				}
			} else {
				System.out.println("Required fields are empty. Please fill it in with the appropriate formats.");
			}
		}

		return insertTT;
	}

	public static TuitionTimetable insertTimetableToDelete() { // Done by jerald

		TuitionTimetable insertTT = null;

		viewTimetable();
		Helper.line(80, "=");

		int option = Helper.readInt("\nPlease enter the tuition timetable ID that you want to delete > ");

		for (TuitionTimetable t : timetableList) {
			if (option == t.getTimetableID()) {
				char option2 = ' ';

				while (option2 != 'Y' || option2 != 'N') {
					option2 = Helper.readChar("This record would be lost, are you sure you want to continue? (Y/N)");

					if (option2 == 'Y') {
						insertTT = t;
					} else {
						System.out.println("Please enter ‘N’ to reject or ‘Y’ to accept");
					}
				}
			} else {
				System.out.println("No such tuition timetable ID!");
			}
		}

		return insertTT;

	}

	public static boolean duplicateIDcheck(int id) { // Done by Jerald
		boolean check = false;

		for (TuitionTimetable t : timetableList) {
			if (t.getTimetableID() == id) {
				check = true;
			} else {
				check = false;
			}
		}
		return check;
	}
	
	//---------------------------------Tuition Xing He----------------------------------//
	
	
	//---------------------------------LogIn----------------------------------//
	
		private static void startLoginAcc() { // Done by Marcus
			int logAccOption = -1;
			
			while (logAccOption != 4) { // Done by Marcus
				logAccMenu();
				boolean check = false;
				logAccOption = Helper.readInt("Enter option > ");
				
				if (logAccOption == 1) { // Done by Marcus
					String email = Helper.readString("Enter Email > ");
					String password = Helper.readString("Enter Password > ");
					check = checkStuAcc(email, password);
					if (check == true) { // Done by Marcus
						Students stuObject = saveStuAcc(email);
						startStuMenu(stuObject);
					}
					else { // Done by Marcus
						System.out.println("Invalid Email or Password.");
					}
				}
				
				else if (logAccOption == 2) { // Done by Marcus
					check = checkManagerAcc();
					if (check == true) { // Done by Marcus
						startManagerMenu();
					}
					else { // Done by Marcus
						System.out.println("Invalid Email or Password.");
					}
				}
				
				else if (logAccOption == 3) { // Done by Marcus
					check = checkAdminAcc();
					if (check == true) { // Done by Marcus
						startAdminMenu();
					}
					else { // Done by Marcus
						System.out.println("Invalid Email or Password.");
					}
				}
			}
			
		}
		
		private static Students saveStuAcc(String email) {
			Students stuObject = null;
			
			for (Students x:studentList) { // Done by Marcus
				if (email.equals(x.getStudentEmail())) {
					stuObject = x;
				}
			}
			
		
		return stuObject;
	}

		
		private static boolean checkStuAcc(String email, String password) { // Done by Marcus

			boolean check = false;
			
			for (Students x:studentList) { // Done by Marcus
				if (email.equals(x.getStudentEmail()) && password.equals(x.getStudentPassword())) {
					check = true;
				}
			}
			
			return check;
			
		}
		private static boolean checkManagerAcc() { // Done by Marcus
			String username = Helper.readString("Enter Username > ");
			String password = Helper.readString("Enter Password > ");
			boolean check = false;
			
			for (TuitionManager x:managerAccList) { // Done by Marcus
				if (username.equals(x.getmanagerUsername()) && password.equals(x.getmanagerPassword())) {
					check = true;
				}
			}
			
			return check;
			
		}
		private static boolean checkAdminAcc() { // Done by Marcus
			String username = Helper.readString("Enter Username > ");
			String password = Helper.readString("Enter Password > ");
			boolean check = false;
			
			for (TuitionAdministrator x:adminAccList) { // Done by Marcus
				if (username.equals(x.getUsername()) && password.equals(x.getPassword())) { // Done by Marcus
					check = true;
				}
			}
			
			return check;
			
		}
		
		private static void startRegAcc() { // Done by Marcus
			int regOption = -1;
			
			while (regOption != 4) { // Done by Marcus
				regAccMenu();
				regOption = Helper.readInt("Enter option > ");
				if (regOption == 1) { // Done by Marcus
					addNewStudent(studentList,null);
				}
				else if (regOption == 2) { // Done by Marcus
					regManager();
				}
				else if (regOption == 3) { // Done by Marcus
					regAdmin();
				}
			}
		}
		
		private static void startStuMenu(Students stuObject) { // Done by Marcus
			int stuOption = -1;
			
			while (stuOption != 5) { // Done by Marcus
				
				studentMenu();
				stuOption = Helper.readInt("Enter option > ");
				if (stuOption == 1) {
					startRegistration(stuObject);
				}
				else if (stuOption == 2) { // Done by Marcus
					//update feedback waiting for jason
				}
				else if (stuOption == 3) { // Done by Marcus
					// view tuition waiting for xing he
				}
				else if (stuOption == 4) { // Done by Marcus
					viewTimetable();
				}
				else if (stuOption == 5) { // Done by Marcus
					System.out.println("Bye");
				}
				
			}
		}
		
		private static void startManagerMenu() { // Done by Marcus
			int stuOption = -1;
			
			while (stuOption != 4) { // Done by Marcus
				
				managerMenu();
				stuOption = Helper.readInt("Enter option > ");
				if (stuOption == 1) { // Done by Marcus
					startEnquiry();
				}
				else if (stuOption == 2) { // Done by Marcus
					//view tuition waiting for xing he
				}
				else if (stuOption == 3) { // Done by Marcus
					viewTimetable();
				}
				else if (stuOption == 4) { // Done by Marcus
					System.out.println("Bye");
				}
				
			}
		}
		
		private static void startAdminMenu() { // Done by Marcus
			int stuOption = -1;
			
			while (stuOption != 4) { // Done by Marcus
				
				adminMenu();
				stuOption = Helper.readInt("Enter option > ");
				if (stuOption == 1) {
					studentRegistrationStart();
				}
				else if (stuOption == 2) { // Done by Marcus
					//starttuition
				}
				else if (stuOption == 3) { // Done by Marcus
					tuitionTimetableStart();
				}
				else if (stuOption == 4) { // Done by Marcus
					System.out.println("Bye");
				}
				
			}
		}
		
		private static void loginMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("START MENU");
			Helper.line(70, "-");
			System.out.println("1. Login");
			System.out.println("2. Register an Account");
			System.out.println("3. Quit");
		}
		
		private static void regAccMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("REGISTER ACCOUNT MENU");
			Helper.line(70, "-");
			System.out.println("1. Student");
			System.out.println("2. Tuition Manager");
			System.out.println("3. Tuition Administrator");
			System.out.println("4. Quit");
		}
		
		private static void logAccMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("LOGIN ACCOUNT MENU");
			Helper.line(70, "-");
			System.out.println("1. Student");
			System.out.println("2. Tuition Manager");
			System.out.println("3. Tuition Administrator");
			System.out.println("4. Quit");
		}

		private static void studentMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("STUDENT MENU");
			Helper.line(70, "-");
			System.out.println("1. Registration");
			System.out.println("2. Update Feedback");
			System.out.println("3. View Tuition");
			System.out.println("4. View Tuition TimeTable");
			System.out.println("5. Log Out");
		}
		
		private static void adminMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("ADMIN MENU");
			Helper.line(70, "-");
			System.out.println("1. Student");
			System.out.println("2. Tuition");
			System.out.println("3. Tuition TimeTable");
			System.out.println("4. Log Out");
		}
		
		private static void managerMenu() { // Done by Marcus
			Helper.line(70, "-");
			System.out.println("TUITION MANAGER MENU");
			Helper.line(70, "-");
			System.out.println("1. Enquiry");
			System.out.println("2. View Tuition");
			System.out.println("3. View Tuition TimeTable");
			System.out.println("4. Log Out");
		}
		
		private static void regManager() { // Done by Marcus
			Helper.line(70, "-");//Done by marcus
			System.out.println("REGISTER MANAGER ACCOUNT");//Done by marcus
			Helper.line(70, "-");//Done by marcus
			String username = Helper.readString("Enter new Username > ");//Done by marcus
			String password = Helper.readString("Enter new Password > ");//Done by marcus
			managerAccList.add(new TuitionManager(username,password));//Done by marcus
			System.out.println(username + " has been registered successfully!");//Done by Sanjeev
		}
		
		private static void regAdmin() { // Done by Marcus
			Helper.line(70, "-");//Done by marcus
			System.out.println("REGISTER ADMINISTRATOR ACCOUNT");//Done by marcus
			Helper.line(70, "-");//Done by marcus
			String username = Helper.readString("Enter new Username > ");//Done by marcus
			String password = Helper.readString("Enter new Password > ");//Done by marcus
			adminAccList.add(new TuitionAdministrator(username,password));//Done by marcus
			System.out.println(username + " has been registered successfully!");//Done by Sanjeev
		}
		
	
}// last bracket please never remove this 
