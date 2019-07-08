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
public class manageLoans extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           HttpSession session = request.getSession();
              
            //check if penalty exists if it does do the neccessary
            int memberNatioanlID = Integer.parseInt(request.getParameter("idnumber"));
            int treasurerID = Integer.parseInt(request.getParameter("uniqueT"));
           String cancel = request.getParameter("cancel");
            //int treasurerID = 42;
            int status = 0;
            String loan_url = "loanPage.jsp";
            //check witht the database
              
            List<ChamaMember> memberD;
            ChamaMember member = new ChamaMember();
            memberD = DatabaseHandler.ShowMemberDetails(status, memberNatioanlID);
            member.setIdNumber(memberNatioanlID);
            if (memberD.isEmpty()) {
         //remoove session
             session.removeAttribute("loancreate");
                session.removeAttribute("loanexist");
                   session.removeAttribute("loanfalse");
                // HttpSession session = request.getSession();
                String message = "ID number is not correct";

                session.setAttribute("IDmessage", message);
                request.getRequestDispatcher(loan_url).forward(request, response);
            }
            //check if a loan exist
       if("true".equals(DatabaseHandler.LoanExists(member, treasurerID))) {
           //remove the ID not valid session
           session.removeAttribute("IDmessage");
            session.removeAttribute("loancreate");
            session.removeAttribute("loanfalse");
          String loanStatus = "Member ID number "+memberNatioanlID+" has an existing loan";
           //create loan exist 
           session.setAttribute("loanexist", loanStatus);
           request.getRequestDispatcher(loan_url).forward(request, response);
             
        } 
       if("false".equals(DatabaseHandler.LoanExists(member, treasurerID))){
              session.removeAttribute("IDmessage");
              session.removeAttribute("loancreate");
              session.removeAttribute("loanexist");
              session.removeAttribute("allow");
              
              //create a session for false
              String loanFalse = "false";
             
              //get the amount available for loaning 
               List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(treasurerID);
           
            int chamaID = chamaDet.get(0).getChamaID();
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            int totalContributions = DatabaseHandler.getTotalChamaContribution(chama);
            int totalLoans = DatabaseHandler.getTotalLoans(chama);
            //calculate amount available for lending
            int amountavailableToLend = totalContributions - totalLoans;
            //get the member details
            session.setAttribute("memberdetail",memberD);
             session.setAttribute("loanfalse",loanFalse);
              session.setAttribute("amounttolend",amountavailableToLend);
              request.getRequestDispatcher(loan_url).forward(request, response);
       
       
       }
          
        } catch (SQLException ex) {
            Logger.getLogger(manageLoans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //get the parameters
            
            //int membernationID = Integer.parseInt(request.getParameter("memberid"));
         int memberNatioanlID = Integer.parseInt(request.getParameter("idnum"));
            int chamaSuperv = Integer.parseInt(request.getParameter("supervisorid"));
            String repayDate = request.getParameter("daterepay");
            int loanedAmount = Integer.parseInt(request.getParameter("loan"));
            int loanStatus = 1;
            //get the chamaID
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSuperv);
            int chamaID = chamaDet.get(0).getChamaID();
            //get the chairman ID
            int charmainID = DatabaseHandler.getChamaAdmin(chamaSuperv);
            //set the attributes
            loanModel loan = new loanModel();
            ChamaMember member = new ChamaMember();
            loan.setDateCreated();
            loan.setRepayDate(repayDate);
            loan.setLoanedAmount(loanedAmount);
            loan.setLoanStatus(loanStatus);
            member.setIdNumber(memberNatioanlID);
            //create session
             HttpSession session = request.getSession();
             String loan_url = "loanPage.jsp";
            
            if(DatabaseHandler.createLoan(loan, member, chamaSuperv, chamaID)> 0){
               
                
                //remove the sessions set 
                session.removeAttribute("IDmessage");
                session.removeAttribute("loanexist");
                session.removeAttribute("loanfalse");
                session.removeAttribute("amounttolend");
                session.removeAttribute("memberdetail");
            
            String message = "loan created successfully";
            session.setAttribute("loanmessage", message);
            session.setAttribute("loancreate", message);
            request.getRequestDispatcher(loan_url).forward(request, response);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(manageLoans.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
