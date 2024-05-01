/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
/**
 *
 * @author ranee
 */

public class MangerIT {
    
    private Manger manager;
    private Session session1, session2;
    private Reservation reservation1, reservation2;

 
    @Before
    public void setUp() {
        
        ///////////////////////////////////////
        manager = new Manger();
        // Initialize sessions
        session1 = new Session(123,"rr","2024-05-01",true);
        session1.setSessionNumber(1);
        session1.setSessionType("Yoga");
        session1.setDate("2024-05-01");
        session1.setStatus(true);
//int sessionNumber, String sessionType, String date, boolean status
        session2 = new Session(123,"rr","2024-05-01",true);
        session2.setSessionNumber(2);
        session2.setSessionType("Pilates");
        session2.setDate("2024-05-02");
        session2.setStatus(false);

        manager.addSession(session1); // Add initially for test setup
        manager.addSession(session2);

        // Assuming the necessary constructors are in place
    Customer customer1 = new Customer("John Doe");
    Customer customer2 = new Customer("Doe John");

    horse horse1 = new horse("Starlight","r",true);
    horse horse2 = new horse("Moonlight","r",true);

    Trainer trainer1 = new Trainer("1233",true);
    Trainer trainer2 = new Trainer("Dane Joe",true);

    // Initialize reservations with correct parameters
    reservation1 = new Reservation("R001", customer1, horse1, session1, "2024-05-01", trainer1, false);
    reservation2 = new Reservation("R002", customer2, horse2, session2, "2024-05-02", trainer2, true);


        manager.reservations.add(reservation1);
        manager.reservations.add(reservation2);
         ArrayList<Session> se = new ArrayList<>();
              ArrayList<Reservation> reservations = new ArrayList<>();
    }

    @Test
    public void testAddSession() {
        Session newSession = new Session(123,"rr","2024-05-01",true);
        newSession.setSessionNumber(3);
        newSession.setSessionType("Spin Class");
        newSession.setDate("2024-06-01");
        newSession.setStatus(true);
        manager.addSession(newSession);
        assertTrue("Session should be added to the list", manager.sessions.contains(newSession));
    }

    @Test
    public void testDeleteSession() {
        assertTrue("Precondition failed: Session should exist before deletion", manager.sessions.contains(session1));
        manager.deleteSession(session1.getSessionNumber());
        assertFalse("Session should be removed from the list", manager.sessions.contains(session1));
    }

    @Test
    public void testEditSession() {
        String newType = "Advanced Yoga";
        String newDate = "2024-05-10";
        boolean newStatus = true;
        manager.editSession(session1.getSessionNumber(), newType, newDate, newStatus);
        assertEquals("Session type should be updated", newType, session1.getSessionType());
        assertEquals("Session date should be updated", newDate, session1.getDate());
        assertEquals("Session status should be updated", newStatus, session1.getStatus());
    }

    @Test
    public void testApproveReservation() {
        assertFalse("Precondition failed: Reservation should not be approved initially", reservation1.getStatus());
        manager.approveReservation("R001");
        assertTrue("Reservation status should be approved", reservation1.getStatus());
    }

    @Test
    public void testEditReservation() {
        String newDate = "2024-06-05";
        manager.editReservation("R002", newDate);
        assertEquals("Reservation date should be updated", newDate, reservation2.getDate());
    }

    @Test
    
    public void testReport() {
        manager.report();

        String lineSeparator = System.getProperty("line.separator");
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("Report Generated:").append(lineSeparator);
        expectedResult.append("Total Sessions: ").append(manager.sessions.size()).append(lineSeparator);
        expectedResult.append("Total Reservations: ").append(manager.reservations.size()).append(lineSeparator);
        
        for (Reservation res : manager.reservations) {
            expectedResult.append("Reservation Number: ").append(res.getRNumber())
                          .append(", Date: ").append(res.getDate())
                          .append(", Status: ").append(res.getStatus() ? "Approved" : "Pending")
                          .append(lineSeparator);
        }

        assertEquals(expectedResult.toString(),outContent.toString());
    }
}
