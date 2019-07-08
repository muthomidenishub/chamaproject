/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class MemberController extends HttpServlet {

   
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "Members.jsp";
        String action = request.getParameter("action");
        if(action.equals("modify")){
            
            try {
                String firstname = request.getParameter("fname");
                String lastname = request.getParameter("lname");
                String location = request.getParameter("location");
                String emailAddress = request.getParameter("email");
                int phone = Integer.parseInt(request.getParameter("phone"));
                int memberID = Integer.parseInt(request.getParameter("idnumber"));
                int supervisorID = Integer.parseInt(request.getParameter("uniqueAdmin"));
                
                //create chama
                ChamaMember member = new ChamaMember();
                member.setFirstName(firstname);
                member.setLastName(lastname);
                member.setEmailAddress(emailAddress);
                member.setLocation(location);
                member.setIdNumber(memberID);
                member.setPhoneNumber(phone);
                //call the data base method
              int code =   DatabaseHandler.modifyMemberDetails(member, supervisorID);
                System.out.println(code);
              if(code > 0){
                 String mesMod = "member modify success";
                  HttpSession session = request.getSession();
                  //Set the session
              request.setAttribute("code", mesMod);
             
               request.getRequestDispatcher(url).forward(request, response);
              
              }
              
                
            } catch (SQLException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        
        
        }
        if(action.equals("delete")){
            
            try {
                int memberID = Integer.parseInt(request.getParameter("dUnique"));
                int chairmanID = Integer.parseInt(request.getParameter("adminUnique"));
                
                if(DatabaseHandler.deleteMember(memberID, chairmanID) > 0){
                    String message = "member deleted successfuly";
                    HttpSession session = request.getSession();
                    request.setAttribute("delMess", message);
                            
                       request.getRequestDispatcher(url).forward(request, response);
                
                
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
        
        
        
        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = "Members.jsp";
            
            int treasurerID = Integer.parseInt(request.getParameter("dUnique"));
            int memberID = Integer.parseInt(request.getParameter("idnumber"));
            int status = 1;
            int chairmanID = DatabaseHandler.getChamaAdmin(treasurerID);
            DatabaseHandler.modifyMemberStatus(status, chairmanID, treasurerID, memberID);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
          
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
