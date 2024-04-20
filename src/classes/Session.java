/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author danih
 */
public class Session {
    private int sessionNumber;
    private String sessionType;
    private String date;

    public void displaySessions() {
        System.out.println("Displaying sessions.");
    }

    public Session getSession() {
        // Return some session
        return this;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }
}
