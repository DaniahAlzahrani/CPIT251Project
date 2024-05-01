/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.ByteArrayInputStream;
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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public CustomerIT() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Customer();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    /**
     * Test of reserveSession method, of class Customer.
     */
    @Test
    public void teststsusTrueReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", true);
        horse horse = new horse(" ", " ", true);
        Trainer trainer = new Trainer(" ", true);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
        assertTrue(session.getStatus());
    }

    @Test
    public void testhorseTrueReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", true);
        horse horse = new horse(" ", " ", true);
        Trainer trainer = new Trainer(" ", true);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
        assertTrue(horse.getStatus());
    }

    @Test
    public void testTrainerfalseReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", true);
        horse horse = new horse(" ", " ", true);
        Trainer trainer = new Trainer(" ", false);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
        assertFalse(trainer.getStatus());
    }

    @Test
    public void testHorserfalseReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", true);
        horse horse = new horse(" ", " ", false);
        Trainer trainer = new Trainer(" ", true);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, false);
        assertFalse(horse.getStatus());
    }

    @Test
    public void testStatusfalseReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", false);
        horse horse = new horse(" ", " ", true);
        Trainer trainer = new Trainer(" ", true);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
        assertFalse(session.getStatus());
    }

    @Test
    public void testTrainerTrueReserveSession() {

        System.out.println("reserveSession");
        Session session = new Session(123, " ", " ", true);
        horse horse = new horse(" ", " ", true);
        Trainer trainer = new Trainer(" ", true);
        String reservationNumber = "123";
        String date = "2023-11-01";
        instance.reserveSession(reservationNumber, instance, horse, session, date, trainer, true);
        assertTrue(trainer.getStatus());
    }

    /**
     * Test of AddContactinfo method, of class Customer.
     */
    @Test
    public void testBothFieldsEmpty() {
        instance.AddContactinfo("", "");
        String expectedResult = "Error message: name and phone number is empty!" + System.getProperty("line.separator");
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testNameContainsDigits() {
        instance.AddContactinfo("Alice123", "9876543210");
        String expectedResult = "Error message: name shouldn't contain numbers!" + System.getProperty("line.separator");
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPhoneNumberNotTenDigits() {
        instance.AddContactinfo("Alice", "123");
        String expectedResult = "Error message: number should be only 10 numbers" + System.getProperty("line.separator");
        assertEquals(expectedResult, outContent.toString());
    }

}
