/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony-
 */
public class CustomerIT {
    
    public Customer instance;
    private static ByteArrayOutputStream outContent;
    private static PrintStream originalOut;
    public CustomerIT() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Customer();
    }
    
    @After
    public void tearDown() {
         System.setOut(originalOut);
    }

    /**
     * Test of showHistory method, of class Customer.
     */
    @Test
    public void testShowHistory() {
        System.out.println("showHistory");
        Customer instance = new Customer();
        instance.showHistory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserveSession method, of class Customer.
     */
    @Test
public void teststsusTrueReserveSession() {
    
    System.out.println("reserveSession");
    Customer instance = new Customer();
    Session session = new Session(123 , " " , " " , true);
    horse horse = new horse(" ", " " , true);
    Trainer trainer = new Trainer(" " , true);
    String reservationNumber = "123";
    String date = "2023-11-01";
    instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
    assertTrue(session.getStatus());
}
 @Test
 public void testhorseTrueReserveSession() {
    
    System.out.println("reserveSession");
    Customer instance = new Customer();
    Session session = new Session(123 , " " , " " , true);
    horse horse = new horse(" ", " " , true);
    Trainer trainer = new Trainer(" " , true);
    String reservationNumber = "123";
    String date = "2023-11-01";
    instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
    assertTrue(horse.getStatus());
}
  @Test
 public void testTrainerTrueReserveSession() {
    
    System.out.println("reserveSession");
    Customer instance = new Customer();
    Session session = new Session(123 , " " , " " , true);
    horse horse = new horse(" ", " " , true);
    Trainer trainer = new Trainer(" " , true);
    String reservationNumber = "123";
    String date = "2023-11-01";
    instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
    assertTrue(trainer.getStatus());
}
    /**
     * Test of getReservationDetails method, of class Customer.
     */
    @Test
    public void testGetReservationDetails() {
        System.out.println("getReservationDetails");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getReservationDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddContactinfo method, of class Customer.
     */
    
    @Test
    public void testBothFieldsEmpty() {
        instance.AddContactinfo("", "");
        assertEquals("Error message: name and phone number is empty!\n", outContent.toString());
    }

    @Test
    public void testNameContainsDigits() {
        instance.AddContactinfo("Alice123", "9876543210");
        assertEquals("Error message: name shouldn't contain numbers!\n", outContent.toString());
    }

    @Test
    public void testPhoneNumberNotTenDigits() {
        instance.AddContactinfo("Alice", "123");
        assertEquals("Error message: number should be only 10 numbers\n", outContent.toString());
    }

    /**
     * Test of containsDigits method, of class Customer.
     */
    @Test
    public void testContainsDigits() {
        System.out.println("containsDigits");
        String name = "";
        boolean expResult = false;
        boolean result = Customer.containsDigits(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserveSession method, of class Customer.
     */
    @Test
    public void testReserveSession() {
        System.out.println("reserveSession");
        String rNumber = "";
        Customer customer = null;
        horse horse = null;
        Session session = null;
        String date = "";
        Trainer trainer = null;
        boolean status = false;
        Customer instance = new Customer();
        instance.reserveSession(rNumber, customer, horse, session, date, trainer, status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
