import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private ArrayList<Registration> regiList = new ArrayList<Registration>();
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
		int regiID = readInt("Registration ID > "); //Done by Marcus
		int timeTabelID = readInt("Time Table ID > "); //Done by Marcus
		String stuEmail = readString("Student's Email"); //Done by Marcus
		
		
		boolean repeat = checkForDupeRegiNum(regiID);
		
		if(repeat == false) {  //Done by Marcus
			regiList.add(new Registration(regiID, timeTabelID, stuEmail)); //Done by Marcus
		}else { //Done by Marcus
			System.out.println("Please use a unique Registration ID"); //Done by Marcus
		}

	}

	private boolean checkForDupeRegiNum(int regiID) { //Done by Marcus
		boolean repeat = false;
		for (Registration x : regiList) {
			if (x.getRegID() == regiID) {
				repeat = true;
			}
		}
		return repeat;
	}
	
	private void viewAllRegistration() {
		String output = String.format("%-5s %-10s %-30s %-10s %-20s", "RegID", "TimeTableID", "Student Email", "Status", "RegDateTime");
		for (Registration x : regiList) {
			output += x.display();
		}
		System.out.println(output);
	}
	
	public void deleteRegistration() {
		
		int regiID = readInt("Please enter the registration ID of the registration to be deleted > "); //Done by Marcus
		boolean check = false;
		for (Registration x : regiList) {
			if (x.getRegID()==regiID) {
				check = true;
				regiList.remove(x);
				System.out.println("Registration succesfully deleted");
			}
		}
		if (check == false) {
			System.out.println("No registration delete, invalid registration ID.");
		}
	}
	
	
	public static String readString(String prompt) { // Copied from Helper and Pasted by Marcus
		System.out.print(prompt);
		return new java.util.Scanner(System.in).nextLine();
	}
	
	public static int readInt(String prompt) { //Copied from Helper and Pasted by Marcus
		int input = 0; 
		boolean valid = false;
		while (!valid) {
			try {
				input = Integer.parseInt(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter an integer ***");
			}
		}
		return input;
	}
	
	public static double readDouble(String prompt) { // Copied from Helper and Pasted by Jerald
	    double input = 0;
	    boolean valid = false;
	    while (!valid) {
	      try {
	        input = Double.parseDouble(readString(prompt));
	        valid = true;
	      } catch (NumberFormatException e) {
	        System.out.println("*** Please enter a double ***");
	      }
	    }
	    return input;
	}
	
	public static char readChar(String prompt) { // Copied from Helper and Pasted by Jerald
	    char input = 0;
	    boolean valid = false;
	    while (!valid) {
	      String temp = readString(prompt);
	      if (temp.length() != 1) {
	        System.out.println("*** Please enter a character ***");
	      } else {
	        input = temp.charAt(0);
	        valid = true;
	      }
	    }
	    return input;
	}
	
	public static boolean readBoolean(String prompt) { // Copied from Helper and Pasted by Jerald
	    boolean valid = false;
	    while (!valid) {
	      String input = readString(prompt);
	      if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")
	          || input.equalsIgnoreCase("true") || input.equalsIgnoreCase("t")) {
	        return true;
	      } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")
	          || input.equalsIgnoreCase("false") || input.equalsIgnoreCase("f")) {
	        return false;
	      } else {
	        System.out.println("*** Please enter Yes/No or True/False ***");
	      }
	    }
	    return false;
	}
	
	public static Date readDate(String prompt) { // Copied from Helper and Pasted by Jerald
	    java.util.Date date = null;
	    boolean valid = false;
	    while (!valid) {
	      try {
	        String input = readString(prompt).trim();
	        if (input.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
	          int day = Integer.parseInt(input.substring(0, 2));
	          int month = Integer.parseInt(input.substring(3, 5));
	          int year = Integer.parseInt(input.substring(6, 10));
	          java.util.Calendar cal = java.util.Calendar.getInstance();
	          cal.setLenient(false);
	          cal.set(year, month - 1, day, 0, 0, 0);
	          date = cal.getTime();
	          valid = true;
	        } else {
	          System.out.println("*** Please enter a date (DD/MM/YYYY) ***");
	        }
	      } catch (IllegalArgumentException e) {
	        System.out.println("*** Please enter a date (DD/MM/YYYY) ***");
	      }
	    }
	    return date;
	}
	
	public void studentRegistrationStart() {// done by Jason
		
		int option = -1;

		while (option != 7) {
			studentRegistrationMenu();
			option = readInt("Enter choice > ");

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
		String newName = readString("Name> ");
		String newGender = readString("Gender> ");
		String newMobile = readString("Mobile number> ");
		String newEmail = readString("Email> ");
		String newDOB = readString("Date of birth> ");
		String newCountry = readString("Country of residence> ");
		String newFeedback = readString("Feedback> ");
		
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

		String studentDelete = readString("Enter student's email to delete student> ");
		
		String studentDetails = C206_CaseStudy.getStudentByEmail(studentList, studentDelete);

		if (!studentDetails.isEmpty()) {
			System.out.println(studentDetails);
			String toDelete = readString("Do you wish to delete this student?(y/n) > ");

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
	
	 public static void line(int len, String c) { //Copy pasted from Helper by Sanjeev
		 System.out.println(String.format("%" + len + "s", " ").replaceAll(" ", c));
	}
	 
	 private static void searchEnquiry() { //Done by Sanjeev
		 int eID = readInt("Enter Enquiry ID > ");
		 for(int i = 0; i < enquiryList.size(); i++) {
			Enquiries enquiry1 = enquiryList.get(i);
			if(eID == enquiry1.getEnquiry_id()) {
				String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry1.getEnquiry_id(), enquiry1.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry1.getEnquiry_dateTime()), enquiry1.getStatus(), enquiry1.getFllwupType());
				System.out.println(output);
				break;
			 }else {
				 System.out.println("Invalid Entry ID!");
			 }
		 }
	 }
	 
	 private static void addEnquiry() { //Done by Sanjeev
		 
		 String eName = readString("Enter Enquirer's name > ");
		 String dateTime = readString("Enter date & time of enquiry (yyyy-MM-dd HH:mm:ss) > ");
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		 LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
		 String eStatus = readString("Enter enquiry status(fullfilled/unfullfilled) > ");
		 String fllwUpType = readString("Enter follow-up type> ");
		 int enquiry_id = enquiryList.size() + 1;
		 
			for(int i = 0; i < enquiryList.size(); i++) {
				if(!enquiryList.get(i).getEnquirerName().equalsIgnoreCase(eName)) {
					enquiryList.add(new Enquiries(enquiry_id, eName, dt, eStatus, fllwUpType));
					System.out.println("Enquiry has been registered successfully!");
					break;
				}else {
					System.out.println("Enquiry with the same name already exists!");
				}
				
			}
		 
	 }
	 
	 private static void deleteEnquiry() { //Done by Sanjeev
		 int enquiry_id = readInt("Enter Enquiry ID > ");
		 
		 for(int i = 0; i < enquiryList.size(); i++) {
			 Enquiries enquiry = enquiryList.get(i);
			if(enquiry_id == enquiry.getEnquiry_id()) {
					String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
					output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
					System.out.println(output);
					String option = readString("Do you wish to delete this enquiry? (Y/N)> ");
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
		line(20, "=");
		System.out.println("1. Add New Enquiry");
		System.out.println("2. View All Enquiry");
		System.out.println("3. View All Fullfilled Enquiry");
		System.out.println("4. View All Unfullfilled Enquiry");
		System.out.println("5. Search Specific Enquiry");
		System.out.println("6. Delete Specific Enquiry");
		System.out.println("7. Exit");
		line(20, "=");
	}
	
	public static void startEnquiry() { //Done by Sanjeev
		int option = -1;
		
		while(option != 0) {
			enquiryMenu();
			option = readInt("Enter Choice > ");
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
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		
		for(int i = 0; i< enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
		}
		System.out.println(output);
	}
	
	public static void displayFullfilled() { //Done by Sanjeev
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		for(int i = 0; i< enquiryList.size(); i++) {
			Enquiries enquiry = enquiryList.get(i);
			if(enquiry.getStatus().equalsIgnoreCase("fullfilled")) {
				output += String.format("\n%-10d %8s %25s %12s %13s", enquiry.getEnquiry_id(), enquiry.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_dateTime()), enquiry.getStatus(), enquiry.getFllwupType());
			}
		}
		System.out.println(output);
	}
	
	public static void displayNotFuillfilled() { //Done by Sanjeev
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
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
			option = readInt("Enter choice > ");
			
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
		line(80, "=");
		System.out.println("1. Add a new tuition timetable");
		System.out.println("2. View a tuition timetable");
		System.out.println("3. Delete a tuition timetable");
		System.out.println("4. Quit");
		line(80, "=");
	}
	
	private void addTimetable() { //Done by jerald
		int inputID = readInt("Enter ID > ");
		double inputPrice = readDouble("Enter Price > ");
		Date inputStartDate = readDate("Enter Start Date (DD/MM/YYYY)> ");
		Date inputEndDate = readDate("Enter End Date (DD/MM/YYYY)> ");
		String inputMode = readString("Enter Mode > ");
		
		if(inputID > 0 && duplicateID(inputID) == false && inputPrice > 0.0 && inputStartDate != null && inputEndDate != null && inputMode != null) {
			char proceed = readChar("Proceed on adding tuition timetable? (Y/N)> ");
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
		int option = readInt("Please enter the tuition timetable ID that you want to view > ");
		String output = String.format("%-5s %-10s %-20s %-20s %-10s", "ID", "Price", "Start Date", "End Date", "Mode");
		
		for(TuitionTimetable t : timetableList) {
			if(option == t.getTimetableID()) {
				output = String.format("%-5d %-10.2f %-20t %-20t %-10s", 
						t.getTimetableID(), t.getPrice(), t.getStartDate(), t.getEndDate(), t.getMode());
			}
			else {
				System.out.println("There is no tuition timetable with ID " + option + ". Please try again.");
			}
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
		line(80, "=");
		
		int option = readInt("\nPlease enter the tuition timetable ID that you want to delete > ");
		
		for(TuitionTimetable t : timetableList) {
			if(option == t.getTimetableID()) {
				char option2 = readChar("This record would be lost, are you sure you want to continue? (Y/N)");
				
				while(option2 == 'Y' || option2 == 'N') {
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
