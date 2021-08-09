import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static ArrayList<Registration> regiList = new ArrayList<Registration>(); // Done by Marcus
	public static ArrayList<Students> studentList = new ArrayList<Students>(); // done by Jason
	public static ArrayList<Enquiries> enquiryList = new ArrayList<Enquiries>(); // Done by Sanjeev
	public static ArrayList<TuitionTimetable> timetableList = new ArrayList<TuitionTimetable>(); // Done by Jerald
	
	public static ArrayList<TuitionAdministrator> adminAccList = new ArrayList<TuitionAdministrator>();
	public static ArrayList<TuitionManager> managerAccList = new ArrayList<TuitionManager>();
	
	public static int accVersion = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int logOption = -1;
		
		while (logOption != 3) {
			loginMenu();
			logOption = Helper.readInt("Enter choice > ");

			if (logOption == 1) {
				startLoginAcc();
			} else if (logOption == 2) {
				startRegistration();
			} else if (logOption == 3) {
				System.out.println("Good bye!");
			}
			
			
		}
	}
	

	//---------------------------------LogIn----------------------------------//
	
	private static void startLoginAcc() {
		int logAccOption = -1;
		
		while (logAccOption != 4) {
			logAccMenu();
			logAccOption = Helper.readInt("Enter option > ");
			if (logAccOption == 1) {
				addNewStudent(studentList,null);
			}
			else if (logAccOption == 2) {
				regManager();
			}
			else if (logAccOption == 3) {
				regAdmin();
			}
		}
		
	}
	
	private static void startRegistration() {
		int regOption = -1;
		
		while (regOption != 4) {
			regAccMenu();
			regOption = Helper.readInt("Enter option > ");
			if (regOption == 1) {
				addNewStudent(studentList,null);
			}
			else if (regOption == 2) {
				regManager();
			}
			else if (regOption == 3) {
				regAdmin();
			}
		}
	}
	
	private static void loginMenu() {
		Helper.line(70, "-");
		System.out.println("START MENU");
		Helper.line(70, "-");
		System.out.println("1. Login");
		System.out.println("2. Register an Account");
		System.out.println("3. Quit");
	}
	
	private static void regAccMenu() {
		Helper.line(70, "-");
		System.out.println("REGISTER ACCOUNT MENU");
		Helper.line(70, "-");
		System.out.println("1. Student");
		System.out.println("2. Tuition Manager");
		System.out.println("3. Tuition Administrator");
		System.out.println("4. Quit");
	}
	
	private static void logAccMenu() {
		Helper.line(70, "-");
		System.out.println("LOGIN ACCOUNT MENU");
		Helper.line(70, "-");
		System.out.println("1. Student");
		System.out.println("2. Tuition Manager");
		System.out.println("3. Tuition Administrator");
		System.out.println("4. Quit");
	}

	private static void studentMenu() {
		Helper.line(70, "-");
		System.out.println("STUDENT MENU");
		Helper.line(70, "-");
		System.out.println("1. Registration");
		System.out.println("2. Update Feedback");
		System.out.println("3. View Tuition");
		System.out.println("4. View Tuition TimeTable");
		System.out.println("5. Quit");
	}
	
	private static void adminMenu() {
		Helper.line(70, "-");
		System.out.println("ADMIN MENU");
		Helper.line(70, "-");
		System.out.println("1. Student");
		System.out.println("2. Tuition");
		System.out.println("3. Tuition TimeTable");
		System.out.println("4. Quit");
	}
	
	private static void managerMenu() {
		Helper.line(70, "-");
		System.out.println("TUITION MANAGER MENU");
		Helper.line(70, "-");
		System.out.println("1. Enquiry");
		System.out.println("2. View Tuition");
		System.out.println("3. View Tuition TimeTable");
		System.out.println("4. Quit");
	}
	
	private static void regManager() {
		Helper.line(70, "-");
		System.out.println("REGISTER MANAGER ACCOUNT");
		Helper.line(70, "-");
		String username = Helper.readString("Enter new Username > ");
		String password = Helper.readString("Enter new Password > ");
		managerAccList.add(new TuitionManager(username,password));
	}
	
	private static void regAdmin() {
		Helper.line(70, "-");
		System.out.println("REGISTER ADMINISTRATOR ACCOUNT");
		Helper.line(70, "-");
		String username = Helper.readString("Enter new Username > ");
		String password = Helper.readString("Enter new Password > ");
		adminAccList.add(new TuitionAdministrator(username,password));
	}
	
	//---------------------------------Register---------------------------------//
	
	private void RegisterMenu() { // Done by Marcus
		System.out.println("1. Register for Tuition Timetable"); // Done by Marcus
		System.out.println("2. View All Registration"); // Done by Marcus
		System.out.println("3. Delete Registration"); // Done by Marcus
	}

	protected static void addRegistration(Registration registration1) { // Done by Marcus
		// registration number = Registration id must be unique.
		// tuition timetable id
		// student�s email
		// status which is initially set to �Pending�
		// registration date/time
		boolean repeat = true;

		while (repeat = true) {
			int regiID = Helper.readInt("Registration ID > "); // Done by Marcus
			repeat = checkForDupeRegiNum(regiID);

			if (repeat == false) { // Done by Marcus
				int timeTabelID = Helper.readInt("Time Table ID > "); // Done by Marcus
				String stuEmail = Helper.readString("Student's Email"); // Done by Marcus

				regiList.add(new Registration(regiID, timeTabelID, stuEmail)); // Done by Marcus
				System.out.println("Successfully added registration");
			} else { // Done by Marcus
				System.out.println("Please use a unique Registration ID"); // Done by Marcus
			}
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

	protected void viewAllRegistration() { // Done by Marcus
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
		System.out.println(output);
	}

	protected void deleteRegistration() { // Done by Marcus

		int regiID = Helper.readInt("Please enter the registration ID of the registration to be deleted > "); // Done by															// Marcus
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
	
	//---------------------------------Student---------------------------------//

	public void studentRegistrationStart() {// done by Jason

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



	private void studentRegistrationMenu() { // Done by Jason
		System.out.println("1) View all students\n2) Register new student\n3) Delete a student");

	}

	private void viewAllStudents() { // Done by Jason

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
		String studentPassword = Helper.readString("Password");

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
	
	private void searchStudent() { //Done by Jason
		
		
	}
	
	//---------------------------------Enquiry---------------------------------//

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

	//---------------------------------TimeTable---------------------------------//
	
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
						System.out.println("Please enter �N� to reject or �Y� to accept");
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
}
