import java.time.LocalDateTime;
import java.util.Random;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20029934, Aug 4, 2021 5:01:13 PM
 */

public class RegisterNewEnquiries {
	
	
	private int enquiry_id;
	private String enquirerName;
	private LocalDateTime enquiry_dateTime;
	private String status;
	private String fllwupType;
	
	public RegisterNewEnquiries() {
		
	}
	
	public RegisterNewEnquiries(int enquiry_id, String personName, LocalDateTime enquiry_date, String status,
			String fllwupType) {
		this.enquiry_id = enquiry_id;
		this.enquirerName = personName;
		this.enquiry_dateTime = enquiry_date;
		this.status = status;
		this.fllwupType = fllwupType;
	}

	public int getEnquiry_id() {
		String alphabet = "1234567890";
		int length = 5;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < length; i++) {
		      int index = random.nextInt(alphabet.length());
		      char randomChar = alphabet.charAt(index);
		      sb.append(randomChar);
		    }
		enquiry_id = Integer.parseInt(sb.toString());
		return enquiry_id;
	}

	public String getPersonName() {
		return enquirerName;
	}

	public String setPersonName(String personName) {
		this.enquirerName = personName;
		return personName;
	}

	public LocalDateTime getEnquiry_date() {
		return enquiry_dateTime;
	}

	public LocalDateTime setEnquiry_date(LocalDateTime enquiry_dateTime) {
		this.enquiry_dateTime = enquiry_dateTime;
		return enquiry_dateTime;
	}

	public String getStatus() {
		return status;
	}

	public String setStatus(String status) {
		this.status = status;
		return status;
	}

	public String getFllwupType() {
		return fllwupType;
	}

	public String setFllwupType(String fllwupType) {
		this.fllwupType = fllwupType;
		return fllwupType;
	}
	
	


}
