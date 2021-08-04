import java.time.LocalDateTime;

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
	//	student�s email
	//	status which is initially set to �Pending�
	//	registration date/time

	private int regiNo;  //Done by Marcus
	private int timeTableID; //Done by Marcus
	private String email; //Done by Marcus
	private String status; //Done by Marcus
	private LocalDateTime regiDateTime; //Done by Marcus
	
	public Registration(int regiNo, int timeTableID, String email) { //Done by Marcus

		this.regiNo = regiNo; //Done by Marcus
		this.timeTableID = timeTableID; //Done by Marcus
		this.email = email; //Done by Marcus
		this.status = "Pending"; //Done by Marcus
		this.regiDateTime = LocalDateTime.now(); //Done by Marcus
	}

	public int getRegiNo() { //Done by Marcus
		return regiNo;
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
	
	
	
	
}
