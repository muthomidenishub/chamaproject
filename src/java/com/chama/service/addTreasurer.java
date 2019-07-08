/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.sql.SQLException;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
public class addTreasurer extends HttpServlet {

   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try {
            int chamaChair = Integer.parseInt(request.getParameter("adminunique"));
            
            
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaChair);
            
            int chamaID = chamaDet.get(0).getChamaID();
            
            if(DatabaseHandler.TreasurerExist(chamaID).equals("true")){
                String mess  = "You can't have more than two treasurers";
                request.setAttribute("tmess", mess);
                
            }else{
            
                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                // Get a Properties object
                Properties props = System.getProperties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.store.protocol", "pop3");
                props.put("mail.transport.protocol", "smtp");
                //set the gmail the sender attributes
                final String username = "muthomi.dev@gmail.com";//
                final String password = "12668800";
                //get the parameters
                String emailAddress = request.getParameter("email");
                String Tusername = request.getParameter("username");
                String Tpassword;
                int adminID = Integer.parseInt(request.getParameter("adminunique"));
                String roleType ="treasurer";
                
                //create a random password
                int passLength = 10;
                Tpassword = UserClass.randomString(passLength);
                //create chama object
                UserClass chamaTreasurer = new UserClass();
                //add user attributes
                chamaTreasurer.setEmailaddress(emailAddress);
                chamaTreasurer.setRole_type(roleType);
                chamaTreasurer.setPassword(Tpassword);
                chamaTreasurer.setUsername(Tusername);
                try {
                    //call database
                    int tresuerID = DatabaseHandler.adddTreasurer(chamaTreasurer);
                    //create the treasurer into the database
                    if(DatabaseHandler.partAddTrea(adminID, tresuerID)> 0){
                        //Send the email
                        //create email subject and text
                        String subject ="My chama solutions password";
                        String text = "Hello<\n>your username is:"+Tusername+"your password is:"+Tpassword;
                        
                        
                        
                        try{
                            
                            Session session = Session.getDefaultInstance(props,
                                    new Authenticator(){
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                            return new PasswordAuthentication(username, password);
                                        }});
                            
                            // -- Create a new message --
                            Message msg = new MimeMessage(session);
                            
                            // -- Set the FROM and TO fields --
                            msg.setFrom(new InternetAddress(username));
                            msg.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(emailAddress,false));
                            msg.setSubject(subject);
                            msg.setText(text);
                            //msg.setSentDate(new Date());
                            Transport.send(msg);
                            System.out.println("Message sent.");
                        }catch (MessagingException e){
                            System.out.println("Erreur d'envoi, cause: " + e);
                            
                        }
                        
                    }
                    
                    String url ="addTreasurer.jsp";
                    //create a request dispatcher
                    //create session
                    String messageString ="success";
                    //  HttpSession session = request.getSession();
                    request.setAttribute("message", messageString);
                    //request.setAttribute("message",chamaTreasurer.getRole_type());
                    request.getRequestDispatcher(url).forward(request, response);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(addTreasurer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(addTreasurer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }

   

