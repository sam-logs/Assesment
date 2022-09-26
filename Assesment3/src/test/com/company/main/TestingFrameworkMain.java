package test.com.company.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.company.Service.ReferralCode;

class TestingFrameworkMain {
	private List<ReferralCode> list;

	@Test
	public void test() {
		System.out.println("In testing");
	}

	@BeforeEach
	public void setUp() {
		list = new ArrayList<ReferralCode>();
	}

	@Test
	public void testListInit() {
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
	}

	@Test
	public void testInvalidCapacity() {
		assertThrows(IllegalArgumentException.class, () -> {
			list = new ArrayList<ReferralCode>(-1);
		});
	}

	@Test
	public void testRemoveWithEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(0);
		});
	}
//	
//	@Test
//	public void testremoveChar() {
//	    LoginPage obj = new LoginPage("sam", "1234");
//	    
//	    assertEquals("You have Succesfully logged in User: ",obj);
//	}

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Displaying Before All");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Displaying After Each");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("displaying After All");
	}

}
