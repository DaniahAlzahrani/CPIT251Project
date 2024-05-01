/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author danih
 */
public class Session {

   
    private int sessionNumber;
    private String sessionType;
    private String date;
    private boolean status;
   
    
     public Session(int sessionNumber, String sessionType, String date, boolean status) {
        this.sessionNumber = sessionNumber;
        this.sessionType = sessionType;
        this.date = date;
        this.status = status;
    }
    public boolean getStatus() {
        return status;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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
