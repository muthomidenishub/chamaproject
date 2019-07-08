/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author denis
 */
public class MemberContribution implements Serializable{
    
private String fname;
 private String lname;
private String penaltyStatus;
//private String dateContributed;
private int amount;
private int contributeStatus;
private Date dateCreated;
private String dateContributed;
private int contr_id;
    
    
    //create a non-argumentative constructor
    public MemberContribution(){
    
    
    }

    public String getPenaltyStatus() {
        return penaltyStatus;
    }

    public void setPenaltyStatus(String penaltyStatus) {
        this.penaltyStatus = penaltyStatus;
    }

    
    public int getContributeStatus() {
        return contributeStatus;
    }

    public void setContributeStatus(int contributeStatus) {
        this.contributeStatus = contributeStatus;
    }

   public Date getDateCreated() {
	        return dateCreated;
	    }

	    public void setDateCreated(  ) {
	        Calendar cal = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
	        this.dateCreated = startDate;
				

	    }

    public int getAmount() {
        return amount;
    }

    public String getDateContributed() {
        return dateContributed;
    }

    public void setDateContributed(String dateContributed) {
        this.dateContributed = dateContributed;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getContr_id() {
        return contr_id;
    }

    public void setContr_id(int contr_id) {
        this.contr_id = contr_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
}
