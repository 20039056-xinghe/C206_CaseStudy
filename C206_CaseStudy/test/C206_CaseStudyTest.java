import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Enquiries rne1;
	private Enquiries rne2;
	private Enquiries rne3;
	private Enquiries rne4;
	private ArrayList<Enquiries> enquiry_list; // Sanjeev
	
	private TuitionTimetable tl1;
	private TuitionTimetable tl2; // Jerald
	
	private Students student1;
	private Students student2;// Jason
	
	 

	@Before
	public void setUp() throws Exception {
		int rne1_enquiry_id = 1;
		int rne2_enquiry_id = 2;
		int rne3_enquiry_id = 3;
		int rne4_enquiry_id = 4;
		String dt = "2021-10-10 10:10:10";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse(dt, formatter);
		
		rne1 = new Enquiries(rne1_enquiry_id, "JJ", dt1, "fullfilled", "mail");
		rne2 = new Enquiries(rne2_enquiry_id, "AJ", dt1, "fullfilled", "phone");
		rne3 = new Enquiries(rne3_enquiry_id, "PJ", dt1, "unfullfilled", "phone");
		rne4 =new Enquiries(rne4_enquiry_id, "DJ", dt1, "unfullfilled", "mail");
		enquiry_list = new ArrayList<Enquiries>();
		
		
		//----------UP TO SANJEEV----------//
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate1 = LocalDate.parse("05-08-2021", formatter1);
		LocalDate endDate1 = LocalDate.parse("05-12-2021", formatter1);
		LocalDate startDate2 = LocalDate.parse("01-10-2021", formatter1);
		LocalDate endDate2 = LocalDate.parse("01-11-2021", formatter1);
		
		tl1 = new TuitionTimetable(1, 123.40, startDate1, endDate1, "F2F");
		tl2 = new TuitionTimetable(2, 246.80, startDate2, endDate2, "Zoom");
		
		
		//----------UP TO JERALD----------//
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate student1DOB = LocalDate.parse("11-12-2003", formatter2);
		LocalDate student2DOB = LocalDate.parse("11-07-2006", formatter2);
		
		student1 = new Students("Jake", "Male", 99998888, "Jake@gmail.com", student1DOB, "Singapore", "none");
		student2 = new Students("Jacob", "Male", 91234567, "Jacob@gmail.com", student2DOB, "Malaysia", "none");
		
		//----------UP TO JASON----------//
		
		
		
		//----------UP TO MARCUS----------//
		
		
		
		//----------UP TO XING HE----------//
		
	}
	
	//Sanjeev JUNIT TESTING BELOW
	
	@Test
	public void addEnquiryTest() { //Done by Sanjeev1
		//Check that the arraylist is not null so enquiry object can be added into the arrayList
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		//Given a empty arraylist check that when a enquiry object is added into the arraylist, the size increases from 0 to one
		C206_CaseStudy.addEnquiry(enquiry_list, rne1);
		
		assertEquals("Test that Enquiry arraylist size is 1", 1, enquiry_list.size());
		assertSame("Test that Enquiry is added", rne1, enquiry_list.get(0));
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		//The second element is almost the same as the first one
		C206_CaseStudy.addEnquiry(enquiry_list, rne2);
		
		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		assertSame("Test that the first Enquiry is added", rne2, enquiry_list.get(1));
		
	}
	
	@Test
	public void retrieveAllEnquiryTest() { //Done by Sanjeev
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test that if the arraylist is empty a message stating no enquiries for now :( would be displayed
		String allEnquiry = C206_CaseStudy.retrieveAll(enquiry_list);
		String testOutput = "No enquiries for now :(";
		assertEquals("Test that the retrieved enquiryList displays the expected testOutput", testOutput, allEnquiry);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 
		C206_CaseStudy.addEnquiry(enquiry_list, rne1);
		C206_CaseStudy.addEnquiry(enquiry_list, rne2);

		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		
		//test if the expected output string same as the list of enquiries retrieved from the C206_CaseStudy
		String allEnquiries= C206_CaseStudy.retrieveAll(enquiry_list);
		testOutput = C206_CaseStudy.displayHeader();
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne1.getEnquiry_id(), rne1.getEnquirerName(), 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne1.getEnquiry_dateTime()), rne1.getStatus(), rne1.getFllwupType());
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne2.getEnquiry_id(), rne2.getEnquirerName(), 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne2.getEnquiry_dateTime()), rne2.getStatus(), rne2.getFllwupType());
		assertEquals("Test that data displayed in the enquiry list is the same as the test output", testOutput, allEnquiries);

	}
	
	@Test
	public void retrieveAllFullfilledTest() { //Done by Sanjeev
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test that if the arraylist is empty a message stating no enquiries for now :) would be displayed
		String allEnquiry = C206_CaseStudy.retrieveFullfilled(enquiry_list);
		String testOutput = "No fullfilled enquiries for now :(";
		assertEquals("Test that the retrieved enquiryList displays the expected testOutput", testOutput, allEnquiry);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 
		C206_CaseStudy.addEnquiry(enquiry_list, rne1);
		C206_CaseStudy.addEnquiry(enquiry_list, rne2);

		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		
		//test if the expected output string same as the list of enquiries retrieved from the C206_CaseStudy
		String allFullfilledEnquiries= C206_CaseStudy.retrieveAll(enquiry_list);
		testOutput = C206_CaseStudy.displayHeader();
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne1.getEnquiry_id(), rne1.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne1.getEnquiry_dateTime()), rne1.getStatus(), rne1.getFllwupType());
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne2.getEnquiry_id(), rne2.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne2.getEnquiry_dateTime()), rne2.getStatus(), rne2.getFllwupType());
		assertEquals("Test that only fullfilled enquiries are displayed from the enquirylist the same format as the testOutput", testOutput, allFullfilledEnquiries);
	}
	
	@Test 
	public void retrieveAllNotFullfilledTest() { //Done by Sanjeev
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test that if the arraylist is empty a message stating no enquiries for now :( would be displayed
		String allEnquiry = C206_CaseStudy.retrieveNotFuillfilled(enquiry_list);
		String testOutput =  "No unfullfilled enquiries :)";
		assertEquals("Test that the retrieved enquiryList displays the expected testOutput", testOutput, allEnquiry);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 
		C206_CaseStudy.addEnquiry(enquiry_list, rne3);
		C206_CaseStudy.addEnquiry(enquiry_list, rne4);

		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		
		//test if the expected output string same as the list of enquiries retrieved from the C206_CaseStudy
		String allNotfilledEnquiries= C206_CaseStudy.retrieveNotFuillfilled(enquiry_list);
		testOutput = C206_CaseStudy.displayHeader();
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne3.getEnquiry_id(), rne3.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne3.getEnquiry_dateTime()), rne3.getStatus(), rne3.getFllwupType());
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne4.getEnquiry_id(), rne4.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne4.getEnquiry_dateTime()), rne4.getStatus(), rne4.getFllwupType());
		assertEquals("Test that only unfullfilled enquiries are displayed from the enquirylist the same format as the testOutput", testOutput, allNotfilledEnquiries);
	}
	
	@Test
	public void deleteEnquiryTest() { //Done by Sanjeev1
		//Check that the arraylist is not null so enquiry object can be added into the arrayList
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		//The second element is almost the same as the first one
		C206_CaseStudy.addEnquiry(enquiry_list, rne1);
		C206_CaseStudy.addEnquiry(enquiry_list, rne2);
		
		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		assertSame("Test that the first Enquiry is added", rne1, enquiry_list.get(0));		
		assertSame("Test that the first Enquiry is added", rne2, enquiry_list.get(1));
		
		
		//Given that a list with 2 items, test if the size of the list decreases when 1 item is deleted
		C206_CaseStudy.deleteEnquiry(enquiry_list, rne1.getEnquiry_id());;
		C206_CaseStudy.deleteEnquiry(enquiry_list, rne2.getEnquiry_id());
		
		assertEquals("Test that Enquiry arraylist size is 0", 0, enquiry_list.size());

	}
	
	
	//Jerald JUNIT TESTING BELOW
	
	@Test
	public void testAddTimetable() {
		
		C206_CaseStudy.timetableList.clear();
		
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		assertEquals(1, C206_CaseStudy.timetableList.size());
		
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertEquals(2, C206_CaseStudy.timetableList.size());
		
		assertSame(tl2, C206_CaseStudy.timetableList.get(1));
		
	}
	@Test
	public void testViewTimetable() {
		
		C206_CaseStudy.timetableList.clear();
		
		assertEquals(0, C206_CaseStudy.timetableList.size());
		
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertEquals(2, C206_CaseStudy.timetableList.size());
		
		C206_CaseStudy.timetableList.remove(tl1);
		assertNotSame(tl1, C206_CaseStudy.timetableList.get(0));

	}
	@Test
	public void testDeleteTimetable() {
		
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertSame(1, C206_CaseStudy.timetableList.get(0).getTimetableID());
		
		C206_CaseStudy.timetableList.remove(tl1);
		assertEquals(1, C206_CaseStudy.timetableList.size());
		
		assertNotSame(1, C206_CaseStudy.timetableList.get(0).getTimetableID());
		
	}
	
	
	//Jason JUNIT TESTING BELOW
	
	public void testViewStudents() {
		
		//Check that there is a valid arrayList to view from
		assertNull( C206_CaseStudy.studentList);
		
		//Test that the results that are displayed are the same ones stored within the arrayList
		C206_CaseStudy.addNewStudent(C206_CaseStudy.studentList, student1);
		assertSame(C206_CaseStudy.studentList.get(0), student1);
		
		//Test that once an item has been removed using the delete function, that item can no longer be seen with the view function.
		C206_CaseStudy.studentList.remove(student1);
		assertNotSame(C206_CaseStudy.studentList.get(0), student1);
	}
	
	public void testAddStudents() {
		
		//Check that there is a valid arrayList to add to
		assertNull( C206_CaseStudy.studentList);
		
		//Assuming that the list is empty, test that after adding a student into the arrayList, the size of it increases by 1.
		C206_CaseStudy.addNewStudent(C206_CaseStudy.studentList, student1);
		assertEquals(1, C206_CaseStudy.studentList.size());
		
		//Assuming that there are already has 1 items within the list. Test that when adding 1 more item, that item is the second item within the list
		C206_CaseStudy.addNewStudent(C206_CaseStudy.studentList, student2);
		assertSame(student2, C206_CaseStudy.studentList.get(2));
		
	}
		public void testDeleteStudents() {
			
			//Assuming that there aree already has 2 items within the list. Test that when deleting 1 item, that item is no longer the second item within the list
			C206_CaseStudy.addNewStudent(C206_CaseStudy.studentList, student1);
			C206_CaseStudy.addNewStudent(C206_CaseStudy.studentList, student2);
			C206_CaseStudy.deleteStudent(C206_CaseStudy.studentList, student2);
			assertNotSame(student2,  C206_CaseStudy.studentList.get(1));
			
			//Check that there is a valid arrayList to delete from
			assertNull( C206_CaseStudy.studentList);
			
			//Assuming that the list only has 1 item. After deleting an that item from the list, the size of the list decreases to 0.
			C206_CaseStudy.deleteStudent(C206_CaseStudy.studentList, student1);
			assertEquals(0, C206_CaseStudy.studentList.size());
			
		}


	
	
	
	//Marcus JUNIT TESTING BELOW

	
	
	
	//Xing He JUNIT TESTING BELOW
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		rne1 = null;
		rne2 = null;
		rne3 = null;
		rne4 = null;
		tl1 = null;
		tl2 = null;
	}
}
