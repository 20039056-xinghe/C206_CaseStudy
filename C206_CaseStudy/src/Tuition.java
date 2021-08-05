
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * YU XING HE, 5 Aug 2021 8:26:48 am
 */

public class Tuition {

	private int tuition_code;
	private String tuition_title;
	private String subject_group_name;
	private String tuition_description;
	private int tuition_duration;
	private String pre_requisite;
	
	public Tuition(int tuition_code, String tuition_title,String tuition_description, int tuition_duration, String pre_requisite) {
	this.tuition_code = tuition_code;
	this.tuition_title = tuition_title;
	this.subject_group_name = subject_group_name;
	this.tuition_description = tuition_description;
	this.tuition_duration = tuition_duration;
	this.pre_requisite = pre_requisite;
}

	public int getTuition_code() {
		return tuition_code;
	}

	public void setTuition_code(int tuition_code) {
		this.tuition_code = tuition_code;
	}

	public String getTuition_title() {
		return tuition_title;
	}

	public void setTuition_title(String tuition_title) {
		this.tuition_title = tuition_title;
	}

	public String getSubject_group_name() {
		return subject_group_name;
	}

	public void setSubject_group_name(String subject_group_name) {
		this.subject_group_name = subject_group_name;
	}

	public String getTuition_description() {
		return tuition_description;
	}

	public void setTuition_description(String tuition_description) {
		this.tuition_description = tuition_description;
	}

	public int getTuition_duration() {
		return tuition_duration;
	}

	public void setTuition_duration(int tuition_duration) {
		this.tuition_duration = tuition_duration;
	}

	public String getPre_requisite() {
		return pre_requisite;
	}

	public void setPre_requisite(String pre_requisite) {
		this.pre_requisite = pre_requisite;
	}

	
	
}