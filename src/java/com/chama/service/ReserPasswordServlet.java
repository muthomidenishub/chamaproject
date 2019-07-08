/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class ReserPasswordServlet extends HttpServlet {

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            //get the email and check if the email exist
            String emailAddress = request.getParameter("email");
            UserClass user = new UserClass();
            user.setEmailaddress(emailAddress);
            HttpSession sessionk = request.getSession();
            String errEmail = "";
            String reset_url="resetPassword.jsp";
            if("false".equals(DatabaseHandler.EmailExist(user))){
                errEmail = "Email provided is not recognized";
                sessionk.setAttribute("err", errEmail);
                request.getRequestDispatcher(reset_url).forward(request, response);
                
            }if("true".equals(DatabaseHandler.EmailExist(user))){
                errEmail = "Check your mail for a reset link";
                sessionk.setAttribute("succ", errEmail);
                //send an email
                //change password
                
                
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
                
               
                String Tpassword;
                //get userid
                int userID = DatabaseHandler.getUserID(emailAddress);
                
                //create a random password
                int passLength = 10;
                Tpassword = UserClass.randomString(passLength);
                //create chama object
                
                try {
                    //call database
                  
                    //create the treasurer into the database
                    if(DatabaseHandler.changePassword(userID, Tpassword)> 0 ){
                        //Send the email
                        //create email subject and text
                        String subject ="My chama solutions password";
                        String text = "Hello "+emailAddress+"has password has been reset to:"+Tpassword;
                        
                        
                        
                        System.out.println(userID);
                            
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
                            
                              String messageString ="success";
                    //  HttpSession session = request.getSession();
                    request.setAttribute("message", messageString);
                    //request.setAttribute("message",chamaTreasurer.getRole_type());
                    request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
                      
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }       catch (AddressException ex) {
                    Logger.getLogger(ReserPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(ReserPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
 
       
    }

    

        } catch (SQLException ex) {
            Logger.getLogger(ReserPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }}}
