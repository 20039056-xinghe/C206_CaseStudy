import java.time.LocalDateTime;
import java.util.Random;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20029934, Aug 4, 2021 5:01:13 PM
 */

public class Enquiries {
	
	
	private int enquiry_id;//Done by Sanjeev
	private String enquirerName;//Done by Sanjeev
	private LocalDateTime enquiry_dateTime;//Done by Sanjeev
	private String status;//Done by Sanjeev
	private String fllwupType;//Done by Sanjeev
		
	public Enquiries(int enquiry_id, String personName, LocalDateTime enquiry_date, String status, //Done by Sanjeev
			String fllwupType) {
		this.enquiry_id = enquiry_id;
		this.enquirerName = personName;
		this.enquiry_dateTime = enquiry_date;
		this.status = status;
		this.fllwupType = fllwupType;
	}

	public int getEnquiry_id() {//Done by Sanjeev
		return enquiry_id;
	}

	public void setEnquiry_id(int enquiry_id) {//Done by Sanjeev
		this.enquiry_id = enquiry_id;
	}

	public String getEnquirerName() {//Done by Sanjeev
		return enquirerName;
	}

	public void setEnquirerName(String enquirerName) {//Done by Sanjeev
		this.enquirerName = enquirerName;
	}

	public LocalDateTime getEnquiry_dateTime() {//Done by Sanjeev
		return enquiry_dateTime;
	}

	public void setEnquiry_dateTime(LocalDateTime enquiry_dateTime) {//Done by Sanjeev
		this.enquiry_dateTime = enquiry_dateTime;
	}

	public String getStatus() {//Done by Sanjeev
		return status;
	}

	public void setStatus(String status) {//Done by Sanjeev
		this.status = status;
	}

	public String getFllwupType() {//Done by Sanjeev
		return fllwupType;
	}

	public void setFllwupType(String fllwupType) {//Done by Sanjeev
		this.fllwupType = fllwupType;
	}
	
}
