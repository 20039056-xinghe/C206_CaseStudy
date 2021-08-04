
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20029895, 4 Aug 2021 11:30:36 am
 */

public class RegisterNewStudents { //Done by Jason
	
	private String studentName;
	private String studentGender;
	private String studentMobile;
	private String studentEmail;
	private String studentDOB;
	private String studentCountry;
	private String studentFeedback;
	
	public RegisterNewStudents(String studentName,
			String studentGender,
			String studentMobile,
			String studentEmail,
			String studentDOB,
			String studentCountry,
			String studentFeedback){
		
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentEmail = studentEmail;
		this.studentDOB = studentDOB;
		this.studentCountry = studentCountry;
		this.studentFeedback = studentFeedback;
		
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

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(String studentDOB) {
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
	
	
	

}
