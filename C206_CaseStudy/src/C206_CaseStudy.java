import java.util.ArrayList;

public class C206_CaseStudy {

	private ArrayList<Registration> regiList = new ArrayList<Registration>();
	
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
	
}
