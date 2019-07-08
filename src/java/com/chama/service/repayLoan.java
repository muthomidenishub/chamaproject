/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
public class repayLoan extends HttpServlet {

    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             HttpSession session = request.getSession();
                session.removeAttribute("loanRepayMessageID");
                session.removeAttribute("loannotexist");
            //get the supervisor ID
            int memberNatioanlID = Integer.parseInt(request.getParameter("idnumber"));
            int treasurerID = Integer.parseInt(request.getParameter("uniqueT"));
            int status = 0;
            List<ChamaMember> memberD;
            ChamaMember member = new ChamaMember();
            member.setMemberID(memberNatioanlID);
            memberD = DatabaseHandler.ShowMemberDetails(status, memberNatioanlID);
            member.setIdNumber(memberNatioanlID);
            //get the chamaID
              List<chamaModel> chamaDet;
              chamaDet = DatabaseHandler.getChamaDetails(treasurerID);
           
            int chamaID = chamaDet.get(0).getChamaID();
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            //get the loan to display
            //Create it as an arraylist
            List<retrieveLoan> retrieveoan;
            List<retrieveLoan> Aloan;
            //set the parameters of the loan to retrieve the loan
            retrieveLoan loan = new retrieveLoan();
            String reTrievestatus = "true";
            loan.setLoanStatus(reTrievestatus);
            loan.setChamaID(chamaID);
            loan.setMemberidNumber(memberNatioanlID);
           
            String loanrepay_url= "repayloan.jsp";
            session.removeAttribute("amountToBeRapaid");
        session.removeAttribute("interestCharged");
        session.removeAttribute("loanDetails");
        session.removeAttribute("loanedAmount");
            if (memberD.isEmpty()) {
                //remoove session
            
                // HttpSession session = request.getSession();
                String loanRepayMessageID = "ID number is not correct";

                session.setAttribute("loanRepayMessageID", loanRepayMessageID);
                request.getRequestDispatcher(loanrepay_url).forward(request, response);
            }
            if("false".equals(DatabaseHandler.LoanExists(member, treasurerID))){
                session.removeAttribute("loanRepayMessageID");
                 String loannotexist = "Member ID"+""+memberNatioanlID+""+"has no loan";
                    session.setAttribute("loannotexist", loannotexist);
           request.getRequestDispatcher(loanrepay_url).forward(request, response);
            
            
            }
            if("true".equals(DatabaseHandler.LoanExists(member, treasurerID))){
                //remove the sessions.
               
                  //get the loan issued
                  int loanedamount = DatabaseHandler.getIndividualTotalLoans(chama, member);
                  //get paid amount and remaining amount
                  retrieveoan = DatabaseHandler.repayLoan(loan);
                  Aloan = DatabaseHandler.getRepayDate(chamaID, memberNatioanlID);
                  
                  //get the amount repaid
                  int amount = 0;
                  String dateCreated ="";
                  String dateRepay = "";
               for(int i = 0; i < retrieveoan.size();i++){
                    session.removeAttribute("loanRepayMessageID");
                session.removeAttribute("loannotexist");
                amount = retrieveoan.get(i).getLoanedamount();
                //get the dates from the DB
               }
               for(int i = 0 ; i < Aloan.size();i++){
                    dateRepay = Aloan.get(i).getDateRepaid();
                dateCreated = Aloan.get(i).getDateCreated();
               
               
               }
                System.out.println(dateRepay);
                //check the penalties //calculate the interest
                 
               //calculate the dates and penalties if its exceeded
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           //get the machine local Date and compare
            java.util.Date date = new java.util.Date();
        LocalDate dateDue = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
         LocalDate dateRepaid = LocalDate.parse(dateRepay, formatter);
        long days = ChronoUnit.DAYS.between(dateDue,dateRepaid);
        int penalty = 0 ;
        //check if the days are less than date due 
        //penalise
         
             //fetch from the DB
             String col = "pen_charges";
           double Lcharges =  (DatabaseHandler.getCharges(col,chamaID)*(0.01));
           
        if(days < 0){
       penalty = (int) (days * Lcharges * loanedamount);
       String daysToPenalty = "Past Due";
       session.setAttribute("daysToPenalty", daysToPenalty);
      
        
        }else{
         penalty = 0;
         long daysToPenalty = days;
         session.setAttribute("daysToPenalty", daysToPenalty);
        
        }
        //calculate interest charge
       // int interestCharged = (int) (loanedamount * 0.1);
         String colI = "loan_inter";
           double Icharges = (DatabaseHandler.getCharges(col,chamaID) * (0.01));
                  //calculate the interest percentage
                  int interestcharged = (int) (Icharges * loanedamount);
                 //calculate the amount to be repaid
                 //calculate the charges
                  int amountToBeRepaid = (loanedamount + interestcharged)- amount;
                 
                  //add the amount to the loan model
                 session.setAttribute("amountToBeRapaid", amountToBeRepaid);
                 session.setAttribute("interestCharged", penalty);
                 session.setAttribute("loanDetails",retrieveoan );
                 int sess;
                 session.setAttribute("loanedAmount", loanedamount);
                  //calculate the interest
                  //calculate penalties
            
            request.getRequestDispatcher(loanrepay_url).forward(request, response);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(repayLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the amount paid
        //get the loan id
        //extract interests and penalties
        
        int loanid = Integer.parseInt(request.getParameter("loanid"));
        int amount = Integer.parseInt(request.getParameter("amountpaid"));
        int amountExpected = Integer.parseInt(request.getParameter("amountExpected"));
        int amountLoaned = Integer.parseInt(request.getParameter("amountLoaned"));
        int memberID = Integer.parseInt(request.getParameter("national"));
        int superVID = Integer.parseInt(request.getParameter("supid"));
        HttpSession session = request.getSession();
        session.removeAttribute("amountToBeRapaid");
        session.removeAttribute("interestCharged");
        session.removeAttribute("loanDetails");
        session.removeAttribute("loanedAmount");
        
        //get the amount expected
        String repay_url = "repayloan.jsp";
        int condtion = amountExpected - amount ;
        int totalLoanCharges =  0 ;
        retrieveLoan loan = new retrieveLoan();
        loan.setLoanid(loanid);
        if(condtion <= 0){
            try {
                //get the total interests and charges
                totalLoanCharges = amountExpected - amountLoaned;
                System.out.println(loanid);
                //commit to the database
                String status = "false";
                if(DatabaseHandler.payLoan(amountExpected,totalLoanCharges,loanid,status) > 0 ){
                   
                    //clear the loan
                    DatabaseHandler.clearRepaidLoan(loan);
                
                }
                
                if(condtion < 0){
                String message = "pack back ksh : "+ condtion;
                session.setAttribute("payBack", message);
                
                }
                
                request.getRequestDispatcher(repay_url).forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(repayLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else{
            try {
                //repay the loan in chunks
                int amountPaid = 0 ;
                //get chamaID
                  List<chamaModel> chamaDet;
              chamaDet = DatabaseHandler.getChamaDetails(superVID);
           
            int chamaID = chamaDet.get(0).getChamaID();
                //set the paramaeterrs
                loan.setChamaID(loanid);
                loan.setChamaID(chamaID);
                loan.setMemberidNumber(memberID);
                loan.setLoanStatus("true");
                //get chamaID
                List<retrieveLoan> retrieveoan;
                
                retrieveoan = DatabaseHandler.repayLoan(loan);
                //get the current repaid amout in DB
                for(int i = 0; i < retrieveoan.size();i++){
                    amountPaid = retrieveoan.get(i).getLoanedamount();
                
                }
                System.out.println("amount"+amountPaid);
                 System.out.println("amount"+amount);
                amountPaid +=amount;
                String status = "false";
                
                  //modify the database
                if(DatabaseHandler.payLoan(amountPaid, totalLoanCharges, loanid,status) > 0){
                    
                    
                    String message = "pack back ksh : "+ condtion;
                    //send back to the page
                    //if its fully paid delete and set a message
                    
//                    if(){
//                    
//                    
//                    
//                    }
                session.setAttribute("updated", message);
                request.getRequestDispatcher(repay_url).forward(request, response);
                
                
                }
                
              
                
                
                
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(repayLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        
        }
        
       
    }


}
