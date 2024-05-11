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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Instantiate necessary classes
        Customer customer = new Customer();
        Session session = new Session(101, "Introduction to Horse Riding", "2023-12-10", false);
        horse horse = new horse("Starlight", "Thoroughbred", true);
        Trainer trainer = new Trainer("Emily Clark", true);

        // Attempt to reserve a session
        String reservationNumber = "RSV123";
        System.out.println("Attempting to reserve a session...");
        boolean reservationResult = customer.reserveSession(reservationNumber, customer, horse, session, "2023-12-10", trainer, true);
        System.out.println("Reservation successful: " + reservationResult);

        // Editing a session description
        System.out.println("\nEditing session description...");
        session.setDescription("Advanced Horse Riding Techniques");
        System.out.println("Updated session description: " + session.getDescription());

        // Adding contact information for the customer
        System.out.println("\nAdding contact information...");
        customer.addContactInfo("Alice Johnson", "9876543210");
        System.out.println("Contact information added.");

        // Approving a session
        System.out.println("\nApproving the session...");
        session.setStatus(true);
        System.out.println("Session approved: " + session.getStatus());
    }
}