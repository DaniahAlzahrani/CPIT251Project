/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Hamdah-
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Manger manager = new Manger();

        // Define available sessions and horses
        Session[] sessions = new Session[]{
            new Session(100, "Basic Horse Riding", "2023-12-08", true),
            new Session(101, "Introduction to Horse Riding", "2023-12-10", true),
            new Session(102, "Intermediate Horse Riding", "2023-12-12", true),
            new Session(103, "Advanced Horse Riding", "2023-12-14", true),
            new Session(104, "Expert Horse Riding", "2023-12-16", true)
        };
       

        horse[] horses = new horse[]{
            new horse("A", "Breed1", true),
            new horse("B", "Breed2", true),
            new horse("C", "Breed3", true),
            new horse("D", "Breed4", true),
            new horse("E", "Breed5", true)
        };

        Trainer trainer = new Trainer("Emily Clark", true);

        // Instantiate customer
        Customer customer = new Customer();

        // Adding contact information for the customer
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        customer.AddContactinfo(name, phoneNumber);
        System.out.println("Contact information added.");

        // Select a session
        System.out.println("\nAvailable sessions (only showing available):");
        for (Session s : sessions) {
            if (s.getStatus()) {
                System.out.println(s.getSessionNumber() + ": " + s.getSessionType());
            }
        }
        System.out.println("Enter the session number you want to attend or edit:");
        int sessionChoice = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        Session selectedSession = null;
        for (Session s : sessions) {
            if (s.getSessionNumber() == sessionChoice) {
                selectedSession = s;
                break;
            }
        }

        // Update session details if user desires
        System.out.println("Do you want to update this session details? (yes/no)");
        String updateResponse = scanner.nextLine();
        if ("yes".equalsIgnoreCase(updateResponse)) {
            System.out.println("Enter new session type:");
            String newType = scanner.nextLine();
            System.out.println("Enter new session date (YYYY-MM-DD):");
            String newDate = scanner.nextLine();
            System.out.println("Is the session available? (true/false)");
            boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
            manager.editSession(selectedSession.getSessionNumber(), newType, newDate, newStatus);
        }

        // Select a horse
        System.out.println("\nAvailable horses:");
        for (horse h : horses) {
            System.out.println(h.getName());
        }
        System.out.println("Enter the name of the horse you want to choose:");
        String horseChoice = scanner.nextLine();
        horse selectedHorse = null;
        for (horse h : horses) {
            if (h.getName().equalsIgnoreCase(horseChoice)) {
                selectedHorse = h;
                break;
            }
        }

        // Generate and display the reservation number
        String reservationNumber = "RSV" + (10000 + random.nextInt(90000));
        System.out.println("Your reservation number: " + reservationNumber);

        // Attempt to reserve a session
        System.out.println("Attempting to reserve a session...");
        if (selectedSession != null && selectedHorse != null) {
            customer.reserveSession(reservationNumber, customer, selectedHorse, selectedSession, "2023-12-10", trainer, true);
            System.out.println("Reservation created. Requesting approval from manager...");
            manager.approveReservation(reservationNumber);
        } else {
            System.out.println("Invalid session or horse selection.");
        }

        // Close the scanner
        scanner.close();
    }
}