/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.ArrayList;
/**
 *
 * @author raneemAljehani
 */
public class Manger extends user {
    
    private String password;
    
    private ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    
      public void addSession(Session session) {
        sessions.add(session);
        System.out.println("Session " + session.getSessionNumber() + " added successfully.");
    }

    public void deleteSession(int sessionNumber) {
        boolean found = false;
        for (Session session : sessions) {
            if (session.getSessionNumber() == sessionNumber) {
                sessions.remove(session);
                System.out.println("Session " + sessionNumber + " deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Session " + sessionNumber + " not found.");
        }
    }

    public void editSession(int sessionNumber, String newType, String newDate, boolean newStatus) {
        for (Session session : sessions) {
            if (session.getSessionNumber() == sessionNumber) {
                session.setSessionType(newType);
                session.setDate(newDate);
                session.setStatus(newStatus);
                System.out.println("Session " + sessionNumber + " edited successfully.");
                return;
            }
        }
        System.out.println("Session " + sessionNumber + " not found for editing.");
    }

    public void approveReservation(String reservationNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRNumber().equals(reservationNumber) && !reservation.getStatus()) {
                reservation.setStatus(true);
                System.out.println("Reservation " + reservationNumber + " approved.");
                return;
            }
        }
        System.out.println("Reservation " + reservationNumber + " not found or already approved.");
    }

    public void editReservation(String reservationNumber, String newDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getRNumber().equals(reservationNumber)) {
                reservation.setDate(newDate);
                System.out.println("Reservation " + reservationNumber + " edited successfully.");
                return;
            }
        }
        System.out.println("Reservation " + reservationNumber + " not found for editing.");
    }

    public void report() {
        System.out.println("Report Generated:");
        System.out.println("Total Sessions: " + sessions.size());
        System.out.println("Total Reservations: " + reservations.size());
        for (Reservation res : reservations) {
            System.out.println("Reservation Number: " + res.getRNumber() +
                               ", Date: " + res.getDate() +
                               ", Status: " + (res.getStatus() ? "Approved" : "Pending"));
        }
    }
}
