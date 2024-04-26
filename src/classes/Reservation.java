/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Noura
 */
class Reservation {

    public static ArrayList<Reservation> reserve = new ArrayList<>();
    private String rNumber;
    private Customer customer;     // Association to Customer
    private horse horse;           // Association to Horse
    private Session session;       // Association to Session
    private String date;
    private Trainer trainer;       // Association to Trainer
    private boolean status;

    // Constructor to initialize a Reservation object
    public Reservation(String rNumber, Customer customer, horse horse, Session session, String date, Trainer trainer, boolean status) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer account is required.");
        } else {
            this.rNumber = rNumber;
            this.customer = customer;
            this.horse = horse;
            this.session = session;
            this.date = date;
            this.trainer = trainer;
            this.status = status;
            reserve.add(this); // Add this reservation to the list of all reservations
        }
    }

    // Getters and Setters
    public String getRNumber() {
        return rNumber;
    }

    public void setRNumber(String rNumber) {
        this.rNumber = rNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public horse getHorse() {
        return horse;
    }

    public void setHorse(horse horse) {
        this.horse = horse;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Method to cancel a reservation and remove it from the static list
    public void cancelReservation() {
        this.status = false;
        System.out.println("Reservation " + rNumber + " cancelled.");
        reserve.remove(this);  // Remove this reservation from the static ArrayList
    }

    // Method to reschedule a reservation
    public void rescheduleReservation(String newDate) {
        this.date = newDate;
        this.status = true;
        System.out.println("Reservation " + rNumber + " rescheduled to " + newDate);
    }

    public static void displayAllReservations() {
        if (reserve.isEmpty()) {
            System.out.println("No reservations have been made.");
        } else {
            System.out.println("All Reservations:");
            for (Reservation res : reserve) {
                System.out.println("Reservation Number: " + res.getRNumber() + ", Date: " + res.getDate()
                        + ", Status: " + res.getStatus() + ", Session Status: " + res.getSession().getStatus());
            }
        }
    }

    public Reservation(Session session) {
    }

}
