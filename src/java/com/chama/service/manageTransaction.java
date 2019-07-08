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
public class manageTransaction extends HttpServlet {

  

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("begin");
            session.removeAttribute("member");
            String contr_url = "addMemberContribution.jsp";
            //also create penalty
            String penalty_status = "true";
            //where the contribution id is 0
            int contribute_status = 0;
            MemberContribution memContr = new MemberContribution();
            memContr.setContributeStatus(contribute_status);
            memContr.setPenaltyStatus(penalty_status);
            int treasurerID = Integer.parseInt(request.getParameter("uniqueID"));
            //Get chama id
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(treasurerID);
            int chamaID = chamaDet.get(0).getChamaID();
            //modify all tables with zero amount an
            DatabaseHandler.penaliseMembers(memContr, chamaID);
            
            request.getRequestDispatcher(contr_url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(manageTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Begin all member transactions
            //get the values of the member id
            //supervsiot id
            int amaountCont = 0;
           
            int contribute_status = 0;
            List<chamaModel> chamaDet;
            int treasurerID = Integer.parseInt(request.getParameter("uniqueID"));
            chamaDet = DatabaseHandler.getChamaDetails(treasurerID);
            int chamaID = chamaDet.get(0).getChamaID();
            String penaltyStatus ="no";
            //create the insertionusing the member details
                 //member status code 
            int memStatus = 0;
            //create chama member
            List<ChamaMember> mem = DatabaseHandler.ShowMembers(memStatus, treasurerID);
            ChamaMember chamaMem = new ChamaMember();
            MemberContribution memberContrib = new MemberContribution();
            //create variable to display success message
            int createSuccess =0;
       
            
            for(int i = 0;i < mem.size() ; i++){
                int memidNumber = mem.get(i).getIdNumber();
                chamaMem.setIdNumber(memidNumber);
                memberContrib.setAmount(amaountCont);
                memberContrib.setContributeStatus(contribute_status);
                memberContrib.setDateCreated();
                memberContrib.setPenaltyStatus(penaltyStatus);
              createSuccess = DatabaseHandler.createMemberContribution(chamaMem, treasurerID, chamaID, memberContrib);
            }
          
            if(createSuccess > 0){
                HttpSession session = request.getSession();
                //set success message
                String beginTrans = "you can add contributions";
                session.setAttribute("begin", beginTrans);
                //create url
                String contr_url = "addMemberContribution.jsp";
                request.getRequestDispatcher(contr_url).forward(request, response);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
