/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class JustServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            
            //get the values from DB
            //set status for actice members
            int chama_supervisor = Integer.parseInt(request.getParameter("sup"));
           // chama_supervisor = 16;
            int statusCode =0;
            List<ChamaMember> members = DatabaseHandler.ShowMembers(statusCode,chama_supervisor);
            
            //create Data Object
            HttpSession session = request.getSession();
            //add the object to session
            int numberOfMembers = 0;
           
            session.setAttribute("members", members);
            
            System.out.println(members);
            //create url
            String url ="Members.jsp";
            
            request.getRequestDispatcher(url).forward(request, response);
            
            
            //
        } catch (SQLException ex) {
            Logger.getLogger(MembersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
}
