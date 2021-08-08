import java.time.LocalDate;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20029895, 4 Aug 2021 11:30:36 am
 */

public class Students { //Done by Jason
	
	private String studentName;
	private String studentGender;
	private int studentMobile;
	private String studentEmail;
	private LocalDate studentDOB;
	private String studentCountry;
	private String studentFeedback;
	private String studentPassword;
	
	public Students(String studentName,
			String studentGender,
			int studentMobile,
			String studentEmail,
			LocalDate studentDOB,
			String studentCountry,
			String studentFeedback,
			String studentPassword){
		
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentEmail = studentEmail;
		this.studentDOB = studentDOB;
		this.studentCountry = studentCountry;
		this.studentFeedback = studentFeedback;
		this.studentPassword = studentPassword;
		
	}
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public int getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(int studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public LocalDate getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(LocalDate studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getStudentCountry() {
		return studentCountry;
	}

	public void setStudentCountry(String studentCountry) {
		this.studentCountry = studentCountry;
	}

	public String getStudentFeedback() {
		return studentFeedback;
	}

	public void setStudentFeedback(String studentFeedback) {
		this.studentFeedback = studentFeedback;
	}
	public String getStudentPassword(String studentPassword) {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	
	
	

}
