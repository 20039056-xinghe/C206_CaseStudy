import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	private ArrayList<Registration> regiList = new ArrayList<Registration>();
	private ArrayList<RegisterNewStudents> studentList = new ArrayList<>(); // done by Jason
	public static ArrayList<RegisterNewEnquiries> enquiryList = new ArrayList<>(); //Done by Sanjeev
	
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
			RegisterNewStudents r = studentList.get(i);
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
		
		for(RegisterNewStudents r : studentList) {
			
			if(studentList.contains(r)) {
				System.out.println(r.getStudentName() + "already have this email: " + r.getStudentEmail());
			}
			else{
				studentList.add(new RegisterNewStudents(newName, newGender, newMobile, newEmail, newDOB, newCountry, newFeedback));
				System.out.println("Student has been registered successfully!");
			}	
			
		}
	}

	private static boolean removeStudent(ArrayList<RegisterNewStudents> studentList, String studentDelete) { //Done by Jason
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

	private static String getStudentByEmail(ArrayList<RegisterNewStudents> studentList, String studentDelete) { //Done by Jason

		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			RegisterNewStudents r = studentList.get(i);

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
			 RegisterNewEnquiries enquiry1 = enquiryList.get(i);
			if(eID == enquiry1.getEnquiry_id()) {
				String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
				output += String.format("%-10d %-10s %-10s %-10s %-10s", enquiry1.getEnquiry_id(), enquiry1.getPersonName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry1.getEnquiry_date()), enquiry1.getStatus(), enquiry1.getFllwupType());
				System.out.println(output);
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
		 
			for(RegisterNewEnquiries r : enquiryList) {
					enquiryList.add(new RegisterNewEnquiries(r.getEnquiry_id(), eName, dt, eStatus, fllwUpType));
					System.out.println("Enquiry has been registered successfully!");
				
			}
		 
	 }
	
	private static void enquiryMenu() { //Done by Sanjeev
		line(20, "=");
		System.out.println("1. Add New Enquiry");
		System.out.println("2. View All Enquiry");
		System.out.println("3. View All Fullfilled Enquiry");
		System.out.println("4. View All Unfullfilled Enquiry");
		System.out.println("5. Search Specific Enquiry");
		System.out.println("6. Exit");
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
				break;
			}
		}
		System.out.println("Goodbye!");
	}
	
	
	
	public static void displayAll() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		
		for(int i = 0; i< enquiryList.size(); i++) {
			RegisterNewEnquiries enquiry = enquiryList.get(i);
			output += String.format("%-10d %-10s %-10s %-10s %-10s", enquiry.getEnquiry_id(), enquiry.getPersonName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_date()), enquiry.getStatus(), enquiry.getFllwupType());
		}
		System.out.println(output);
	}
	
	public static void displayFullfilled() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		for(int i = 0; i< enquiryList.size(); i++) {
			RegisterNewEnquiries enquiry = enquiryList.get(i);
			if(enquiry.getStatus().equalsIgnoreCase("fullfilled")) {
				output += String.format("%-10d %-10s %-10s %-10s %-10s", enquiry.getEnquiry_id(), enquiry.getPersonName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_date()), enquiry.getStatus(), enquiry.getFllwupType());
			}
		}
		System.out.println(output);
	}
	
	public static void displayNotFuillfilled() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "ENQUIRY ID.", "ENQUIRER NAME", "ENQUIRY DATE & TIME", "ENQUIRY STATUS", "FOLLOW-UP TYPE");
		for(int i = 0; i< enquiryList.size(); i++) {
			RegisterNewEnquiries enquiry = enquiryList.get(i);
			if(enquiry.getStatus().equalsIgnoreCase("not fullfilled")) {
				output += String.format("%-10d %-10s %-10s %-10s %-10s", enquiry.getEnquiry_id(), enquiry.getPersonName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(enquiry.getEnquiry_date()), enquiry.getStatus(), enquiry.getFllwupType());
			}
		}
		System.out.println(output);
	}
	
	
}
