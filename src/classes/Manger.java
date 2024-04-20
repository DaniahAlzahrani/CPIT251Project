/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author raneemAljehani
 */
public class Manger extends user {
     public void addSession() {
        System.out.println("Session added.");
    }

    public void deleteSession() {
        System.out.println("Session deleted.");
    }

    public void editSession() {
        System.out.println("Session edited.");
    }

    public void approveReservation() {
        System.out.println("Reservation approved.");
    }

    public void editReservation() {
        System.out.println("Reservation edited.");
    }

    public void report() {
        System.out.println("Report generated.");
    }
}
