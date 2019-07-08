/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
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
public class approvedLoans extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //show approved loans
            //retrieve and display loans to be approved
            String appLoanUrl = "approveLoan.jsp";
            //get the admin id
            int chamaChairman = Integer.parseInt(request.getParameter("sup"));
            int status = 1;
            //create Chama Model
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaChairman);
           
            int chamaID = chamaDet.get(0).getChamaID();
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            
            //retrieve loan
            List<retrieveLoan> loan = DatabaseHandler.getLoans(chama, status);
            //create session
            HttpSession session = request.getSession();
            //set session with loan values;
            session.setAttribute("apploans", loan);
            
            //calculate the charges
            //get a interest rate from rate table
            //for now use a random value
            
            request.getRequestDispatcher(appLoanUrl).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(approvedLoans.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

}
