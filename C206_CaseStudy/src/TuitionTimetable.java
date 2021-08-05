import java.time.LocalDate;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20029425, 4 Aug 2021 9:14:21 pm
 */

public class TuitionTimetable { //Done by Jerald

	private int timetableID;
	private double price;
	private LocalDate startDate;
	private LocalDate endDate;
	private String mode;
	
	public TuitionTimetable(int timetableID, double price, LocalDate startDate, LocalDate endDate, String mode) {
		this.timetableID = timetableID;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mode = mode;
	}

	public int getTimetableID() {
		return timetableID;
	}
	
	public void setTimetableID(int timetableID) {
		this.timetableID = timetableID;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
