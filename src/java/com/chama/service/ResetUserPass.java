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
public class ResetUserPass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String pass = request.getParameter("pass");
            int supID = Integer.parseInt(request.getParameter("sup"));
            HttpSession session = request.getSession();
            String pass_url ="userResetPassword.jsp"; 
            if(DatabaseHandler.changePassword(supID,pass) > 0){
                String mes = "password changed successfully";
                session.setAttribute("pasChaneg",mes);
                request.getRequestDispatcher(pass_url).forward(request, response);
              
            }else{
            
             String mes = "couldn't change the password";
                session.setAttribute("pasChaneg",mes);
                request.getRequestDispatcher(pass_url).forward(request, response);
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResetUserPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }

   
}
