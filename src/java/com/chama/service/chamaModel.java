package com.chama.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class chamaModel implements Serializable {
	
	
	 private String chamaName;
	    private Date dateCreated;
	   
	  private int chamaID;
          
	    private int treasurer_id;
	    
	    public chamaModel(){
	    
	    }
	    
	    //create getter and setter methods

    public int getChamaID() {
        return chamaID;
    }

    public void setChamaID(int chamaID) {
        this.chamaID = chamaID;
    }
            

	    public String getChamaName() {
	        return chamaName;
	    }

	    public void setChamaName(String chamaName) {
	        this.chamaName = chamaName;
	    }

	    public Date getDateCreated() {
	        return dateCreated;
	    }

	    public void setDateCreated() {
	        Calendar cal = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
	        this.dateCreated = startDate;
				

	    }

	   


	    public int getTreasurer_id() {
	        return treasurer_id;
	    }

	    public void setTreasurer_id(int treasurer_id) {
	        this.treasurer_id = treasurer_id;
	    }
	    

}
