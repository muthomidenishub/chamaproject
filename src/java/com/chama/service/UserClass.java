package com.chama.service;

import java.io.Serializable;
import java.security.SecureRandom;

public class UserClass implements Serializable{
	
	private String username;
    private String emailaddress;
    private String password;
    private String role_type;
    private int adminId;

    public UserClass() {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    
    
    
    //create getter and setter methods



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }
//generate a random password for the treasurer
    public static String randomString(int len){
        
 String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
SecureRandom rnd = new SecureRandom();
   StringBuilder sb = new StringBuilder(len);
   for( int i = 0; i < len; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
   return sb.toString();
}

    
    
    
    
}
