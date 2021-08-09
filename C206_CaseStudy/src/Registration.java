import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20047045, 1 Aug 2021 3:54:22 am
 */

public class Registration {

	//	registration number = Registration id must be unique.
	//	tuition timetable id
	//	student’s email
	//	status which is initially set to “Pending”
	//	registration date/time

	private int regiID;  //Done by Marcus
	private int timeTableID; //Done by Marcus
	private String email; //Done by Marcus
	private String status; //Done by Marcus
	private LocalDateTime regiDateTime; //Done by Marcus
	private String paymentInformation; //Done by Marcus
	public static ArrayList<TuitionTimetable> timetableList = C206_CaseStudy.getTimetableList();
	public static ArrayList<TuitionTimetable> timetableListTest = C206_CaseStudyTest.getTimetableList();
	
	public Registration(int regiID, int timeTableID, String email) { //Done by Marcus

		this.regiID = regiID; //Done by Marcus
		this.timeTableID = timeTableID; //Done by Marcus
		this.email = email; //Done by Marcus
		this.status = "Pending"; //Done by Marcus
		this.regiDateTime = LocalDateTime.now(); //Done by Marcus
		this.paymentInformation = "Unpaid"; //Done by Marcus
			
		for (TuitionTimetable x: timetableList) {//Done by Marcus
			if (x.getTimetableID() == timeTableID) {//Done by Marcus
				int compareDate = x.getStartDate().compareTo(regiDateTime.toLocalDate());//Done by Marcus
				if (compareDate <= 3) {
					this.status = "Late";//Done by Marcus
				}
				else {
					this.status = "Pending";//Done by Marcus
				}
				
			}
		}
		
	}
	
	public Registration(int regiID, int timeTableID, String email, LocalDateTime regiDateTime) { //Done by Marcus

		this.regiID = regiID; //Done by Marcus
		this.timeTableID = timeTableID; //Done by Marcus
		this.email = email; //Done by Marcus
		this.status = "Pending"; //Done by Marcus
		this.regiDateTime = regiDateTime; //Done by Marcus
		this.paymentInformation = "Unpaid";//Done by Marcus
			
		for (TuitionTimetable x: timetableListTest) {//Done by Marcus
			if (x.getTimetableID() == timeTableID) {//Done by Marcus

				int compareDate = x.getStartDate().compareTo(regiDateTime.toLocalDate());//Done by Marcus
	
				if (compareDate <= 3) {
					this.status = "Late";//Done by Marcus
				}
				else {
					this.status = "Pending";//Done by Marcus
				}
				
			}
		}
		
	}

	public int getRegID() { //Done by Marcus
		return regiID;
	}

	public int getTimeTableID() { //Done by Marcus
		return timeTableID;
	}

	public String getEmail() { //Done by Marcus
		return email;
	}

	public String getStatus() { //Done by Marcus
		return status; 
	}
 
	public LocalDateTime getRegiDateTime() { //Done by Marcus
		return regiDateTime;
	}

	public void setStatus(String status) { //Done by Marcus
		this.status = status;
	}
	
	public String getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public String display() { //Done by Marcus
		String output = "";
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //Done by Marcus
		//"RegID", "TimeTableID", "Student Email", "Status", "RegDateTime"
		output += String.format("%-5d %-15d %-30s %-10s %-20s\n", getRegID(), getTimeTableID(), getEmail(), getStatus(), getRegiDateTime().format(dtFormat));
		return output;
		
	}
	
	
}
