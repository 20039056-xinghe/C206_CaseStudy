import java.util.ArrayList;

public class C206_CaseStudy {

	private ArrayList<Registration> regList = new ArrayList<Registration>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

	private void RegisterMenu() { //Done by Marcus
		System.out.println("1. Register for Tuition Timetable"); //Done by Marcus
		System.out.println("2. View All Registration"); //Done by Marcus
		System.out.println("3. Delete Registration"); //Done by Marcus
	}
	
	private void AddRegistration() { //Done by Marcus
		//registration number = Registration id must be unique.
			//	tuition timetable id
			//	student’s email
			//	status which is initially set to “Pending”
			//	registration date/time
		int regiNum = readInt("Registration ID > "); //Done by Marcus
		int timeTabelID = readInt("Time Table ID > "); //Done by Marcus
		String stuEmail = readString("Student's Email"); //Done by Marcus
		
		
		boolean repeat = checkForDupeRegiNum(regiNum);
		
		if(repeat == false) {  //Done by Marcus
			regList.add(new Registration(regiNum, timeTabelID, stuEmail)); //Done by Marcus
		}else { //Done by Marcus
			System.out.println("Please use a unique Registration ID"); //Done by Marcus
		}

	}

	private boolean checkForDupeRegiNum(int regiNum) { //Done by Marcus
		boolean repeat = false;
		for (Registration x : regList) {
			if (x.getRegiNo() == regiNum) {
				repeat = true;
			}
		}
		return repeat;
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
