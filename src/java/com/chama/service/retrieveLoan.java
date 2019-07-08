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
public class retrieveLoan {
    String firstName;
    String secondName;
    int loanid ;
    int chamaID;
    int loanedamount;
    int memberidNumber;
    String dateRepaid;
    String dateCreated;
    int interestEarned;
    int loan_profits;
    String loanStatus;
    Date repayDate;
    
    public retrieveLoan() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public int getLoanedamount() {
        return loanedamount;
    }

    public void setLoanedamount(int loanedamount) {
        this.loanedamount = loanedamount;
    }

    public int getMemberidNumber() {
        return memberidNumber;
    }

    public void setMemberidNumber(int memberidNumber) {
        this.memberidNumber = memberidNumber;
    }

    public String getDateRepaid() {
        return dateRepaid;
    }

    public void setDateRepaid(String dateRepaid) {
        this.dateRepaid = dateRepaid;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getInterestEarned() {
        return interestEarned;
    }

    public void setInterestEarned(int interestEarned) {
        this.interestEarned = interestEarned;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate() {
           Calendar cal = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
	        this.repayDate = startDate;
    }

    public int getChamaID() {
        return chamaID;
    }

    public void setChamaID(int chamaID) {
        this.chamaID = chamaID;
    }

    public int getLoan_profits() {
        return loan_profits;
    }

    public void setLoan_profits(int loan_profits) {
        this.loan_profits = loan_profits;
    }
    
    
    
}
