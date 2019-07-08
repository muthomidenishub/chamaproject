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
public class deleteMember extends HttpServlet {

  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String url = "approveMemberDel.jsp";
       String action = request.getParameter("action");
       int memberID = Integer.parseInt(request.getParameter("dUnique"));
          int chairmanID = Integer.parseInt(request.getParameter("adminUnique"));
        
    
            
            try {
                
                
                if(DatabaseHandler.deleteMember(memberID, chairmanID) > 0){
                    String message = "member deleted successfuly";
                    HttpSession session = request.getSession();
                    request.setAttribute("message",message);
                            
                       request.getRequestDispatcher(url).forward(request, response);
                
                
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
