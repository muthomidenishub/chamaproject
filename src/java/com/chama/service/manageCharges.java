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
public class manageCharges extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String type = request.getParameter("rate");
            int charge = Integer.parseInt(request.getParameter("charge"));
            int chamaSup = Integer.parseInt(request.getParameter("dUnique"));
            //get the chamaID;
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSup);
           
            int chamaID = chamaDet.get(0).getChamaID();
            HttpSession session = request.getSession();
            String charges_url = "Createcharges";
            
            if(type.equals("loanint")){
                //update only lon interest
                   String col =  "loan_inter";
                   if(DatabaseHandler.updateCharges(col, charge, chamaID) > 0){
                       String chargeM = "loan interest updated";
                       session.setAttribute("chargeM", chargeM);
                   request.getRequestDispatcher(charges_url).forward(request, response);
                   }
                System.out.println("loan interest");
                
                
                
            }
            if(type.equals("latecon")){
                
                  String col =  "late_repay";
                   if(DatabaseHandler.updateCharges(col, charge, chamaID) > 0){
                       String chargeM = "late contributions charges updated";
                    session.setAttribute("chargeM", chargeM);
                    request.getRequestDispatcher(charges_url).forward(request, response);
                   }
                
                System.out.println("late con");
                
                
            }
            if(type.equals("penrate")){
                
                  String col =  "pen_charges";
                   if(DatabaseHandler.updateCharges(col, charge, chamaID) > 0){
                       String chargeM = "loan penalty charges updated";
                        session.setAttribute("chargeM", chargeM);
                        request.getRequestDispatcher(charges_url).forward(request, response);
                   
                   }
                
                System.out.println("penalty charges");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(manageCharges.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
