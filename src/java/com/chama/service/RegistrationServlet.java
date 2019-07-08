package com.chama.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegistrationServlet
 */

public class RegistrationServlet extends HttpServlet {
	
	

	
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		//get the parameters
		String adminName = request.getParameter("username");
		String adminEmail = request.getParameter("emailadd");
		String password = request.getParameter("pass");
		String chamaName = request.getParameter("chama");
		//add default values
		String role_type ="admin";
		//create the classes
		chamaModel chamaMod = new chamaModel();
		
		chamaMod.setDateCreated();
		chamaMod.setChamaName(chamaName);
		//create the user
		UserClass admin = new UserClass();
		admin.setUsername(adminName);
		admin.setEmailaddress(adminEmail);
		admin.setPassword(password);
                admin.setRole_type(role_type);
		//call the database handler
		try {
                    if(DatabaseHandler.insertAdmin(admin, chamaMod) >= 1){
			//DatabaseHandler.insertAdmin(admin, chamaMod);
                        HttpSession session = request.getSession();
                        String message ="Registration is successful";
                        String url ="login.html";
                        session.setAttribute("message", admin);
                        request.setAttribute("message",message);
                        //send the dispatcher back to the servlet
                        request.getRequestDispatcher(url).forward(request, response);
                        System.out.println("in the servlet");
                        
                    }else{
                        System.err.println("err)");
                    }
		} catch (SQLException e) {
                    // TODO Auto-generated catch block

		}
		
	}

}
