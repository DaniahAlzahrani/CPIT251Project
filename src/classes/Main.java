/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Hamdah-
 */
public class Main {

    public static void main(String[] args) {
       
        // Instantiate necessary classes
        Customer customer = new Customer("Abdulrahman");
        Session session = new Session(101, "Introduction to Horse Riding", "2023-12-10", false);
        horse horse = new horse("Starlight", "Thoroughbred", true);
        Trainer trainer = new Trainer("Emily Clark", true);

        // Attempt to reserve a session
        String reservationNumber = "RSV123";
        System.out.println("Reserving session...");
        customer.reserveSession(reservationNumber, customer, horse, session, "2023-12-10", trainer, true);
        System.out.println("Reservation status checked.");

        // Editing session description
        System.out.println("\nUpdating session description...");
        session.setSessionType("Advanced Horse Riding Techniques");
        System.out.println("Description updated: " + session.getSessionType());

        // Adding contact information for the customer
        System.out.println("\nUpdating contact information...");
        customer.AddContactinfo("Alice Johnson", "9876543210");
        System.out.println("Contact information updated.");

        // Approving a session
        System.out.println("\nApproving the session...");
        session.setStatus(true);
        System.out.println("Session is now approved.");
    }
}
