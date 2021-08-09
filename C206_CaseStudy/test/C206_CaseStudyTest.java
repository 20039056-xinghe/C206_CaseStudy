import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
	private Enquiries rne5;
	private Enquiries rne6;
	private ArrayList<Enquiries> enquiry_list; // Sanjeev
	
	private TuitionTimetable tl1;
	private TuitionTimetable tl2; // Jerald
	
	private Students student1;
	private Students student2;// Jason
	
	private Registration registration1; // done by Marcus
	private Registration registration2; // done by Marcus
	private ArrayList<Registration> regiList = new ArrayList<Registration>(); // done by Marcus
	
	 

	@Before
	public void setUp() throws Exception {
		//---------------------------------Sanjeev Test case---------------------------------//
		int rne1_enquiry_id = 1;
		int rne2_enquiry_id = 2;
		int rne3_enquiry_id = 3;
		int rne4_enquiry_id = 4;
		int rne5_enquiry_id = 5;
		String dt = "2021-10-10 10:10:10";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse(dt, formatter);
		
		rne1 = new Enquiries(rne1_enquiry_id, "JJ", dt1, "fullfilled", "mail");
		rne2 = new Enquiries(rne2_enquiry_id, "AJ", dt1, "fullfilled", "phone");
		rne3 = new Enquiries(rne3_enquiry_id, "PJ", dt1, "unfullfilled", "phone");
		rne4 =new Enquiries(rne4_enquiry_id, "DJ", dt1, "unfullfilled", "mail");
		rne5 = new Enquiries(rne5_enquiry_id, "NJ", dt1, "Processing", "mail");
		rne6 = new Enquiries(rne5_enquiry_id, "CJ", dt1, "Processing", "mail");
		enquiry_list = new ArrayList<Enquiries>();
		

		//---------------------------------Jerald Test case---------------------------------//
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate1 = LocalDate.parse("05-08-2021", formatter1);
		LocalDate endDate1 = LocalDate.parse("05-12-2021", formatter1);
		LocalDate startDate2 = LocalDate.parse("01-10-2021", formatter1);
		LocalDate endDate2 = LocalDate.parse("01-11-2021", formatter1);
		
		tl1 = new TuitionTimetable(null, 1, 123.40, startDate1, endDate1, "F2F");
		tl2 = new TuitionTimetable(null, 2, 246.80, startDate2, endDate2, "Zoom");
		

		//---------------------------------Jason Test case---------------------------------//
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate student1DOB = LocalDate.parse("11-12-2003", formatter2);
		LocalDate student2DOB = LocalDate.parse("11-07-2006", formatter2);
		
		student1 = new Students("Jake", "Male", 99998888, "Jake@gmail.com", student1DOB, "Singapore", "none", "pass123");
		student2 = new Students("Jacob", "Male", 91234567, "Jacob@gmail.com", student2DOB, "Malaysia", "none", "pass123");
		
		//---------------------------------Marcus Test case---------------------------------//
		DateTimeFormatter regiDTformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime regiDate1 = LocalDateTime.parse("04-08-2021 19:13:39",regiDTformat);
		LocalDateTime regiDate2 = LocalDateTime.parse("30-07-2021 19:13:39",regiDTformat);
		
		registration1 = new Registration(1, tl1.getTimetableID(), "reg1@mail.com", regiDate1);
		registration2 = new Registration(2, tl2.getTimetableID(), "reg2@mail.com", regiDate2);	
		
		
		//---------------------------------Xing He Test case---------------------------------//
		
	}
	
	//---------------------------------Sanjeev JUnit---------------------------------//
	
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
	
	@Test
	public void retrieveProcessedTest() { //Done by Sanjeev
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test that if the arraylist is empty a message stating No Processing enquiries :( would be displayed
		String allEnquiry = C206_CaseStudy.retrieveProcessing(enquiry_list);
		String testOutput =  "No Processing enquiries :(";
		assertEquals("Test that the retrieved enquiryList displays the expected testOutput", testOutput, allEnquiry);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 
		C206_CaseStudy.addEnquiry(enquiry_list, rne5);
		C206_CaseStudy.addEnquiry(enquiry_list, rne6);

		assertEquals("Test that Enquiry arraylist size is 2", 2, enquiry_list.size());
		
		//test if the expected output string same as the list of enquiries retrieved from the C206_CaseStudy
		String allProcessingEnquiries= C206_CaseStudy.retrieveProcessing(enquiry_list);
		testOutput = C206_CaseStudy.displayHeader();
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne5.getEnquiry_id(), rne5.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne5.getEnquiry_dateTime()), rne5.getStatus(), rne5.getFllwupType());
		testOutput += String.format("\n%-10d %8s %25s %12s %13s", rne6.getEnquiry_id(), rne6.getEnquirerName(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rne6.getEnquiry_dateTime()), rne6.getStatus(), rne6.getFllwupType());
		assertEquals("Test that only unfullfilled enquiries are displayed from the enquirylist the same format as the testOutput", testOutput, allProcessingEnquiries);
	}
	
	@Test
	public void checkStatustoProcessingTest() {
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test that if Enquiry object's status is updated to processing, when checked in the arrayList the status should be displayed as "Processing"
		enquiry_list.add(rne1);
		C206_CaseStudy.checkStatustoProcessing(enquiry_list, rne1.getEnquiry_id());
		assertEquals("Test that the status has changed to 'Processing'", "Processing", rne1.getStatus());
		
		//Test that if another Enquiry object's status is updated to processing, when checked in the arrayList the status should be displayed as "Processing"
		enquiry_list.add(rne2);
		C206_CaseStudy.checkStatustoProcessing(enquiry_list, rne2.getEnquiry_id());
		assertEquals("Test that the status has changed to 'Processing'", "Processing", rne2.getStatus());

		//Test that if the enquiry id entered is not found in the arraylist "Name not found in list!"
		boolean isFound = C206_CaseStudy.checkStatustoProcessing(enquiry_list, rne3.getEnquiry_id());
		assertFalse("Test that the error message, name not found in list, is displayed if the enquiry object is not in arrayList", isFound);
		

	}
	
	@Test
	public void searchEnquiryTest() {
		//Check that the arraylist is not null so enquiry objects can be retrieved from the arraylist
		assertNotNull("Check if there is a valid Enquiries arrayList", enquiry_list);
		
		//Test if Enquiry Object can be foudn in the arraylist
		C206_CaseStudy.addEnquiry(enquiry_list, rne6);
		Boolean isFound = C206_CaseStudy.searchEnquiry(enquiry_list, rne6.getEnquirerName());
		assertTrue("Test if enquirer name can be found", isFound);
		
		//Test that a name not in the arraylist can be searched
		Boolean isFalse = C206_CaseStudy.searchEnquiry(enquiry_list, rne5.getEnquirerName());
		assertFalse("Test that the name can be found in the arrayList", isFalse);

	}
	
	
	//---------------------------------Jerald JUnit---------------------------------//
	
	@Test
	public void testAddTimetable() {
		
		C206_CaseStudy.timetableList.clear();
		
		//Test that given an empty list, after adding one object, the size of the list is 1 
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		assertEquals(1, C206_CaseStudy.timetableList.size());
		
		//Test that after adding another object, the size of the list is 2 
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertEquals(2, C206_CaseStudy.timetableList.size());
		
		//Test that the object just added is the same as the 2nd object of the list after adding
		assertSame(tl2, C206_CaseStudy.timetableList.get(1));
		
	}
	@Test
	public void testViewTimetable() {
		
		C206_CaseStudy.timetableList.clear();
		
		//Test that the list of tuition timetables is empty without adding any timetables 
		assertEquals(0, C206_CaseStudy.timetableList.size());
		
		//Test that the number of objects in the displayed is 2 after adding an object 
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertEquals(2, C206_CaseStudy.timetableList.size());
		
		//Test that when the object is removed, the object will not be found in the list anymore 
		C206_CaseStudy.timetableList.remove(tl1);
		assertNotSame(tl1, C206_CaseStudy.timetableList.get(0));

	}
	@Test
	public void testDeleteTimetable() {
		
		//Test that the object is present for removal 
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl1);
		C206_CaseStudy.addTimetable(C206_CaseStudy.timetableList, tl2);
		assertSame(1, C206_CaseStudy.timetableList.get(0).getTimetableID());
		
		//Test that the recently deleted object is removed from the list of tuition timetables 
		C206_CaseStudy.timetableList.remove(tl1);
		assertEquals(1, C206_CaseStudy.timetableList.size());
		
		//Test that the object does not show up when viewing all tuition timetables 
		assertNotSame(1, C206_CaseStudy.timetableList.get(0).getTimetableID());
		
	}
	
	
	//---------------------------------Jason JUnit---------------------------------//
	@Test
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
	@Test
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
	@Test
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


	
	
		//---------------------------------Marcus JUnit---------------------------------//
		
		@Test
		public void addRegistrationTest() {
			// Test if the registration ArrayList is empty not null - boundary
			assertNotNull("Check if there is valid Registration arraylist to add to", regiList);
			
			//Test that given an empty ArrayList, after adding 1 item, the size of the list is 1 - normal
			
			C206_CaseStudy.addRegistration(registration1, regiList);
			assertEquals("Check that Registration arraylist size is 1", 1, regiList.size());
			assertSame("Check that Registration is added", registration1, regiList.get(0));
			
			//Add another item. test The size of the list is 2? -normal
			C206_CaseStudy.addRegistration(registration2, regiList);
			assertEquals("Check that Registration arraylist size is 2", 2, regiList.size());
			//Test that the item just added is as same as the second item of the list
			assertSame("Check that Registration is added", registration2, regiList.get(1));
		}
	
		@Test
		public void viewAllRegistrationTest() {
			// Test if Item list is not null but empty -boundary
			assertNotNull("Test if there is valid Registration arraylist to retrieve item", regiList);
			
			//Test if the list of Registration retrieved from the C206_CaseStudy is empty - boundary
			String allRegistration= C206_CaseStudy.retriveAllRegistration(regiList);
			String emptyOutput = "No registration found";
			assertEquals("Test that ViewAllregistration", emptyOutput, allRegistration);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			C206_CaseStudy.addRegistration(registration1, regiList);
			C206_CaseStudy.addRegistration(registration2, regiList);
			assertEquals("Test that Registration arraylist size is 2", 2, regiList.size());
			
			//Test if the expected output string same as the list of Registration retrieved from the C206_CaseStudy	
			allRegistration= C206_CaseStudy.retriveAllRegistration(regiList);
			String testOutput = String.format("%-5s %-15s %-30s %-10s %-20s\n", "RegID", "TimeTableID", "Student Email", "Status","RegDateTime");
			testOutput += String.format("%-5d %-15d %-30s %-10s %-20s\n", 1, tl1.getTimetableID(), "reg1@mail.com", "Pending", "2021-08-04 19:13:39");
			testOutput += String.format("%-5d %-15d %-30s %-10s %-20s\n", 2, tl2.getTimetableID(), "reg2@mail.com", "Pending", "2021-07-30 19:13:39");
		
			assertEquals("Test that ViewAllRegistration", testOutput, allRegistration);
			
		}
		
		@Test
		public void deleteRegistrationTest() { //Done by Marcus
			
			//Test that the arraylist is not null so Registration object can be added into the arrayList
			assertNotNull("Check if there is a valid Registration arrayList", regiList);

			//Given an empty list, after adding 2 items, test if after adding an item, the item can be deleted
			//The second element is almost the same as the first one
			
			C206_CaseStudy.addRegistration(registration1, regiList);
			C206_CaseStudy.addRegistration(registration2, regiList);
			
			assertEquals("Test that Enquiry arraylist size is 2", 2, regiList.size());
			assertSame("Test that the first Registration is added", registration1, regiList.get(0));		
			assertSame("Test that the second Registration is added", registration2, regiList.get(1));
			
			
			//Given that a list with 2 items, test if the size of the list decreases when 1 item is deleted
			C206_CaseStudy.deleteRegistration(regiList, registration1.getRegID());
			assertEquals("Test that Registration arraylist size is 1", 1, regiList.size());
			
			//Test if the same item that just been deleted can be deleted again.
			boolean test = C206_CaseStudy.checkValidID(regiList, registration1.getRegID());
			assertFalse("Test if the same item that just been deleted can be deleted again.", test);
			
			//Test if the non existing item can be deleted.
			boolean test2 = C206_CaseStudy.checkValidID(regiList, 3);
			assertFalse("Test if the non existing item can be deleted.", test2);
			C206_CaseStudy.deleteRegistration(regiList, 3);
			assertEquals("Test that Registration arraylist size is still 1", 1, regiList.size());

		}
	
	
		//---------------------------------Xing He JUnit---------------------------------//
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		rne1 = null;
		rne2 = null;
		rne3 = null;
		rne4 = null;
		tl1 = null;
		tl2 = null;
		registration1 = null;
		registration2 = null;
	}
}
