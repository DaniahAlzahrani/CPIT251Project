/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author hamdah-
 */
public class Customer extends user{
     private ArrayList<Reservation> history = new ArrayList<>() ;
    public void showHistory() {
        System.out.println("Showing customer history.");
       for (int i =0 ; i<history.size();i++){
           System.out.println(history.get(i));
       }
    }

    public void reserveSession(Session session, horse horse , Trainer trainer ) {
        System.out.println("Session " + session.getSessionNumber() + " (" + session.getStatus() + ") reserved for " + this.getName() + ".");
        if (session.getStatus()==true &&horse.getStatus()==true && trainer.getStatus()==true){
        Reservation newReservation = new Reservation(session);  // Assuming constructor Reservation(Session session) exists
        System.out.println("your session is reserved successfullly");
        history.add(newReservation);
       }
        else if (session.getStatus()==true &&horse.getStatus()==true && trainer.getStatus()==false){
            System.out.println("the trainer is not available ");
        }
        else if (session.getStatus()==true &&horse.getStatus()==true && trainer.getStatus()==false){
            System.out.println("the horse is not available ");
        }
        else {
            System.out.println("the session is not available ");
        }
    }

    public String getReservationDetails() {
        return "Reservation details for customer.";
    }
    public String Addrequreinfo(){
       return null ; 
    }
}
