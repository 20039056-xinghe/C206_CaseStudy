import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private ArrayList<Registration> regiList = new ArrayList<Registration>(); //Done by Marcus
	private ArrayList<Students> studentList = new ArrayList<Students>(); // done by Jason
	public static ArrayList<Enquiries> enquiryList = new ArrayList<Enquiries>(); //Done by Sanjeev
	private ArrayList<TuitionTimetable> timetableList = new ArrayList<TuitionTimetable>(); // Done by Jerald
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void RegisterMenu() { //Done by Marcus
		System.out.println("1. Register for Tuition Timetable"); //Done by Marcus
		System.out.println("2. View All Registration"); //Done by Marcus
		System.out.println("3. Delete Registration"); //Done by Marcus
	}
	
	private void addRegistration() { //Done by Marcus
		//registration number = Registration id must be unique.
			//	tuition timetable id
			//	student’s email
			//	status which is initially set to “Pending”
			//	registration date/time
		int regiID = Helper.readInt("Registration ID > "); //Done by Marcus
		int timeTabelID = Helper.readInt("Time Table ID > "); //Done by Marcus
		String stuEmail = Helper.readString("Student's Email"); //Done by Marcus
		
		
		boolean repeat = checkForDupeRegiNum(regiID);
		
		if(repeat == false) {  //Done by Marcus
			regiList.add(new Registration(regiID, timeTabelID, stuEmail)); //Done by Marcus
		}else { //Done by Marcus
			System.out.println("Please use a unique Registration ID"); //Done by Marcus
		}

	}

	private boolean checkForDupeRegiNum(int regiID) { //Done by Marcus
		boolean repeat = false;
		for (Registration x : regiList) { //Done by Marcus
			if (x.getRegID() == regiID) {
				repeat = true;
			}
		}
		return repeat;
	}
	
	private void viewAllRegistration() { //Done by Marcus
		String output = String.format("%-5s %-10s %-30s %-10s %-20s", "RegID", "TimeTableID", "Student Email", "Status", "RegDateTime");
		for (Registration x : regiList) {
			output += x.display();
		}
		System.out.println(output);
	}
	
	public void deleteRegistration() { //Done by Marcus
		
		int regiID = Helper.readInt("Please enter the registration ID of the registration to be deleted > "); //Done by Marcus
		boolean check = false;
		for (Registration x : regiList) {
			if (x.getRegID()==regiID) {
				check = true;
				regiList.remove(x);
				System.out.println("Registration succesfully deleted");
			}
		}
		if (check == false) { //Done by Marcus
			System.out.println("No registration delete, invalid registration ID.");
		}
	}
	
	

	

	


	
	
	public void studentRegistrationStart() {// done by Jason
		
		int option = -1;

		while (option != 7) {
			studentRegistrationMenu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				viewAllStudents();
			} else if (option == 2) {
				addNewStudent();
			} else if (option == 3) {
				deleteStudent();
			} else if (option == 4) {
				System.out.println("GoodBye");
			}
		}
	}

	private void studentRegistrationMenu() { //Done by Jason
		System.out.println("1) View all students\n2) Register new student\n3) Delete a student");
		
	}

	private void viewAllStudents() { // Done by Jason

		String view = String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-40s","Student name", "Gender", "Email", "DOB", "Country", "Feedback");
		for(int i = 0; i < studentList.size(); i++) {
			Students r = studentList.get(i);
			view += String.format("%-10d %-20s %-15s %-10s\n"
					, r.getStudentName()
					, r.getStudentGender()
					, r.getStudentEmail()
					, r.getStudentDOB()
					, r.getStudentCountry()
					, r.getStudentFeedback());
		}
		System.out.println(view);			
	}
		
	private void addNewStudent() { //Done by Jason
		System.out.println("Resgister a new Student");
		String newName = Helper.readString("Name> ");
		String newGender = Helper.readString("Gender> ");
		int newMobile = Helper.readInt("Mobile number> ");
		String newEmail = Helper.readString("Email> ");
		Date newDOB = Helper.readDate("Date of birth> ");
		String newCountry = Helper.readString("Country of residence> ");
		String newFeedback = Helper.readString("Feedback> ");
		
		for(Students r : studentList) {
			
			if(studentList.contains(r)) {
				System.out.println(r.getStudentName() + "already have this email: " + r.getStudentEmail());
			}
			else{
				studentList.add(new Students(newName, newGender, newMobile, newEmail, newDOB, newCountry, newFeedback));
				System.out.println("Student has been registered successfully!");
			}	
			
		}
	}

	private static boolean removeStudent(ArrayList<Students> studentList, String studentDelete) { //Done by Jason
		boolean removeStudent = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentDelete == studentList.get(i).getStudentEmail()) {    
				removeStudent = true;						
				studentList.remove(i);
			}
		}
		return removeStudent;
	}
	
	private void deleteStudent() { //Done by Jason
		System.out.println("DELETE A GUEST");

		String studentDelete = Helper.readString("Enter student's email to delete student> ");
		
		String studentDetails = C206_CaseStudy.getStudentByEmail(studentList, studentDelete);

		if (!studentDetails.isEmpty()) {
			System.out.println(studentDetails);
			String toDelete = Helper.readString("Do you wish to delete this student?(y/n) > ");

			if (toDelete == "y" || toDelete == "Y") {
				boolean deleted = C206_CaseStudy.removeStudent(studentList, studentDelete);

				if (deleted == true) {
					System.out.println(String.format("The student with the email %s was deleted successfully.",
							studentDelete));
				} else {
					System.out.println("Student was not deleted due to error");
				}
			}

		} else {
			System.out.println("This student does not exist");
		}

		
	}

	private static String getStudentByEmail(ArrayList<Students> studentList, String studentDelete) { //Done by Jason

		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			Students r = studentList.get(i);

			if (r.getStudentEmail() == studentDelete) {
				output += String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-40s","Student name", "Gender", "Email", "DOB", "Country", "Feedback");
				output += String.format("%-10d %-20s %-15s %-10s\n"
						, r.getStudentName()
						, r.getStudentGender()
						, r.getStudentEmail()
						, r.getStudentDOB()
						, r.getStudentCountry()
						, r.getStudentFeedback());
				break;
			}
		}
		return output;
	}
	

	 
	 private static void searchEnquiry() { //Done by Sanjeev
		 int eID = Helper.readInt("Enter Enquiry ID > ");
		 for(int i = 0; i < enquiryList.size(); i++) {
			Enquiries enquiry1 = enquiryList.get(i);
			if(eID == enquiry1.getEnquiry_id()) {
				String output = displayHeader();
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry1.getEnquiry_id(), enquiry1.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry1.getEnquiry_dateTime()), enquiry1.getStatus(), enquiry1.getFllwupType());
				System.out.println(output);
				break;
			 }else {
				 System.out.println("Invalid Entry ID!");
			 }
		 }
	 }
	 
	 private static void addEnquiry() { //Done by Sanjeev
		 
		 String eName = Helper.readString("Enter Enquirer's name > ");
		 String dateTime = Helper.readString("Enter date & time of enquiry (yyyy-MM-dd HH:mm:ss) > ");
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		 LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
		 String eStatus = Helper.readString("Enter enquiry status(fullfilled/unfullfilled) > ");
		 String fllwUpType = Helper.readString("Enter follow-up type> ");
		 int enquiry_id = enquiryList.size() + 1;
		 
			for(int i = 0; i < enquiryList.size(); i++) {
				Enquiries enquiries = enquiryList.get(i);
				if(!enquiries.getEnquirerName().equalsIgnoreCase(eName)) {
					enquiryList.add(new Enquiries(enquiry_id, eName, dt, eStatus, fllwUpType));
					System.out.println("Enquiry has been registered successfully!");
					break;
				}else {
					System.out.println("Enquiry with the same name already exists!");
				}
				
			}
		 
	 }
	 
	 private static void deleteEnquiry() { //Done by Sanjeev
		 int enquiry_id = Helper.readInt("Enter Enquiry ID > ");
		 
		 for(int i = 0; i < enquiryList.size(); i++) {
			 Enquiries enquiry = enquiryList.get(i);
			if(enquiry_id == enquiry.getEnquiry_id()) {
					String output = displayHeader();
					output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
					System.out.println(output);
					String option = Helper.readString("Do you wish to delete this enquiry? (Y/N)> ");
					if(option.equalsIgnoreCase("y")) {
						enquiryList.remove(i);
						System.out.println("Enquiry has been successfully removed!");
					}else {
						break;
					}
			}else {
				System.out.println("Enquiry with the ennquiry id inputted doesn't exist!");
				break;
			}
		 }
	 }
	
	private static void enquiryMenu() { //Done by Sanjeev
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
	
	public static void startEnquiry() { //Done by Sanjeev
		int option = -1;
		
		while(option != 0) {
			enquiryMenu();
			option = Helper.readInt("Enter Choice > ");
			if(option == 1) {
				addEnquiry();
			}else if(option ==2) {
				displayAll();
			}else if(option ==3) {
				displayFullfilled();
			}else if(option ==4) {
				displayNotFuillfilled();
			}else if(option ==5) {
				searchEnquiry();
			}else if(option ==6) {
				deleteEnquiry();
			}else if(option ==7) {
				break;
			}else {
				System.out.println("Invalid option!");
			}
		}
		System.out.println("Goodbye!");
	}
	
	
	
	public static void displayAll() { //Done by Sanjeev
		String output = displayHeader();
		
		for(int i = 0; i< enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
		}
		System.out.println(output);
	}

	public static String displayHeader() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		return output;
	}
	
	public static void displayFullfilled() { //Done by Sanjeev
		String output = displayHeader();
		for(int i = 0; i< enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			if(enquiry.getStatus().equalsIgnoreCase("fullfilled")) {
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
			}
		}
		System.out.println(output);
	}
	
	public static void displayNotFuillfilled() { //Done by Sanjeev
		String output = displayHeader();
		for(int i = 0; i< enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			if(enquiry.getStatus().equalsIgnoreCase("not fullfilled")) {
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
			}
		}
		System.out.println(output);
	}
	
	private void tuitionTimetableStart() { //Done by jerald
		
		int option = -1;
		
		while(option != 4) {
			
			tuitionTimetableMenu();
			option = Helper.readInt("Enter choice > ");
			
			if(option == 1) {
				addTimetable();
			}
			else if(option == 2) {
				viewTimetable();
			}
			else if(option == 3) {
				deleteTimetable();
			}
			else if(option == 4) {
				System.out.println("Goodbye!");
			}
			else {
				System.out.println("Invalid option!");
			}
		}
		
	}

	private void tuitionTimetableMenu() { //Done by jerald
		Helper.line(80, "=");
		System.out.println("1. Add a new tuition timetable");
		System.out.println("2. View a tuition timetable");
		System.out.println("3. Delete a tuition timetable");
		System.out.println("4. Quit");
		Helper.line(80, "=");
	}
	
	private void addTimetable() { //Done by jerald
		int inputID = Helper.readInt("Enter ID > ");
		double inputPrice = Helper.readDouble("Enter Price > ");
		Date inputStartDate = Helper.readDate("Enter Start Date (DD/MM/YYYY)> ");
		Date inputEndDate = Helper.readDate("Enter End Date (DD/MM/YYYY)> ");
		String inputMode = Helper.readString("Enter Mode > ");
		
		if(inputID > 0 && duplicateID(inputID) == false && inputPrice > 0.0 && inputStartDate != null && inputEndDate != null && inputMode != null) {
			char proceed = Helper.readChar("Proceed on adding tuition timetable? (Y/N)> ");
			if(proceed == 'Y') {
				timetableList.add(new TuitionTimetable(inputID, inputPrice, inputStartDate, inputEndDate, inputMode));
				System.out.println("New tuition timetable added!");
			}
			else {
				System.out.println("Adding of new tuition timetable cancelled.");
			}
		}
		else {
			System.out.println("Required fields are empty. Please fill it in with the appropriate formats.");
		}
	}
	
	private void viewTimetable() { //Done by jerald
		String output = String.format("%-5s %-10s %-20s %-20s %-10s", "ID", "Price", "Start Date", "End Date", "Mode");
		
		for(TuitionTimetable t : timetableList) {
			output = String.format("%-5d %-10.2f %-20t %-20t %-10s", 
					t.getTimetableID(), t.getPrice(), t.getStartDate(), t.getEndDate(), t.getMode());
		}
		System.out.println(output);
	}
	
	private void deleteTimetable() { //Done by jerald
		String output = String.format("%-5s %-10s %-20s %-20s %-10s", "ID", "Price", "Start Date", "End Date", "Mode");
		
		for(TuitionTimetable t : timetableList) {
			output = String.format("%-5d %-10.2f %-20t %-20t %-10s", 
					t.getTimetableID(), t.getPrice(), t.getStartDate(), t.getEndDate(), t.getMode());
		}
		System.out.println(output);
		Helper.line(80, "=");
		
		int option = Helper.readInt("\nPlease enter the tuition timetable ID that you want to delete > ");
		
		for(TuitionTimetable t : timetableList) {
			if(option == t.getTimetableID()) {
				char option2 = ' ';
				
				while(option2 != 'Y' || option2 != 'N') {
					option2 = Helper.readChar("This record would be lost, are you sure you want to continue? (Y/N)");
					
					if(option2 == 'Y') {
						timetableList.remove(t);
						System.out.println("ID " + option + " has been deleted!");
					}
					else {
						System.out.println("Please enter ‘N’ to reject or ‘Y’ to accept");
					}
				}
			}
			else {
				System.out.println("No such tuition timetable ID!");
			}
		}
	}
	
	private boolean duplicateID(int id) { // Done by Jerald
		boolean check = false;
		
		for(TuitionTimetable t : timetableList) {
			if(t.getTimetableID() == id) {
				check = true;
			}
			else {
				check = false;
			}
		}
		return check;
	}
}
