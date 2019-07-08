/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author denis
 */
public class loanModel {
   
    Date dateCreated;
   // String returnDate;
    String repayDate;
    int loanStatus; 
    int interestrate;
    int charges;
    int loanedAmount;

    
     public int getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(int loanStatus) {
        this.loanStatus = loanStatus;
    }


    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public int getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(int interestrate) {
        this.interestrate = interestrate;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }
     public Date getDateCreated() {
	        return dateCreated;
	    }

	    public void setDateCreated(  ) {
	        Calendar cal = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
	        this.dateCreated = startDate;
				

	    }

    public int getLoanedAmount() {
        return loanedAmount;
    }

    public void setLoanedAmount(int loanedAmount) {
        this.loanedAmount = loanedAmount;
    }
            
    
    
}
