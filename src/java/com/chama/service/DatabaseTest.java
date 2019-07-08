/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author denis
 */
public class DatabaseTest {
    public static void main(String []  args) throws SQLException, IOException{
       
        String col =  "loan_inter";
      // int  amount = 2;
       int chama = 31;
        //System.out.println((DatabaseHandler.getCharges(col,chama)));
          
        double Icharges =  (DatabaseHandler.getCharges("loan_inter",26)*(0.01));
        
        int l = (int) (100*Icharges);
        System.out.println("com.chama.service.DatabaseTest.main()"+l); 
     
        
        
    
            }
            
       
     
    }


