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

/**
 *
 * @author denis
 */
public class addMember extends HttpServlet {

   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //response.setContentType("text/plain");
            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String email = request.getParameter("email");
            int phone = Integer.parseInt(request.getParameter("phone"));
            int idnumber = Integer.parseInt(request.getParameter("idnumber"));
            String location = request.getParameter("local");
            int adminUnique = Integer.parseInt(request.getParameter("treasurerUni"));
            //insert the  attributes
            ChamaMember chamaM = new ChamaMember();
            chamaM.setFirstName(firstname);
            chamaM.setLastName(lastname);
            chamaM.setEmailAddress(email);
            chamaM.setIdNumber(idnumber);
            chamaM.setLocation(location);
            chamaM.setPhoneNumber(phone);
            //create active state for the member
            int memberActive = 0;
            chamaM.setMemberStatus(memberActive);
            
            //call the database
            int add = DatabaseHandler.addChamaMember(chamaM, adminUnique);
            if(add > 0){
                
            request.setAttribute(email, add);
               System.out.println("Member added successfully");
               request.setAttribute("addSuc", "member adding success");
             request.getRequestDispatcher("addMember.jsp").forward(request, response);
             
            }else{
            
                   System.out.println("Member added unsuccessful");
              request.getRequestDispatcher("addMember.jsp").forward(request, response);
              
            }
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(addMember.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
