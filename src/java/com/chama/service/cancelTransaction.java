/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class cancelTransaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cancel = request.getParameter("cancel");
        HttpSession session = request.getSession();
        String loan_url ="loanPage.jsp";
        if(cancel.equals("cancel")){
         session.removeAttribute("IDmessage");
         session.removeAttribute("loanexist");
            session.removeAttribute("loanfalse");
            session.removeAttribute("amounttolend");
            session.removeAttribute("memberdetail");
            
            session.setAttribute("sera", cancel);
            request.getRequestDispatcher(loan_url).forward(request, response);
      
     }
        
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
