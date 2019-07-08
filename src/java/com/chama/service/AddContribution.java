/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonArray;
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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author denis
 */
public class AddContribution extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            
            
              
            //create url link
            String contrib_url ="addMemberContribution.jsp";
            //fetch the values
            List<chamaModel> chamaDet;
            ChamaMember member = new ChamaMember();
            
            int amaountCont = Integer.parseInt(request.getParameter("contribute"));
            int idNumber = Integer.parseInt(request.getParameter("idnumber"));
            int contribute_status = 1;
            int sta = 0;
            int treasurerID = Integer.parseInt(request.getParameter("uniqueT"));
            chamaDet = DatabaseHandler.getChamaDetails(treasurerID);
           // int chamaID = chamaDet.get(0).getChamaID();
            String penaltyStatus ="false";
            member.setIdNumber(idNumber);
            
            //fetch the amount contributed by the member
            //contribute
            MemberContribution memberContribute = new MemberContribution();
            memberContribute.setAmount(amaountCont);
            memberContribute.setContributeStatus(contribute_status);
            memberContribute.setPenaltyStatus(penaltyStatus);
            //member.setMemberStatus(sta);
           // memberContribute.setPenaltyStatus(penaltyStatus);
           // memberContribute.setDateCreated();
            //ChamaMember memberChama = new ChamaMember();
          //  memberChama.setIdNumber(idNumber);
            System.out.println("com.chama.service.AddContribution.doPost()");
            System.out.println(amaountCont);
            //contribute
            
            int contr = DatabaseHandler.modifyMemberContribution(memberContribute, member, treasurerID);
            session.removeAttribute("IDmessage");
            session.removeAttribute("pen");
            session.removeAttribute("member");
            session.removeAttribute("contrib");
            
            //fetch the values
            if(contr >= 1){
                String message = "Member Contribution added successfully";
                // HttpSession session = request.getSession();
                System.out.println("com.chama.service.AddContribution.doPost()");
                session.setAttribute("conSuccess", message);
                request.getRequestDispatcher(contrib_url).forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddContribution.class.getName()).log(Level.SEVERE, null, ex);
        }

   
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
            
        try {
            HttpSession session = request.getSession();
            
            //check if penalty exists if it does do the neccessary
            int memberNatioanlID =Integer.parseInt(request.getParameter("id"));
            int sup = Integer.parseInt(request.getParameter("uniqueT"));
          //  int treasurerID = Integer.parseInt(request.getParameter("uniqueT"));
            int status = 0;
            String contrib_url ="addMemberContribution.jsp";
            //check witht the database
            //get chamaID
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(sup);
            int chamaID = chamaDet.get(0).getChamaID();
            List<ChamaMember> memberD;
            ChamaMember member = new ChamaMember();
            memberD = DatabaseHandler.ShowMemberDetails(status, memberNatioanlID);
            member.setIdNumber(memberNatioanlID);
            if(memberD.isEmpty() ){
                
                // HttpSession session = request.getSession();
                session.removeAttribute("member");
                session.removeAttribute("pen");
                session.removeAttribute("contrib");
                String message = "ID number is not correct";
               
                session.setAttribute("IDmessages", message);
                request.getRequestDispatcher(contrib_url).forward(request, response);
            
            }
            
            if ( "false".equals(DatabaseHandler.penaltyExists(member,chamaID))) {
             
               member.setIdNumber(memberNatioanlID);
             // int memberContribution = DatabaseHandler.getMemberContribution(chama, member);
                // HttpSession session = request.getSession();
                System.out.println("within no");
                session.removeAttribute("IDmessages");
               
                String mes ="false";
                
                session.setAttribute("pen", mes);
                session.setAttribute("member",memberD);
               // session.setAttribute("contrib", memberContribution);
                
                request.getRequestDispatcher(contrib_url).forward(request, response);
                
                
            }  
            if ( "true".equals(DatabaseHandler.penaltyExists(member,chamaID))) {
                // PrintWriter out = response.getWriter();
                
                // HttpSession session = request.getSession();
                System.out.println("within");
                session.removeAttribute("IDmessages");
                String message = "Please pay your penalty;before proceeding";
                String mes ="yes";
                request.setAttribute("message", message);
                session.setAttribute("pen", mes);
                session.setAttribute("member",memberD);
                
                request.getRequestDispatcher(contrib_url).forward(request, response);
                
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(AddContribution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

