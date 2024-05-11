/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.Scanner;
/**
 *
 * @author Hamdah-
 */
public class Main {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate necessary classes
        Customer customer = new Customer();
        Session session = new Session(101, "Introduction to Horse Riding", "2023-12-10", false);
        horse horse = new horse("Starlight", "Thoroughbred", true); // Correct class name capitalization
        Trainer trainer = new Trainer("Emily Clark", true);

        // Adding contact information for the customer
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        customer.AddContactinfo(name, phoneNumber);
        System.out.println("Contact information added.");

        // Attempt to reserve a session
        System.out.println("\nPlease enter reservation number:");
        String reservationNumber = scanner.nextLine();
        System.out.println("Attempting to reserve a session...");
        customer.reserveSession(reservationNumber, customer, horse, session, "2023-12-10", trainer, true);
        System.out.println("Reservation attempt complete.");

        // Editing a session description
        System.out.println("\nDo you want to change the session description? (yes/no)");
        String editDecision = scanner.nextLine();
        if ("yes".equalsIgnoreCase(editDecision)) {
            System.out.println("Enter new session description:");
            String newDescription = scanner.nextLine();
            session.setSessionType(newDescription); // Using setSessionType if setDescription does not exist
            System.out.println("Updated session description: " + session.getSessionType());
        }

        // Approving a session
        System.out.println("\nDo you want to approve the session? (yes/no)");
        String approveDecision = scanner.nextLine();
        if ("yes".equalsIgnoreCase(approveDecision)) {
            session.setStatus(true);
            System.out.println("Session approved: " + session.getStatus());
        }

        // Close the scanner
        scanner.close();
    }
}