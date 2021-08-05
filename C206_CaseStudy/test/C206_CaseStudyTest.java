import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Enquiries rne1;
	private Enquiries rne2;
	
	private ArrayList<Enquiries> enquiry_list;

	@Before
	public void setUp() throws Exception {
		int rne1_enquiry_id = 1;
		int rne2_enquiry_id = 2;
		String dt = "2021-10-10 10:10:10";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse(dt, formatter);
		
		rne1 = new Enquiries(rne1_enquiry_id, "JJ", dt1, "fullfilled", "mail");
		rne2 = new Enquiries(rne2_enquiry_id, "AJ", dt1, "fullfilled", "phone");
		
		enquiry_list = new ArrayList<Enquiries>();
	}
	
	//Sanjeev JUNIT TESTING BELOW
	
	
	
	
	//Jerald JUNIT TESTING BELOW

	
	
	
	//Jason JUNIT TESTING BELOW

	
	
	
	//Marcus JUNIT TESTING BELOW

	
	
	
	//Xing He JUNIT TESTING BELOW
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		rne1 = null;
		rne2 = null;
	}
}
