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
public class MembersServlet extends HttpServlet {
    
    public MembersServlet(){
    
        super();
    
    }

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        int chamaSup = Integer.parseInt(request.getParameter("sup"));
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        memberDisplayDao member = new memberDisplayDao();
        //create
        List<ChamaMember> chamaMembers = member.viewAllEmployees((page-1)*recordsPerPage,recordsPerPage,chamaSup);
        int numberOfRecords = member.getNoOfRecords();
        int numberOfPages = (int)Math.ceil(numberOfRecords * 1.0 / recordsPerPage);
        HttpSession session = request.getSession();
        //set sessions
        session.setAttribute("memberRecords", chamaMembers);
        session.setAttribute("numberOfPages", numberOfPages);
        session.setAttribute("currentPage", page);
        //forward to the servlet
        String members_url = "Members.jsp";
        request.getRequestDispatcher(members_url).forward(request, response);
        

        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
