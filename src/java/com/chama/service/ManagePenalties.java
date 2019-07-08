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
public class ManagePenalties extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //create url
            String penalisedMembers_url = "penalisedMembers.jsp";
            //get the attributes to retrieve the penalties
            int chamaSup = Integer.parseInt(request.getParameter("sup"));
            //get status
            int penStatus = 0;
            double Lcharges= 0;
            if(chamaSup > 0){
            
             List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSup);
            int chamaID = chamaDet.get(0).getChamaID();
             //fetch from the DB
             String col = "late_repay";
            Lcharges = DatabaseHandler.getCharges(col,chamaID)*(0.01);
            }
          //fetch from the DB
            int charges = (int) (Lcharges * 100);
            //perform the query
            int page = 1;
           int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        //create pen DAO
        penaltyDao pena = new penaltyDao();
        
            List<penaltyModel> penalisedMembers = pena.viewAllPenalties((page-1)*recordsPerPage,recordsPerPage,chamaSup, penStatus, charges);
            //get the charges and add to the model
            int numberOfRecords = pena.getNoOfRecords();
            int numberOfPages = (int)Math.ceil(numberOfRecords * 1.0 / recordsPerPage);
            //create session and return
            HttpSession session = request.getSession();
           session.setAttribute("penalisedM", penalisedMembers);
        session.setAttribute("numberOfPP", numberOfPages);
        session.setAttribute("currentPP", page);
        
            //forward the session
            request.getRequestDispatcher(penalisedMembers_url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManagePenalties.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url_penalty = "penalisedMembers.jsp";
            //get the member details for loan
            String firstname = request.getParameter("fname");
            String secondname = request.getParameter("lname");
            int penaltyCharges = Integer.parseInt(request.getParameter("penalty"));
            int latecontribution = Integer.parseInt(request.getParameter("lcont"));
            String dateCreated = request.getParameter("datecreated");
            int memberNationalID = Integer.parseInt(request.getParameter("national"));
            int supervisorID =Integer.parseInt(request.getParameter("supid"));
            int pen = Integer.parseInt(request.getParameter("pen"));
            int contr_status = 1;
            String penalty_status = "false";
            
            //
            MemberContribution contr = new MemberContribution();
            contr.setAmount(latecontribution);
            contr.setPenaltyStatus(penalty_status);
            contr.setContributeStatus(contr_status);
            contr.setContr_id(pen);
            ChamaMember member = new ChamaMember();
            member.setIdNumber(memberNationalID);
            //get chama id
             List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(supervisorID);
            int chamaID = chamaDet.get(0).getChamaID();
            
            //create penalty repay
            penaltyModel penaltyrepay = new penaltyModel();
            penaltyrepay.setAmountCharged(penaltyCharges);
            //format the date to date
            penaltyrepay.setDateCreated(dateCreated);
            penaltyrepay.setIdnumber(memberNationalID);
            penaltyrepay.setChamaID(chamaID);
          penaltyrepay.setSecondname(secondname);
          penaltyrepay.setFirstname(firstname);
            //get chama
            
            //repay and charge the contribution
           int commit =  DatabaseHandler.clearPenalty(contr, penaltyrepay, member, supervisorID);
           if(commit > 0){
               request.getRequestDispatcher(url_penalty).forward(request, response);
           
           
           
           }
        } catch (SQLException ex) {
            Logger.getLogger(ManagePenalties.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
      
    }

   
   
}
