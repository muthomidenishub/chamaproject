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

/**
 *
 * @author denis
 */
public class loanApproveServlet extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            //approve the loan
            int loanStatus = 0;
            int chamaChairperson = Integer.parseInt(request.getParameter("supid"));
            int chamaMemberID = Integer.parseInt(request.getParameter("national"));
            String firstname = request.getParameter("fname");
            String secondName = request.getParameter("lname");
            int loadID = Integer.parseInt(request.getParameter("loanid"));
            int repaidAmount  = 0;
            String loanRepStatus = "true";
            int loanProfits = 0;
            
            //get chamaID
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaChairperson);
            int chamaID = chamaDet.get(0).getChamaID();
            //creaate models
            loanModel loan = new loanModel();
            loan.setLoanStatus(loanStatus);
            ChamaMember member = new ChamaMember();
            member.setIdNumber(chamaMemberID);
            //create chama
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            //create a loan
            //update loan status
             //cre   String url= "approveLoan.jsp";ate dispatcher an a message
             //create loan repay model
             retrieveLoan loanRepay =  new retrieveLoan();
             //set the methods
             loanRepay.setRepayDate();
             loanRepay.setFirstName(firstname);
             loanRepay.setSecondName(secondName);
             loanRepay.setLoanid(loadID);
             loanRepay.setLoan_profits(loanProfits);
             loanRepay.setMemberidNumber(chamaMemberID);
             loanRepay.setLoanedamount(repaidAmount);
             loanRepay.setChamaID(chamaID);
             loanRepay.setLoanStatus(loanRepStatus);
             
            String url= "approveLoan.jsp";
           if( DatabaseHandler.approveLoan(chama, member, loan) > 0 && DatabaseHandler.commitLoan(loanRepay) > 0 ){
              
                String message = "loan approved successfully";
            request.setAttribute("message",message);
            request.getRequestDispatcher(url).forward(request, response);
               
           }
            
           
           
        } catch (SQLException ex) {
            Logger.getLogger(loanApproveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

}
