/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.sql.Date;

/**
 *
 * @author denis
 */
public class penaltyModel {
    String firstname;
    String secondname;
    int memberaccountID;
    int idnumber;
    int penaltyID;
    int supervisorname;
    int amountCharged;
    String dateCreated;
    int chamaID;
    
    public penaltyModel(){
    
    }
    //create getters and setters method

    public int getMemberaccountID() {
        return memberaccountID;
    }

    public void setMemberaccountID(int memberaccountID) {
        this.memberaccountID = memberaccountID;
    }
    

    public int getPenaltyID() {
        return penaltyID;
    }

    public void setPenaltyID(int penaltyID) {
        this.penaltyID = penaltyID;
    }

    public int getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(int amountCharged) {
        this.amountCharged = amountCharged;
    }
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public int getSupervisorname() {
        return supervisorname;
    }

    public void setSupervisorname(int supervisorname) {
        this.supervisorname = supervisorname;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getChamaID() {
        return chamaID;
    }

    public void setChamaID(int chamaID) {
        this.chamaID = chamaID;
    }
    
    
    
}
